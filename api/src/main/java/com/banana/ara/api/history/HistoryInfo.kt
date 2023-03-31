package com.banana.ara.api.history

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HistoryInfo(
    @SerialName("id") val id: Int,
    @SerialName("date") val updateDateTime: Instant?,
    @SerialName("state_id") val stateId: Int,
    @SerialName("alert") val isAirRaidAlert: Boolean,
)