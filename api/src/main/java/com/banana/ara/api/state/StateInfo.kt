package com.banana.ara.api.state

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StateInfo(
    @SerialName("id") val stateId: Int,
    @SerialName("name") val nameLocalized: String,
    @SerialName("name_en") val name: String,
    @SerialName("alert") val isAirRaidAlert: Boolean,
    @SerialName("changed") val updateDateTime: Instant?,
)