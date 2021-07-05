package com.example.glideimageloader

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.glideimageloader.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val imageLink = "https://upload.wikimedia.org/wikipedia/commons/4/47/Campbell_Island_Landscape.jpg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        Glide.with(this)
//            .load(imageLink)
//            .fitCenter()
//            .override(300,300)
//            .diskCacheStrategy(DiskCacheStrategy.ALL)
//            .placeholder(R.drawable.ic_launcher_background)
//            .into(binding.image1)

        Glide.with(this)
            .load(imageLink)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    Log.d("tag", "onLoadFailed: $$e")
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    Toast.makeText(this@MainActivity,
                        "Image ready",
                        Toast.LENGTH_LONG).show()
                    return false
                }

            }).into(binding.image1)
    }

}