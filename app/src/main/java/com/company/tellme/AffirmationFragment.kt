package com.company.tellme

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

private const val LAST_RANDOMIZED_VALUE_AFIRMATION="LAST_RANDOMIZED_VALUE_AFIRMATION"

class AffirmationFragment : Fragment() {

    private lateinit var resultTextView: TextView
    private lateinit var affirmationday: Button

    private var pos = 0

    val phrases = listOf<String>(
        "Я принимаю и люблю себя таким, какой я есть.",
        "Меня поддерживает вселенная.",
        "Я здоров, энергичен и полон счастья.",
        "Все в моей жизни приведёт к чему-то хорошему.",
        "Я становлюсь мудрее с каждым днём.",
        "Я благодарен за все, что происходит в моей жизни.",
        "Все, что я ищу - я нахожу.",
        "Люблю себя и прекрасно себя чувствую.",
        "Я прощаю всех, кто причинил мне боль в прошлом.",
        "Я верю, что могу все.",
        "Сегодня меня переполняет позитивный настрой.",
        "Я прекрасный человек, потому что я - это я.")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_affirmation, container, false)

        resultTextView = view.findViewById(R.id.result_text_view)
        affirmationday = view.findViewById(R.id.affirmation_button)

        savedInstanceState?.let { pos = it.getInt(LAST_RANDOMIZED_VALUE_AFIRMATION) }
        resultTextView.text = phrases[pos]

        affirmationday.setOnClickListener { randomize() }
        return view

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_RANDOMIZED_VALUE_AFIRMATION, pos)
    }


    private fun randomize(){
        pos = Random.nextInt(phrases.size)
        resultTextView.text = phrases[pos]
    }

}