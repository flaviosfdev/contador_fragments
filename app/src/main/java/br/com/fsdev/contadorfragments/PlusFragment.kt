package br.com.fsdev.contadorfragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import java.lang.RuntimeException

class PlusFragment : Fragment(), View.OnClickListener {


    interface IPlusFragment {
        fun sum(number: Int)
    }


    private lateinit var buttonPlus: Button
    private lateinit var callback: IPlusFragment


    override fun onAttach(context: Context) {
        super.onAttach(context)
        when (context) {
            !is IPlusFragment -> throw RuntimeException("$context >>> Interface não implementada.")
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

        val view: View? = inflater.inflate(R.layout.fragment_plus, container, false)

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
        buttonPlus = v.findViewById(R.id.button_plus)
    }


    private fun setListeners() {
        buttonPlus.setOnClickListener(this)
    }

    override fun onClick(view: View) {

        when (view) {
            buttonPlus -> { callback.sum(1) }
        }

    }

}