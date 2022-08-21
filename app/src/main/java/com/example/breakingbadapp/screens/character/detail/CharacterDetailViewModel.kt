package com.example.breakingbadapp.screens.character.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.breakingbadapp.network.CharacterProperty

class CharacterDetailViewModel(characterProperty: CharacterProperty, app: Application) : AndroidViewModel(app) {
    private val _selectedProperty = MutableLiveData<CharacterProperty>()
    val selectedProperty: LiveData<CharacterProperty>
        get() = _selectedProperty

    init {
        _selectedProperty.value = characterProperty
    }
}
