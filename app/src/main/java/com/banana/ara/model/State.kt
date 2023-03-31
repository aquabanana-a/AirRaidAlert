package com.banana.ara.model

import kotlinx.datetime.Instant

data class State(
    val type: StateType,
    val isAirRaidAlert: Boolean,
    val updateDateTime: Instant?)