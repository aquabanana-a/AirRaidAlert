package com.banana.ara.api

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface IAirAlertApi {

    companion object {
        private const val API_KEY_GET_STATES = "api/states"
    }

    @GET(API_KEY_GET_STATES)
    fun getStates(): Observable<StatesResponse>

}