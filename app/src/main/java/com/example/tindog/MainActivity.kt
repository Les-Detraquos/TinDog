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

        //Page swipe
        val recyclerView2 = findViewById<RecyclerView>(R.id.recycler_viewSwipe)
        val ListExampleSwipe = GénérationListDébile2(size=10)
        recyclerView2.adapter = AdapterRclVwSwipe(ListExampleSwipe)
        recyclerView2.layoutManager = LinearLayoutManager (this)
        recyclerView2.setHasFixedSize(true)

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

    private fun GénérationListDébile2(size: Int): List<RclVwSwipe>{

        val list2 = ArrayList<RclVwSwipe>()

        for (i in 0 until size) {
            val drawable = when (i / 1) {
                0 -> R.drawable.chat14
                1 -> R.drawable.chat15
                2 -> R.drawable.chat16
                3 -> R.drawable.chat17
                4 -> R.drawable.chien17
                5 -> R.drawable.teterouge
                6 -> R.drawable.couza
                7 -> R.drawable.nezmoche
                8 -> R.drawable.marsupial
                9 -> R.drawable.chouettecheum

                else -> null
            }
            val item2 = RclVwSwipe(drawable, textnom = "Nom $i")

            list2 += item2
        }





        return list2
    }

}