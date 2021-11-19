package com.example.productlisting

import android.app.Application
import androidx.lifecycle.*
import com.example.productlisting.data.model.Api
import com.example.productlisting.data.model.Product
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductViewModel(private val context: Application): AndroidViewModel(context) {


    var listOfProduct: MutableLiveData<List<Product>> = MutableLiveData<List<Product>>()

    suspend fun getAllProduct()  {

             val call = Api().getAllProduct()

             call.enqueue(object : Callback<List<Product>> {
                 override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                     if (response.isSuccessful) {
                         if (response.body()!!.count() != 0) {
                             setValue(response.body()!!)
                         }
                     }
                 }

                 override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                     logError(t.toString())
                 }
             })


     }

    private fun setValue(body: List<Product>) {
        listOfProduct.setValue(body)
    }



    private fun logError(errorString: String) {
        print("productViewModel: error $errorString")
    }

}