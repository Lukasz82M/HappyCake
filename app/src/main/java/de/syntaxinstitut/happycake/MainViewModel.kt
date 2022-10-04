package de.syntaxinstitut.happycake

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel (application: Application) :AndroidViewModel(application){
    private const val TAG = "MainViewModel"

    enum class ApiStatus { LOADING, ERROR, DONE }

    class MainViewModel(application: Application) : AndroidViewModel(application) {

//    private val datasource = Datasource()

        private val database = getDatabase(application)

        private val repository = FanRepository(FanApi, database)

//    private val _fans = MutableLiveData<List<Fan>>()
//    val fans: LiveData<List<Fan>>
//        get() = _fans

        val fans = repository.fanList

        private val _loading = MutableLiveData<ApiStatus>()
        val loading: LiveData<ApiStatus>
            get() = _loading


        init {
//        _fans.value = datasource.loadFans()
            loadData()
        }

        private fun loadData() {
            viewModelScope.launch {
                _loading.value = ApiStatus.LOADING
                try {
                    repository.getFans()
                    _loading.value = ApiStatus.DONE
                } catch (e: Exception) {
                    Log.e(TAG, "Error loading Data from API: $e")
                    if (fans.value.isNullOrEmpty()) {
                        _loading.value = ApiStatus.ERROR
                    } else {
                        _loading.value = ApiStatus.DONE
                    }
                }
            }
        }

        fun addToCart() {
            // TODO
        }
    }

}