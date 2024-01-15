package ru.vlistoff.lab3.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.vlistoff.lab3.repository.CardRepository

class CardViewModelFactory(private val repository: CardRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CardViewModel::class.java)) {
            return CardViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}