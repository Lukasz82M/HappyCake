package de.syntaxinstitut.happycake

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import de.syntaxinstitut.happycake.adapter.CakeAdapter
import de.syntaxinstitut.happycake.data.local.getDatabase
import de.syntaxinstitut.happycake.data.model.Cake
import de.syntaxinstitut.happycake.remote.CakeApi
import de.syntaxinstitut.happycake.remote.CakeRepository
import kotlinx.coroutines.launch
import java.lang.Exception

private const val TAG = "MainViewModel"
class MainViewModel(application: Application) : AndroidViewModel(application) {

    enum class ApiStatus { LOADING, ERROR, DONE }
//    private val datasource = Datasource()
    private val database = getDatabase(application)
    private val repository = CakeRepository(CakeApi, database)

    private val _loading = MutableLiveData<ApiStatus>()
    val loading: LiveData<ApiStatus>
    get() = _loading

    val cakes = repository.cakeList

    init {
//        _cake.value = datasource.loadCake()
        loadData()
    }

    fun printName(name: String) {
        Log.d(TAG, "name of the cake: $name")
    }

    fun printImageUri(uri: String) {
        Log.d(TAG, uri)
    }
    fun loadData() {
        viewModelScope.launch {
            repository.getCake()
        }

        fun loadData() {
            viewModelScope.launch {
                _loading.value = ApiStatus.LOADING
                try {
                    repository.getCake()
                    _loading.value = ApiStatus.DONE
                } catch (e: Exception) {
                    Log.e(TAG, "Error loading Data $e")
                    if (cakes.value.isNullOrEmpty()) {
                        _loading.value = ApiStatus.ERROR
                    } else {
                        _loading.value = ApiStatus.DONE

                    }
                }
            }
        }
    }
}

