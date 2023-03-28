package com.banana.ara.api

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class State(
    @SerialName("id") val stateId: Int,
    @SerialName("name") val nameLocalized: String,
    @SerialName("name_en") val name: String,
    @SerialName("alert") val isAirRaidAlert: Boolean,
    @SerialName("changed") val updateDateTime: Instant?,
)

//        {
//      "id": 1,
//      "name": "Вінницька область",
//      "name_en": "Vinnytsia oblast",
//      "alert": false,
//      "changed": "2022-04-05T06:12:52+03:00"
//    }