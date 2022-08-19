package com.example.breakingbadapp.screens.episode.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.breakingbadapp.network.EpisodeProperty

class EpisodeDetailViewModel(episodeProperty: EpisodeProperty, app: Application): AndroidViewModel(app) {
    private val _selectedProperty = MutableLiveData<EpisodeProperty>()
    val selectedProperty: LiveData<EpisodeProperty>
        get() = _selectedProperty

    init {
        _selectedProperty.value = episodeProperty
    }
}
