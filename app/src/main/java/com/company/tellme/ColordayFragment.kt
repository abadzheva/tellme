package com.company.tellme

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random
import android.graphics.drawable.ColorDrawable




private const val LAST_RANDOMIZED_VALUE_COLOR="LAST_RANDOMIZED_VALUE_COLOR"
// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ColordayFragment : Fragment() {


    private lateinit var colorView: View
    private lateinit var changeColorButton: Button


    private var color = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_colorday, container, false)

        colorView = view.findViewById(R.id.color_view)
        changeColorButton = view.findViewById(R.id.color_button)

        savedInstanceState?.let { color = it.getInt(LAST_RANDOMIZED_VALUE_COLOR) }
        colorView.setBackgroundColor(color)

        changeColorButton.setOnClickListener { randomize() }
        return view
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_RANDOMIZED_VALUE_COLOR,color)

    }

    private fun randomize(){
        color = Color.argb(255,Random.nextInt(256),Random.nextInt(256),Random.nextInt(256))
        colorView.setBackgroundColor(color)


    }
}