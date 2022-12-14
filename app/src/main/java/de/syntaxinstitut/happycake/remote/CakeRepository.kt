package de.syntaxinstitut.happycake.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.common.api.Api
import de.syntaxinstitut.happycake.data.local.CakeDatabase
import de.syntaxinstitut.happycake.data.model.Cake
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

const val TAG = "AppRepository"

class CakeRepository (private val cakeApi: CakeApi, private val database: CakeDatabase) {

    //private val _cakeList = MutableLiveData<List<Cake>>()
    val cakeList: LiveData<List<Cake>> = database.cakeDatabaseDao.getAll()
        //get() =_cakeList

    suspend fun getCake() {
        //_cakeList.value = cakeApi.retrofitService.getCake()
        withContext(Dispatchers.IO) {
            val newCakeList = cakeApi.retrofitService.getCake()
            database.cakeDatabaseDao.insertAll(newCakeList)
        }
    }
}

