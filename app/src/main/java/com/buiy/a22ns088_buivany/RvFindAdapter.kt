package com.buiy.a22ns088_buivany

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.buiy.a22ns088_buivany.databinding.EmpListViewBinding

class RvAdapter(private var list: List<FoodModel>, private val onFoodClick: RvInterface) : RecyclerView.Adapter<RvAdapter.FoodViewHolder>() {

    inner class FoodViewHolder(val binding: EmpListViewBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onFoodClick.OnClickFood(list[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = EmpListViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val currentItem = list[position]
        holder.binding.apply {
            txtId.text = currentItem.foodID
            txtName.text = currentItem.foodName
            txtQuantity.text = currentItem.foodQuantity
            txtPrice.text = currentItem.foodPrice
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
