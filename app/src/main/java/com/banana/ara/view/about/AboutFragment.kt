package com.banana.ara.view.about

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.banana.ara.R
import com.google.android.play.core.review.ReviewManagerFactory
import com.google.android.play.core.review.testing.FakeReviewManager

class AboutFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.rateButton).setOnClickListener {
            requestReviewFlow(requireActivity())
        }
    }

    private fun requestReviewFlow(activity: Activity) {
        val reviewManager = ReviewManagerFactory.create(activity) //FakeReviewManager(activity)
        val requestReviewFlow = reviewManager.requestReviewFlow()

        requestReviewFlow.addOnCompleteListener { request ->
            if (request.isSuccessful) {
                val reviewInfo = request.result
                val flow = reviewManager.launchReviewFlow(activity, reviewInfo)

                flow.addOnCompleteListener {
                    Toast.makeText(activity, "Thank for your feedback!", Toast.LENGTH_LONG).show()
                }

            } else {
                Toast.makeText(activity, "Something went wrong :(", Toast.LENGTH_LONG).show()
            }
        }
    }
}