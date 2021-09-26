package br.com.fsdev.contadorfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class CounterFragment : Fragment() {


    private lateinit var textCounter: TextView
    private var counter = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view: View? = inflater.inflate(R.layout.fragment_counter, container, false)

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
        textCounter = v.findViewById(R.id.text_count)
    }


    fun setCounter(number: Int) {

        counter = when (number) {
            1 -> { counter++ }
            -1 -> { counter-- }
            else -> { 0 }
        }

        textCounter.text = "Counter: $counter"
    }

}