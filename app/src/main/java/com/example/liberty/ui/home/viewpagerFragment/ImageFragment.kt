package com.example.liberty.ui.home.viewpagerFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.liberty.R

class ImageFragment(private val imageUrl: String) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_image_page, container, false)
        val imageView = view.findViewById<ImageView>(R.id.imageView)

        // Load the image from the URL using a library (e.g., Picasso, Glide, Coil)
        Glide.with(this)
            .load(imageUrl)
            .into(imageView)

        return view
    }
}