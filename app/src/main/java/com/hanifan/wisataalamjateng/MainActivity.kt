package com.hanifan.wisataalamjateng

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.hanifan.wisataalamjateng.DetailWisata.Companion.EXTRA_DJ
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapterDJ = AdapterDJ()
    private val listDJ = ArrayList<DJ>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fromResourceToList()

        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapterDJ

        sendDataToDetail()
    }

    @SuppressLint("Recycle")
    private fun fromResourceToList() {
        val resourceImage = resources.obtainTypedArray(R.array.image)
        val resourceName = resources.getStringArray(R.array.nama)
        val resourceLocation = resources.getStringArray(R.array.lokasi)

        for (i in resourceName.indices) {
            val itemDJ = DJ (
                resourceImage.getResourceId(i, -1),
                resourceName[i],
                resourceLocation[i]
            )
            listDJ.add(itemDJ)
        }
        adapterDJ.setData(listDJ)
    }

    private fun sendDataToDetail() {
        adapterDJ.setOnItemClickListener(object : AdapterDJ.OnItemClickListener {
            override fun onItemClicked(dj: DJ) {
                val djParcel = DJ(
                    dj.image,
                    dj.name,
                    dj.location
                )
                val intent = Intent(this@MainActivity, DetailWisata::class.java)
                intent.putExtra(EXTRA_DJ, djParcel)
                startActivity(intent)
            }
        })
    }
}