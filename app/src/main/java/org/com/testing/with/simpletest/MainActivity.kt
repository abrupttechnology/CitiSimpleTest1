package org.com.testing.with.simpletest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var viewModel = MainViewModel()

    val adapter = RVCustomAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val recyclerview = findViewById<RecyclerView>(R.id.mRecyclerView)
        recyclerview.adapter = adapter

        recyclerview.hasFixedSize()
        recyclerview.layoutManager = LinearLayoutManager(this)

        viewModel.data.observe(this) {
            adapter.setDataList(it as MutableList<Article>)
        }
    }
}
