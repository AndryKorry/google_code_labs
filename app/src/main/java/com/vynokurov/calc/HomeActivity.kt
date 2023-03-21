package com.vynokurov.calc

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.vynokurov.affirmations.AffirmationsActivity
import com.vynokurov.calc.home.adapter.AppsAdapter
import com.vynokurov.calc.home.adapter.AppsClickListener
import com.vynokurov.calc.home.data.AppsDataSource
import com.vynokurov.dogglers.DogglersActivity
import com.vynokurov.wordsapp.WordsAppMainActivity

class HomeActivity: AppCompatActivity(), AppsClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val dataSet = AppsDataSource().loadDataSource()
        val recyclerView = findViewById<RecyclerView>(R.id.apps_recycler)
        recyclerView.adapter = AppsAdapter(dataSet, this)
        recyclerView.setHasFixedSize(true)
    }

    override fun onAppClick(@StringRes name: Int) {
        when(name) {
            R.string.app_tip_time ->
                startActivity(Intent(this, com.vynokurov.tiptime.TipTimeActivity::class.java))
            R.string.app_affirmations -> startActivity(Intent(this, AffirmationsActivity::class.java))
            R.string.app_dogglers -> startActivity(Intent(this, DogglersActivity::class.java))
            R.string.app_words_with_activity -> startActivity(Intent(this, WordsAppMainActivity::class.java))
        }
    }
    private fun showToast (appName: Int) {
        Toast.makeText(this, getString(appName), Toast.LENGTH_SHORT).show()
    }

}