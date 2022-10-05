package de.syntaxinstitut.happycake.remote

import com.squareup.moshi.Moshi
import de.syntaxinstitut.happycake.data.model.Cake
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL = https://public.syntax-institut.de/apps/batch2/Lukasz/data.json


private val moshi = Moshi.Builder()
            .add(KotlinJasonAdapterFactory())
            .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface FanApiService {

    @GET("data.json")
    suspend fun getCake(): List<Cake>
}

object CakeApi {
    val retrofitService: CakeApiService by lazy { retrofit.creator(CakeApiService::class.java) }
}