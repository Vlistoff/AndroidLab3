package ru.vlistoff.lab3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.vlistoff.lab3.model.Card
import ru.vlistoff.lab3.repository.CardRepository

class CardViewModel(private val repository: CardRepository) : ViewModel() {

    private val _cards = MutableLiveData<List<Card>>()
    val cards: LiveData<List<Card>>
        get() = _cards

    init {
        loadCards()
    }

    private fun loadCards() {
        repository.getCards { cards ->
            _cards.postValue(cards!!)
        }
    }
}
