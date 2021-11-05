package com.hanifan.wisataalamjateng

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_wisata.*

class DetailWisata : AppCompatActivity() {

    companion object {
        const val EXTRA_DJ = "extra_dj"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_wisata)

        val intent = intent.getParcelableExtra<DJ>(EXTRA_DJ)

        Glide.with(this).load(intent?.image).into(detail_image)
        detail_name.text = intent?.name
        detail_location.text = intent?.location
    }
}