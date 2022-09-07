package com.example.linearlayout_sampleapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val constraintLayoutFragment = ConstraintLayoutFragment()
        val linearLayoutFragment = LinearLayoutFragment()

        // set default fragment at first
        setFragment(linearLayoutFragment)

        findViewById<Button>(R.id.btnLinear).setOnClickListener {
            setFragment(linearLayoutFragment)
        }
        findViewById<Button>(R.id.btnConstraint).setOnClickListener {
            setFragment(constraintLayoutFragment)
        }
    }

    private fun setFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        /*val fragmentTransaction= fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container_view,fragment)
        fragmentTransaction.addToBackStack("SomeName")
        fragmentTransaction.commit()

        or we can write code inside apply like below
        */

        fragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container_view, fragment)
            addToBackStack("SomeName") // we can pass null if we don't need name for future use
            commit()
        }
    }
}