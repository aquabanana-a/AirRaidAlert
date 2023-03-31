package com.banana.ara.model.mapper

import android.util.Log
import com.banana.ara.api.state.StateInfoResponse
import com.banana.ara.api.state.StateInfosResponse
import com.banana.ara.model.State
import com.banana.ara.model.StateType

object StateResponseToStateMapper {

    private const val TAG = "StateResponseToStateMapper"

    fun transform(response: StateInfoResponse): State? {
        try {
            return State(
                getStateType(response.stateInfo.stateId),
                response.stateInfo.isAirRaidAlert,
                response.stateInfo.updateDateTime)
        }
        catch (e: Exception) { Log.e(TAG, "", e) }
        return null
    }

    fun transform(response: StateInfosResponse): ArrayList<State> {
        val ret = arrayListOf<State>()
        response.stateInfos.forEach { stateInfo ->
            try {
                ret.add(State(
                    getStateType(stateInfo.stateId),
                    stateInfo.isAirRaidAlert,
                    stateInfo.updateDateTime
                ))
            } catch (e: Exception) { Log.e(TAG, "", e) }
        }
        return ret
    }

    private fun getStateType(stateId: Int): StateType = when(stateId) {
        1 -> StateType.Vinnytsia
        2 -> StateType.Volyn
        3 -> StateType.Dnipropetrovsk
        4 -> StateType.Donetsk
        5 -> StateType.Zhytomyr
        6 -> StateType.Zakarpattia
        7 -> StateType.Zaporizhzhia
        8 -> StateType.IvanoFrankivsk
        9 -> StateType.Kyiv
        10 -> StateType.Kirovohrad
        11 -> StateType.Luhansk
        12 -> StateType.Lviv
        13 -> StateType.Mykolaiv
        14 -> StateType.Odesa
        15 -> StateType.Poltava
        16 -> StateType.Rivne
        17 -> StateType.Sumy
        18 -> StateType.Ternopil
        19 -> StateType.Kharkiv
        20 -> StateType.Kherson
        21 -> StateType.Khmelnytskyi
        22 -> StateType.Cherkasy
        23 -> StateType.Chernivtsi
        24 -> StateType.Chernihiv
        25 -> StateType.KyivTown
        26 -> StateType.Crimea
        27 -> StateType.SevastopolTown
        else -> throw Exception("Unknown state id=${stateId}")
    }
}