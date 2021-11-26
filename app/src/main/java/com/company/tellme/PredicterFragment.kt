package com.company.tellme

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

private const val LAST_RANDOMIZED_VALUE_PREDICTER="LAST_RANDOMIZED_VALUE_PREDICTER"

class PredicterFragment : Fragment() {

    private lateinit var predicter_Text_View: TextView
    private lateinit var predicter_button: Button

    private var pos = 0;

    val phrases = listOf<String>(
        "Мне кажется - ДА!",
        "Спроси позже.",
        "Мой ответ - НЕТ.",
        "Пока не ясно,  попробуй снова.",
        "Даже не думай!",
        "Никаких сомнений!",
        "Весьма сомнительно!",
        "Перспективы очень хорошие!",
        "Сконцентрируйся и спроси снова!"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_predicter, container, false)

        predicter_Text_View = view.findViewById(R.id.predicter_text_view)
        predicter_button = view.findViewById(R.id.predicter_button)

        savedInstanceState?.let { pos = it.getInt(LAST_RANDOMIZED_VALUE_PREDICTER) }
        predicter_Text_View.text = phrases[pos]


        predicter_button.setOnClickListener { randomize() }

        return view

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_RANDOMIZED_VALUE_PREDICTER, pos)

    }

    private fun randomize() {

        pos = Random.nextInt(phrases.size)
        predicter_Text_View.text = phrases[pos]

    }
}