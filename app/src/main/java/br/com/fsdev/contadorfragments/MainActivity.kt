package br.com.fsdev.contadorfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), MaisFragment.IMaisFragment, MenosFragment.IMenosFragment,
    ZerarFragment.IZerarFragment, ContadorFragment.IContadorFragment {

    private lateinit var containerMais: FrameLayout
    private lateinit var containerMenos: FrameLayout
    private lateinit var containerZerar: FrameLayout
    private lateinit var containerCliques: FrameLayout
    private lateinit var containerContador: FrameLayout

    private var maisFragment = MaisFragment()
    private var menosFragment = MenosFragment()
    private var zerarFragment = ZerarFragment()
    private var cliquesFragment = CliquesFragment()
    private var contadorFragment = ContadorFragment()

    private var reset = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("reset", "entrei no onCreate. Reset: $reset")
        initViews()
        inflateFragments()
    }


    override fun onStart() {
        super.onStart()
        Log.i("reset", "entrei no onStart. Reset: $reset")
        when (reset) {
            0 -> {
                setVisibilidadeContainers(false)
                reset++
                Log.i("reset", "reset incrementado. Reset: $reset")
            }
        }
        Log.i("reset", "saí do onStart. Reset: $reset")
    }


    private fun initViews() {
        setContentView(R.layout.activity_main)
        containerMais = findViewById(R.id.container_mais)
        containerMenos = findViewById(R.id.container_menos)
        containerZerar = findViewById(R.id.container_zerar)
        containerCliques = findViewById(R.id.container_cliques)
        containerContador = findViewById(R.id.container_contador)
    }


    private fun inflateFragments() {
        setFragment(containerMais, maisFragment)
        setFragment(containerMenos, menosFragment)
        setFragment(containerZerar, zerarFragment)
        setFragment(containerCliques, cliquesFragment)
        setFragment(containerContador, contadorFragment)
    }


    private fun setVisibilidadeContainers(bool: Boolean) {
        containerZerar.isVisible = bool
        containerCliques.isVisible = bool
        containerContador.isVisible = bool
    }


    private fun setFragment(container: FrameLayout, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(container.id, fragment)
            .commit()
    }


    private fun setContadorerECliques(numero: Int) {
        contadorFragment.setContador(numero)
        cliquesFragment.setContadorDeCliques(numero)
    }


    override fun somar(numero: Int) {
        setVisibilidadeContainers(true)
        setContadorerECliques(numero)
    }


    override fun subtrair(numero: Int) {
        setVisibilidadeContainers(true)
        setContadorerECliques(numero)
    }


    override fun zerar(numero: Int) {
        setVisibilidadeContainers(false)
        setContadorerECliques(numero)
    }


    override fun setVisibilidadeContainerZerar(bool: Boolean) {
        containerZerar.isVisible = bool
            .also { containerContador.isVisible = bool }

    }


    override fun onPause() {
        super.onPause()
        Log.i("reset", "entrei no onPause. Reset: $reset")
    }

    override fun onStop() {
        super.onStop()
        Log.i("reset", "entrei no onStop. Reset: $reset")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("reset", "voltando do onStop. entrei no onRestart. Reset: $reset")
    }

    override fun onResume() {
        super.onResume()
        Log.i("reset", "estou no onResume, posso interagir. Reset: $reset")
    }
}