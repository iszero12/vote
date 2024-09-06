package com.doyoung.vote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class VoteFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_vote, container, false)
        val activity = requireActivity() as MainActivity
        activity.setBottomNavVisibility(false)

        rootView.apply {
            val title = arguments?.getString("title")
            val content = arguments?.getString("content")
            val contentView = findViewById<TextView>(R.id.content_view)
            val titleView = findViewById<TextView>(R.id.title_view)
            val backButton = findViewById<Button>(R.id.back_button)
            titleView.text = title
            contentView.text = content
            backButton.setOnClickListener {
                val fragmentManager = parentFragmentManager
                fragmentManager.popBackStack()
                activity.setBottomNavVisibility(true)
            }
            val yesButton = findViewById<ConstraintLayout>(R.id.yes_button)
            val noButton = findViewById<ConstraintLayout>(R.id.no_button)
            yesButton.setOnClickListener {
                GlobalScope.launch {
                    val id = arguments?.getInt("roomId")
                    val context = requireContext()
                    if (id != null) {
                        val result = vote(context, true, id)
                        val aResult = getResults(context, id)
                        if (aResult != null) {
                            withContext(Dispatchers.Main) {
                                val yesBar = findViewById<ConstraintLayout>(R.id.yes_bar)
                                val noBar = findViewById<ConstraintLayout>(R.id.no_bar)
                                val yesPer = findViewById<TextView>(R.id.yes_per)
                                val noPer = findViewById<TextView>(R.id.no_per)
                                val yesLayoutParams = yesBar.layoutParams as ConstraintLayout.LayoutParams
                                yesLayoutParams.matchConstraintPercentWidth = (aResult.yes.toFloat() / (aResult.yes + aResult.no))
                                yesBar.layoutParams = yesLayoutParams
                                val noLayoutParams = noBar.layoutParams as ConstraintLayout.LayoutParams
                                noLayoutParams.matchConstraintPercentWidth = (aResult.no.toFloat() / (aResult.yes + aResult.no))
                                noBar.layoutParams = noLayoutParams
                                val yesPercent = ((aResult.yes.toFloat() / (aResult.yes + aResult.no) * 100).toInt()).toString()
                                val noPercent = ((aResult.no.toFloat() / (aResult.yes + aResult.no) * 100).toInt()).toString()
                                yesPer.text = yesPercent
                                noPer.text = noPercent
                            }
                        }
                    }
                }
            }
            noButton.setOnClickListener {
                GlobalScope.launch {
                    val id = arguments?.getInt("roomId")
                    val context = requireContext()
                    if (id != null) {
                        val result = vote(context, false, id)
                        val aResult = getResults(context, id)
                        if (aResult != null) {
                            withContext(Dispatchers.Main) {
                                val yesBar = findViewById<ConstraintLayout>(R.id.yes_bar)
                                val noBar = findViewById<ConstraintLayout>(R.id.no_bar)
                                val yesPer = findViewById<TextView>(R.id.yes_per)
                                val noPer = findViewById<TextView>(R.id.no_per)
                                val yesLayoutParams = yesBar.layoutParams as ConstraintLayout.LayoutParams
                                yesLayoutParams.matchConstraintPercentWidth = (aResult.yes.toFloat() / (aResult.yes + aResult.no))
                                yesBar.layoutParams = yesLayoutParams
                                val noLayoutParams = noBar.layoutParams as ConstraintLayout.LayoutParams
                                noLayoutParams.matchConstraintPercentWidth = (aResult.no.toFloat() / (aResult.yes + aResult.no))
                                noBar.layoutParams = noLayoutParams
                                val yesPercent = ((aResult.yes.toFloat() / (aResult.yes + aResult.no) * 100).toInt()).toString()
                                val noPercent = ((aResult.no.toFloat() / (aResult.yes + aResult.no) * 100).toInt()).toString()
                                yesPer.text = yesPercent
                                noPer.text = noPercent
                            }
                        }
                    }
                }
            }
        }
        return rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        val activity = requireActivity() as MainActivity
        activity.setBottomNavVisibility(true)
    }
}
