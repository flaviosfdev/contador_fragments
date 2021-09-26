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

class ZerarFragment : Fragment(), View.OnClickListener {

    interface IZerarFragment {
        fun zerar(numero: Int)
    }

    private lateinit var buttonZerar: Button
    private lateinit var callback: IZerarFragment


    override fun onAttach(context: Context) {
        super.onAttach(context)

        when (context) {
            !is IZerarFragment -> throw RuntimeException("$context >>> Interface não implementada.")
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

        val view: View? = inflater.inflate(R.layout.fragment_zerar, container, false)

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
        buttonZerar = v.findViewById(R.id.button_zerar)
    }


    private fun setListeners() {
        buttonZerar.setOnClickListener(this)
    }


    override fun onClick(view: View) {

        when (view) {
            buttonZerar -> { callback.zerar(0) }
        }

    }

}