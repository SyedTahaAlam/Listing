package com.example.productlisting.binding_adapters;

import android.annotation.SuppressLint;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

public class Binding {
    @BindingAdapter({"setValue"})
    public static void setValue(TextView textView, Double value){
         textView.setText(value.toString());
    }

    @BindingAdapter({"setPrice"})
    public static void setPrice(TextView textView, Double value){
         textView.setText("Rs. "+value.toString());
    }
    @BindingAdapter({"loadImage"})
    public static void loadImage(ImageView imageView, String value){
        Picasso.get().load(value).into(imageView);
    }
}
