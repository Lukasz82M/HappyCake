package de.syntaxinstitut.happycake

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import de.syntaxinstitut.happycake.adapter.CakeAdapter
import de.syntaxinstitut.happycake.data.model.Cake
import de.syntaxinstitut.happycake.remote.CakeApi
import de.syntaxinstitut.happycake.remote.CakeRepository
import kotlinx.coroutines.launch
import java.lang.Exception

private const val TAG = "MainViewModel"
class MainViewModel : ViewModel() {

//    private val datasource = Datasource()

    private val repository = CakeRepository(CakeApi)

val cakes = repository.cakeList

    init {
//        _cake.value = datasource.loadCake()
        loadData()
    }

    fun loadData() {
        viewModelScope.launch {
            repository.getCake()
        }
    }

    fun addToCart() {
        // TODO
    }
}

