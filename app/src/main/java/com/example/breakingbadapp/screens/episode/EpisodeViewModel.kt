package com.example.breakingbadapp.screens.episode

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.breakingbadapp.network.BreakingBadApi
import com.example.breakingbadapp.network.EpisodeProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

// class EpisodeViewModel(val database: BreakingBadDatabaseDao, application: Application) : AndroidViewModel(application)
class EpisodeViewModel() : ViewModel() {
    private val _status = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _status

    private val _properties = MutableLiveData<List<EpisodeProperty>>()

    val properties: LiveData<List<EpisodeProperty>>
        get() = _properties

    private val _navigateToSelectedProperty = MutableLiveData<EpisodeProperty>()
    val navigateToSelectedProperty: LiveData<EpisodeProperty>
        get() = _navigateToSelectedProperty

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getEpisodes()
    }

    private fun getEpisodes() {
        coroutineScope.launch {
            var getPropertiesDeferred = BreakingBadApi.retrofitService.getEpisodes()
            try {
                var listResult = getPropertiesDeferred.await()
                if (listResult.isNotEmpty()) {
                    _properties.value = listResult.sortedBy {
                        it.season
                    }
                }
                // _status.value = "Success: ${listResult.size} Episode properties retrieved"
            } catch (t: Throwable) {
                _status.value = "Failure: " + t.message
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun displayPropertyDetails(episodeProperty: EpisodeProperty) {
        _navigateToSelectedProperty.value = episodeProperty
    }

    fun displayPropertyDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }
}
