package br.com.fsdev.contadorfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class CliquesFragment : Fragment() {

    private lateinit var textCliques: TextView
    private var contadorDeCliques = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view: View? = inflater.inflate(R.layout.fragment_cliques, container, false)

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
        textCliques = v.findViewById(R.id.text_cliques)
    }


    fun setContadorDeCliques(numero: Int) {

        when (numero) {
            0 -> { contadorDeCliques = 0 }
            else -> { contadorDeCliques++ }
        }.also { textCliques.text = "Cliques: $contadorDeCliques" }

    }

}