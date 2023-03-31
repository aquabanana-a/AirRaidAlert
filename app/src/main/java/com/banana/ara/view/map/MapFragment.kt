package com.banana.ara.view.map

import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.banana.ara.R
import com.banana.ara.api.AirAlertApiService
import com.banana.ara.model.StateType
import com.banana.ara.model.mapper.StateResponseToStateMapper
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.datetime.*
import kotlinx.datetime.TimeZone
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*
import java.util.concurrent.TimeUnit

class MapFragment : Fragment() {

    private lateinit var statusImageView: ImageView
    private lateinit var updateTimeTextView: TextView
    private lateinit var mapImageView: ImageView
    private lateinit var mapDrawable: LayerDrawable

    private var colorStateOk = 0
    private var colorStateAlertOld = 0
    private var colorStateAlertNew = 0
    private var colorApiStatusUnknown = 0
    private var colorApiStatusOk = 0
    private var colorApiStatusFail = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        colorStateOk = ContextCompat.getColor(requireContext(), R.color.colorMapStateNormal)
        colorStateAlertOld = ContextCompat.getColor(requireContext(), R.color.colorMapStateAlertOld)
        colorStateAlertNew = ContextCompat.getColor(requireContext(), R.color.colorMapStateAlertNew)

        colorApiStatusUnknown = ContextCompat.getColor(requireContext(), R.color.colorApiStatusUnknown)
        colorApiStatusOk = ContextCompat.getColor(requireContext(), R.color.colorApiStatusOk)
        colorApiStatusFail = ContextCompat.getColor(requireContext(), R.color.colorApiStatusFail)

        statusImageView = view.findViewById(R.id.statusImageView)
        updateTimeTextView = view.findViewById(R.id.updateTimeTextView)
        mapImageView = view.findViewById(R.id.mapImageView)

        mapDrawable = ContextCompat.getDrawable(requireContext(), R.drawable.ic_ukraine_map_composite) as LayerDrawable
        mapImageView.setImageDrawable(mapDrawable)

        // TODO: figure out strange drawer opening lags with big map
        //stretchMapPreserveAspect(view)

        StateType.values().forEach {
           mapDrawable.findDrawableByLayerId(it.id).setTint(ContextCompat.getColor(requireContext(), R.color.colorMapStateNormal))
        }

        val araService = AirAlertApiService()
        Observable.interval(0, 5, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                statusImageView.setColorFilter(colorApiStatusUnknown)
            }
            .flatMap {
                araService.getStates()
            }
            .doOnError {
                statusImageView.setColorFilter(colorApiStatusFail)
            }
            .subscribe { response ->
                val states = StateResponseToStateMapper.transform(response)
                statusImageView.setColorFilter(if (states.isNotEmpty()) colorApiStatusOk else colorApiStatusFail)

                updateTimeTextView.post {
                    updateTimeTextView.text = response.updateDateTime?.toDateTimeString(FormatStyle.SHORT)
                }

                states.forEach { state ->
                    mapDrawable.findDrawableByLayerId(state.type.id).setTint(
                        if (state.isAirRaidAlert) {
                            if (state.updateDateTime == null)
                                colorStateAlertOld
                            else if ((Clock.System.now() - state.updateDateTime).inWholeMinutes > 60)
                                colorStateAlertOld
                            else
                                colorStateAlertNew
                        } else colorStateOk
                    )
                }
            }
    }

    private fun stretchMapPreserveAspect(rootView: View) {
        var globalLayoutListener: ViewTreeObserver.OnGlobalLayoutListener? = null
        globalLayoutListener = ViewTreeObserver.OnGlobalLayoutListener {
            val aspectRatio = 408.0199f / 612.47321f
            var lp = mapImageView.layoutParams
            lp.width = (rootView.measuredWidth * 0.98f/*2% padding*/).toInt()
            lp.height = (lp.width * aspectRatio).toInt()
            mapImageView.layoutParams = lp
            mapImageView.maxWidth = lp.width
            mapImageView.maxHeight = lp.height
            rootView.viewTreeObserver.removeOnGlobalLayoutListener(globalLayoutListener)
        }
        rootView.viewTreeObserver.addOnGlobalLayoutListener(globalLayoutListener)
    }

    private fun Instant.toDateTimeString(formatStyle: FormatStyle = FormatStyle.MEDIUM): String {
        val localDatetime = toLocalDateTime(TimeZone.currentSystemDefault())
        val formatter = DateTimeFormatter.ofLocalizedDateTime(formatStyle)
        return formatter.format(localDatetime.toJavaLocalDateTime())
    }
}