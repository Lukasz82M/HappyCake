package de.syntaxinstitut.happycake.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.common.api.Api
import de.syntaxinstitut.happycake.data.model.Cake

class CakeRepository (private val cakeApi: CakeApi) {

    private val _cakeList = MutableLiveData<List<Cake>>()
    val cakeList: LiveData<List<Cake>>
        get() =_cakeList

    suspend fun getCake() {
        _cakeList.value = cakeApi.retrofitService.getCake()
    }
}

