package br.com.fsdev.contadorfragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import java.lang.NullPointerException
import java.lang.RuntimeException

class MinusFragment : Fragment(), View.OnClickListener {


    interface IMinusFragment {
        fun subtraction(number: Int)
    }


    private lateinit var buttonMinus: Button
    private lateinit var callback: IMinusFragment


    override fun onAttach(context: Context) {
        super.onAttach(context)
        when (context) {
            !is IMinusFragment -> throw RuntimeException("$context >>> Interface não implementada.")
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

        val view: View? = inflater.inflate(R.layout.fragment_minus, container, false)

        when (view) {
            null -> {
                throw NullPointerException("$view >>> Layout inválido.")
            }
            else -> {
                initViews(view)
                setListeners()
            }
        }

        return view
    }


    private fun initViews(v: View) {
        buttonMinus = v.findViewById(R.id.button_minus)
    }


    private fun setListeners() {
        buttonMinus.setOnClickListener(this)
    }


    override fun onClick(view: View) {

        when (view) {
            buttonMinus -> { callback.subtraction(-1) }
        }

    }

}