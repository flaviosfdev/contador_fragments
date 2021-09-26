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

class ResetFragment : Fragment(), View.OnClickListener {

    interface IResetFragment {
        fun reset(number: Int)
    }

    private lateinit var buttonReset: Button
    private lateinit var callback: IResetFragment


    override fun onAttach(context: Context) {
        super.onAttach(context)

        when (context) {
            !is IResetFragment -> throw RuntimeException("$context >>> Interface não implementada.")
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

        val view: View? = inflater.inflate(R.layout.fragment_reset, container, false)

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
        buttonReset = v.findViewById(R.id.button_reset)
    }


    private fun setListeners() {
        buttonReset.setOnClickListener(this)
    }


    override fun onClick(view: View) {

        when (view) {
            buttonReset -> { callback.reset(0) }
        }

    }

}