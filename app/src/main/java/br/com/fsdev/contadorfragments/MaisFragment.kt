package br.com.fsdev.contadorfragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import java.lang.RuntimeException

class MaisFragment : Fragment(), View.OnClickListener {

    interface IMaisFragment {
        fun somar(numero: Int)
    }

    private lateinit var buttonMais: Button
    private lateinit var callback: IMaisFragment


    override fun onAttach(context: Context) {
        super.onAttach(context)
        when (context) {
            !is IMaisFragment -> throw RuntimeException("$context >>> Interface não implementada.")
            else -> callback = context
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view: View? = inflater.inflate(R.layout.fragment_mais, container, false)

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
        buttonMais = v.findViewById(R.id.button_mais)
    }


    private fun setListeners() {
        buttonMais.setOnClickListener(this)
    }


    override fun onClick(view: View) {

        when (view) {
            buttonMais -> { callback.somar(1) }
        }

    }

}