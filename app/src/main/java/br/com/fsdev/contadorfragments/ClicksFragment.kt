package br.com.fsdev.contadorfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ClicksFragment : Fragment() {


    private lateinit var textClicks: TextView
    private var counterClicks = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view: View? = inflater.inflate(R.layout.fragment_clicks, container, false)

        when (view) {
            null -> {
                throw NullPointerException("$view >>> Layout inválido.")
            }
            else -> {
                initViews(view)
            }
        }

        return view
    }


    private fun initViews(v: View) {
        textClicks = v.findViewById(R.id.text_clicks)
    }


    fun setCounterClicks(number: Int) {

        counterClicks = when (number) {
            0 -> { 0 }
            else -> { counterClicks++ }
        }

        textClicks.text = "Clicks: $counterClicks"
    }

}