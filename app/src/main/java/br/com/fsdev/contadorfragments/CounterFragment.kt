package br.com.fsdev.contadorfragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.lang.RuntimeException

class CounterFragment : Fragment() {

    interface ICounterFragment {
        fun setVisibilityResetContainer(bool: Boolean)
    }

    private lateinit var textCounter: TextView
    private var counter = 0
    private lateinit var callback: ICounterFragment


    override fun onAttach(context: Context) {
        super.onAttach(context)
        when (context) {
            !is ICounterFragment -> throw RuntimeException("$context >>> interface não implementada.")
            else -> callback = context
        }
    }


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

        when (number) {
            1 -> counter++
            -1 -> counter--
            else -> counter = 0
        }.also {
            checkReset(counter)
            textCounter.text = "Counter: $counter"
        }

    }


    private fun checkReset(c: Int) {

        if (c == 0) {
            callback.setVisibilityResetContainer(false)
        }

    }

}