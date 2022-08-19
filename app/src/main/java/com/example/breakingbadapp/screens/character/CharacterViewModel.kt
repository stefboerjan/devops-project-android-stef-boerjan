package com.example.breakingbadapp.screens.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.breakingbadapp.network.BreakingBadApi
import com.example.breakingbadapp.network.CharacterProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

// class CharacterViewModel(val database: BreakingBadDatabaseDao, application: Application) : AndroidViewModel(application) {
class CharacterViewModel() : ViewModel() {
    private val _status = MutableLiveData<String>()

    val status: LiveData<String>
        get() = _status

    private val _properties = MutableLiveData<List<CharacterProperty>>()

    val properties: LiveData<List<CharacterProperty>>
        get() = _properties

    private val _navigateToSelectedProperty = MutableLiveData<CharacterProperty>()
    val navigateToSelectedProperty: LiveData<CharacterProperty>
        get() = _navigateToSelectedProperty

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getCharacters()
    }

    private fun getCharacters() {
        coroutineScope.launch {
            var getPropertiesDeferred = BreakingBadApi.retrofitService.getCharacters()
            try {
                var listResult = getPropertiesDeferred.await()
                if (listResult.size > 0) {
                    _properties.value = listResult
                }
                // _status.value = "Success: ${listResult.size} Character properties retrieved"
            } catch (t: Throwable) {
                _status.value = "Failure: " + t.message
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun displayPropertyDetails(characterProperty: CharacterProperty) {
        _navigateToSelectedProperty.value = characterProperty
    }

    fun displayPropertyDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }
}
