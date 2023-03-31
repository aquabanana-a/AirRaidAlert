package com.banana.ara.api

import retrofit2.Retrofit
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory

class AirAlertApiService {
    companion object {
        private const val SERVICE_KEY_HEADER = "X-API-Key"
        private const val SERVICE_KEY = "09c83cb0cc9a123bee41b274ed8df656c3c0af8f"
        private const val SERVICE_BASE_URL = "https://alerts.com.ua/"
        private val SERVICE_MEDIA_TYPE = MediaType.get("application/json")
    }

    private val httpClient = OkHttpClient.Builder().run {
        addInterceptor { chain ->
            val original = chain.request()
            val request = original.newBuilder()
                .header(SERVICE_KEY_HEADER, SERVICE_KEY)
                .method(original.method(), original.body())
                .build()
            chain.proceed(request)
        }
        build()
    }

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory(SERVICE_MEDIA_TYPE))
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .baseUrl(SERVICE_BASE_URL)
        .client(httpClient)
        .build()

    private val alertApi = retrofit.create(AirAlertApi::class.java)

    fun getStates() = alertApi.getStateInfos()

    fun getState(id: Int) = alertApi.getStateInfo(id)

    fun getHistory() = alertApi.getHistoryInfos()
}