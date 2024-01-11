package com.example.waky

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.waky.ui.theme.WakyTheme
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WakyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun WakyMainScreen(modifier: Modifier = Modifier, wakyViewModel: WakyViewModel = viewModel()) {

    Card() {
        TodaysMessage(message = wakyViewModel.NewMessage())
    }

}

@Composable
fun TodaysMessage(modifier: Modifier = Modifier, message: String) {

    val headline = message.substring(0, message.indexOf(";"))
    val subText = message.substring(message.indexOf(";") + 1, message.length)

    Column() {

        Text(
            text = headline
        )

        Text(
            text = subText
        )
    }


}

@Preview(showBackground = true)
@Composable
fun showElements(modifier: Modifier = Modifier) {

    WakyTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            WakyMainScreen()
        }
    }

}
