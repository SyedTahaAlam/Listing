package com.example.productlisting.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.productlisting.data.model.Product
import com.example.productlisting.databinding.ProductBinding

class ProductAdapter(private val list:List<Product>):  RecyclerView.Adapter<ProductAdapter.ViewHolder>(){


    
    class ViewHolder( val productBinding: ProductBinding): RecyclerView.ViewHolder(productBinding.root)
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder( ProductBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.productBinding.product = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }
}