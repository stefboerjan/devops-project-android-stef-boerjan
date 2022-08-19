package com.example.breakingbadapp.screens.character.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.breakingbadapp.network.CharacterProperty

class CharacterDetailViewModelFactory(
    private val characterProperty: CharacterProperty,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharacterDetailViewModel::class.java)) {
            return CharacterDetailViewModel(characterProperty, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
