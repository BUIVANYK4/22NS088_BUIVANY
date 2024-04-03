package com.buiy.a22ns088_buivany

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.buiy.a22ns088_buivany.databinding.FragmentPrimeBinding
import kotlin.math.sqrt


class PrimeFragment : Fragment() {
    private lateinit var binding: FragmentPrimeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPrimeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addEvents()
    }

    private fun addEvents() {
        binding.apply {
            btnCheck.setOnClickListener{
                val result = txtResult
                val numberText = edtPrime.text.toString()

                if(numberText.isNotEmpty()){
                    if(isNumeric(numberText)){
                        if(isPrime(numberText.toInt())){
                            result.text = "$numberText là số nguyên tố!"
                        } else {
                            result.text = "$numberText không phải số nguyên tố!"
                        }
                    }else{
                        result.setText("Vui lòng nhập đúng dữ liệu!")
                    }
                } else {
                    result.text = "Vui lòng nhập dữ liệu!"
                }
            }
            btnClear.setOnClickListener {
                edtPrime.setText("")
                txtResult.setText("")
            }
        }
    }

    private fun isNumeric(toCheck: String): Boolean {
        val regex = "-?[0-9]+(\\.[0-9]+)?".toRegex()
        return toCheck.matches(regex)
    }

    private fun isPrime(number: Int): Boolean {
        if (number < 2)
            return false

        for (i in 2..sqrt(number.toDouble()).toInt()) {
            if (number % i == 0) {
                return false
            }
        }
        return true
    }
}
