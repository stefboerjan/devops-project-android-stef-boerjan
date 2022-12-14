package com.example.breakingbadapp.screens.episode.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.breakingbadapp.network.EpisodeProperty

class EpisodeDetailViewModelFactory(
    private val episodeProperty: EpisodeProperty,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EpisodeDetailViewModel::class.java)) {
            return EpisodeDetailViewModel(episodeProperty, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
