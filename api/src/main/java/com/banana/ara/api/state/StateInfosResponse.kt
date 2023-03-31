package com.banana.ara.api.state

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StateInfosResponse(
    @SerialName("states") val stateInfos: List<StateInfo>,
    @SerialName("last_update") val updateDateTime: Instant?,
)