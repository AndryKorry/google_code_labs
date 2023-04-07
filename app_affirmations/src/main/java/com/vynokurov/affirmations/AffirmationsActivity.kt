package com.vynokurov.affirmations

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.vynokurov.affirmations.adapter.ItemAdapter
import com.vynokurov.affirmations.data.DataSource

class AffirmationsActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_affirmation)
        val dataSet = DataSource().loadDataSource()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, dataSet)
        recyclerView.setHasFixedSize(true)
    }
}