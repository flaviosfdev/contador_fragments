package br.com.fsdev.contadorfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), PlusFragment.IPlusFragment, MinusFragment.IMinusFragment,
    ResetFragment.IResetFragment, CounterFragment.ICounterFragment {

    private lateinit var plusContainer: FrameLayout
    private lateinit var minusContainer: FrameLayout
    private lateinit var resetContainer: FrameLayout
    private lateinit var clickContainer: FrameLayout
    private lateinit var counterContainer: FrameLayout

    private var plusFragment = PlusFragment()
    private var minusFragment = MinusFragment()
    private var resetFragment = ResetFragment()
    private var clicksFragment = ClicksFragment()
    private var counterFragment = CounterFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        inflateFragments()
    }


    private fun initViews() {
        setContentView(R.layout.activity_main)
        plusContainer = findViewById(R.id.container_plus)
        minusContainer = findViewById(R.id.container_minus)
        resetContainer = findViewById(R.id.container_reset)
        clickContainer = findViewById(R.id.container_click)
        counterContainer = findViewById(R.id.container_count)
    }


    private fun inflateFragments() {
        setFragment(plusContainer, plusFragment)
        setFragment(minusContainer, minusFragment)
        setFragment(resetContainer, resetFragment)
        setFragment(clickContainer, clicksFragment)
        setFragment(counterContainer, counterFragment)
    }


    private fun setFragment(container: FrameLayout, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(container.id, fragment)
            .commit()
    }


    override fun sum(number: Int) {
        setVisibilityContainers(true)
        setCounterAndSetClick(number)
    }


    override fun subtraction(number: Int) {
        setVisibilityContainers(true)
        setCounterAndSetClick(number)
    }


    override fun reset(number: Int) {
        setVisibilityContainers(false)
        setCounterAndSetClick(number)
    }


    override fun setVisibilityResetContainer(bool: Boolean) {
        resetContainer.isVisible = bool
            .also { counterContainer.isVisible = bool }

    }


    private fun setCounterAndSetClick(number: Int) {
        counterFragment.setCounter(number)
        clicksFragment.setCounterClicks(number)
    }


    private fun setVisibilityContainers(bool: Boolean) {
        resetContainer.isVisible = bool
        clickContainer.isVisible = bool
        counterContainer.isVisible = bool
    }

}