package com.example.waky

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.random.Random

class WakyViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(uiState(
        allMessages = ArrayList(
            listOf(
                "Guten Morgen!;Ein neuer Tag ist wie ein unbeschriebenes Blatt Papier. Nutze die Gelegenheit, eine großartige Geschichte zu schreiben!",
                "Heute ist dein Tag!;Erlaube dir selbst, heute erfolgreich zu sein. Du hast die Fähigkeiten und die Entschlossenheit, alles zu erreichen, was du dir vornimmst.",
                "Lächle der Welt entgegen!;Ein Lächeln kostet nichts, aber es kann so viel bewirken. Verbreite positive Energie, wohin du auch gehst.",
                "Du bist stark!;Denke daran, dass du jede Herausforderung meistern kannst, die heute auf dich zukommt. Du bist stärker, als du denkst!",
                "Neue Chancen erwarten dich!;Mit dem Sonnenaufgang kommen auch neue Möglichkeiten. Sei offen für das, was der Tag für dich bereithält."
            )
        )


    ))
    val uiState: StateFlow<uiState> = _uiState.asStateFlow()

    fun NewMessage(): String {

        if(uiState.value.allMessages.size == 1) {

            val tempString = uiState.value.allMessages.get(0)

            _uiState.update { currentState ->
                currentState.copy(
                    allMessages = uiState.value.usedMessages
                )
            }

            _uiState.update { currentState ->
                currentState.copy(
                    usedMessages = arrayListOf(tempString)
                )
            }


            return tempString

        } else {

            val randomInt = Random.nextInt(0, uiState.value.allMessages.size)
            val tempString = uiState.value.allMessages.get(randomInt)
            val tempList = uiState.value.allMessages
            val tempListUsed = uiState.value.usedMessages
            tempList.remove(tempString)
            tempListUsed.add(tempString)

            _uiState.update { currentState ->
                currentState.copy(
                    allMessages = tempList
                )
            }

            _uiState.update { currentState ->
                currentState.copy(
                    usedMessages = tempListUsed
                )
            }

            return tempString

        }



    }



}