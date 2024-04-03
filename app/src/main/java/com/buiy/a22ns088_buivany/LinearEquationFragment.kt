package com.buiy.a22ns088_buivany

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.buiy.a22ns088_buivany.databinding.FragmentLinearEquationBinding

class LinearEquationFragment : Fragment() {
    private lateinit var binding: FragmentLinearEquationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLinearEquationBinding.inflate(inflater, container, false)
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
                val aNumber = edtANumber.text.toString()
                val bNumber = edtBNumber.text.toString()

                if(aNumber.isNotEmpty() && bNumber.isNotEmpty() ){
                    if(isNumeric(aNumber) && isNumeric(bNumber)){
                        if(aNumber.toDouble() == 0.0){
                            result.setText("Phương trình vô nghiệm!")
                        }else if(bNumber.toDouble() == 0.0 ){
                            result.setText("X = 0")
                        }else{
                            var rs = 0.0
                            rs = -bNumber.toDouble() / aNumber.toDouble()
                            val roundedRs = String.format("%.3f", rs)
                            result.setText("X = $roundedRs" )
                        }
                    }else{
                        result.setText("Vui lòng nhập đúng dữ liệu!")
                    }
                } else {
                    result.text = "Vui lòng nhập dữ liệu!"
                }
            }
            btnClear.setOnClickListener {
                edtANumber.setText("")
                edtBNumber.setText("")
                txtResult.setText("")
            }
        }
    }

    private fun isNumeric(toCheck: String): Boolean {
        val regex = "-?[0-9]+(\\.[0-9]+)?".toRegex()
        return toCheck.matches(regex)
    }
}
