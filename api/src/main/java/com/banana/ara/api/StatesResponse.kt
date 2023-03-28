package com.banana.ara.api

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StatesResponse(
    @SerialName("states") val states: List<State>,
    @SerialName("last_update") val updateDateTime: Instant?,
)