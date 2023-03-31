package com.banana.ara.api

import com.banana.ara.api.history.HistoryInfo
import com.banana.ara.api.state.StateInfoResponse
import com.banana.ara.api.state.StateInfosResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface AirAlertApi {

    companion object {
        private const val API_KEY_GET_STATES = "api/states"
        private const val API_KEY_GET_STATE = "api/states/{id}"
        private const val API_KEY_GET_HISTORY = "api/history"
    }

    @GET(API_KEY_GET_STATES)
    fun getStateInfos(): Observable<StateInfosResponse>

    @GET(API_KEY_GET_STATE)
    fun getStateInfo(@Path("id") id: Int): Observable<StateInfoResponse>

    @GET(API_KEY_GET_HISTORY)
    fun getHistoryInfos(): Observable<List<HistoryInfo>>
}