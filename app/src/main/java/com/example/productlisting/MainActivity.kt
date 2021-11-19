package com.example.productlisting

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.productlisting.adapter.ProductAdapter
import com.example.productlisting.data.model.Product
import com.example.productlisting.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            val binding:ActivityMainBinding  =    DataBindingUtil.setContentView(this,R.layout.activity_main)


        val model: ProductViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(ProductViewModel::class.java)


        model.listOfProduct.observe(this,  Observer<List<Product>> {
          val productAdapter = ProductAdapter(it)
            binding.listProduct.adapter = productAdapter
            binding.listProduct.layoutManager = LinearLayoutManager(this)
        })

       lifecycleScope.launch {
           model.getAllProduct()
       }


    }
}