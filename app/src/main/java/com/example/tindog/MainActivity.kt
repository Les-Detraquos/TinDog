package com.example.tindog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

//import kotlinx.android.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options)


        // page option
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val ListExample = GénérationListDébile(size = 50)
        recyclerView.adapter = AdapterRclVwOptions(ListExample)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

    }

    private fun GénérationListDébile(size: Int): List<RclVwOptions>{

        val list = ArrayList<RclVwOptions>()

        for (i in 0 until size){
            val logo = R.drawable.ic_clef_marteau
            val item = RclVwOptions(logo, text1 = "Item $i")
            list += item


        }
        return list
    }

}