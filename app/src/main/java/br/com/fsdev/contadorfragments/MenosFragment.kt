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

class MenosFragment : Fragment(), View.OnClickListener {

    interface IMenosFragment {
        fun subtrair(numero: Int)
    }

    private lateinit var buttonMenos: Button
    private lateinit var callback: IMenosFragment


    override fun onAttach(context: Context) {
        super.onAttach(context)
        when (context) {
            !is IMenosFragment -> throw RuntimeException("$context >>> Interface não implementada.")
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

        val view: View? = inflater.inflate(R.layout.fragment_menos, container, false)

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
        buttonMenos = v.findViewById(R.id.button_menos)
    }


    private fun setListeners() {
        buttonMenos.setOnClickListener(this)
    }


    override fun onClick(view: View) {

        when (view) {
            buttonMenos -> { callback.subtrair(-1) }
        }

    }

}