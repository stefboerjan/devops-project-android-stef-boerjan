package com.example.breakingbadapp.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.breakingbadapp.network.BreakingBadApi
import com.example.breakingbadapp.network.QuoteProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

// class HomeViewModel(
//    val database: BreakingBadDatabaseDao,
//    application: Application
// ) : AndroidViewModel(application) {
//
//    private var viewModelJob = Job()
//
//    override fun onCleared() {
//        super.onCleared()
//        viewModelJob.cancel()
//    }
//
//    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
//
//    private var quote = MutableLiveData<Quote?>()
//
//    val quoteString = convertQuoteToString(quote.value)
//
//    init {
//        initializeHome()
//    }
//
//    private fun initializeHome() {
//        // launch coroutine
//        uiScope.launch {
//            quote.value = getQuoteFromDatabase()
//        }
//    }
//
//    private suspend fun getQuoteFromDatabase(): Quote? {
//        return withContext(Dispatchers.IO) {
//            var quote = database.getRandomQuote()
//            quote
//        }
//    }
//
//    fun onClick() {
//        uiScope.launch {
//            quote.value = getQuoteFromDatabase()
//        }
//    }
// }

class HomeViewModel : ViewModel() {
    private val _status = MutableLiveData<String>()

    val status: LiveData<String>
        get() = _status

    private val _property = MutableLiveData<QuoteProperty>()

    val property: LiveData<QuoteProperty>
        get() = _property

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getQuote()
    }

    private fun getQuote() {
        coroutineScope.launch {
            var getPropertiesDeferred = BreakingBadApi.retrofitService.getRandomQuote()
            try {
                var listResult = getPropertiesDeferred.await()
                if (listResult.size > 0) {
                    _property.value = listResult[0]
                }
                // _status.value = "Success: ${listResult.size} Quote properties retrieved"
            } catch (t: Throwable) {
                _status.value = "Failure: " + t.message
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
