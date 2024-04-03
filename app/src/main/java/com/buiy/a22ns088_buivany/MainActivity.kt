package com.buiy.a22ns088_buivany

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.buiy.a22ns088_buivany.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(PrimeFragment())

        binding.bottomNavigationView.setOnItemReselectedListener {
            when (it.itemId){
                R.id.bottom_navigation_prime -> replaceFragment(PrimeFragment())
                R.id.bottom_navigation_linear_equation -> replaceFragment(LinearEquationFragment())
                R.id.bottom_navigation_food_manager -> replaceFragment(FoodManagerFragment())

                else ->{

                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}