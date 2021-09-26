package br.com.fsdev.contadorfragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.lang.RuntimeException

class ContadorFragment : Fragment() {

    interface IContadorFragment {
        fun setVisibilidadeContainerZerar(bool: Boolean)
    }

    private lateinit var textContador: TextView
    private var contador = 0
    private lateinit var callback: IContadorFragment


    override fun onAttach(context: Context) {
        super.onAttach(context)
        when (context) {
            !is IContadorFragment -> throw RuntimeException("$context >>> interface não implementada.")
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

        val view: View? = inflater.inflate(R.layout.fragment_contador, container, false)

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
        textContador = v.findViewById(R.id.text_contador)
    }


    fun setContador(numero: Int) {

        when (numero) {
            1 -> contador++
            -1 -> contador--
            else -> contador = 0
        }.also {
            setVisibilidadeContainerZerar(contador)
            textContador.text = "Contador: $contador"
        }

    }


    private fun setVisibilidadeContainerZerar(contador: Int) {

        if (contador == 0) {
            callback.setVisibilidadeContainerZerar(false)
        }

    }

}