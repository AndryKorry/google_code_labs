package com.vynokurov.calc

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.vynokurov.affirmations.AffirmationsActivity
import com.vynokurov.app_bus_schedule.AppBusSchedulerActivity
import com.vynokurov.app_mars.AppMarsActivity
import com.vynokurov.calc.home.adapter.AppsAdapter
import com.vynokurov.calc.home.adapter.AppsClickListener
import com.vynokurov.calc.home.data.AppsDataSource
import com.vynokurov.cupcakeapp.CupcakeActivity
import com.vynokurov.dogglers.DogglersActivity
import com.vynokurov.sportsapp.SportsActivity
import com.vynokurov.unscramble.UnscrambleActivity
import com.vynokurov.wordsapp.ui.activities.WordsAppMainActivity

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
            com.vynokurov.tiptime.R.string.app_tip_time_name ->
                startActivity(Intent(this, com.vynokurov.tiptime.TipTimeActivity::class.java))
            com.vynokurov.affirmations.R.string.app_affirmations_name ->
                startActivity(Intent(this, AffirmationsActivity::class.java))
            com.vynokurov.dogglers.R.string.app_dogglers_name ->
                startActivity(Intent(this, DogglersActivity::class.java))
            com.vynokurov.wordsapp.R.string.app_words_name ->
                startActivity(Intent(this, WordsAppMainActivity::class.java))
            com.vynokurov.unscramble.R.string.app_unscramble_name ->
                startActivity(Intent(this, UnscrambleActivity::class.java))
            com.vynokurov.cupcakeapp.R.string.app_cupcake_name ->
                startActivity(Intent(this,CupcakeActivity::class.java))
            com.vynokurov.app_sports.R.string.app_sports_name ->
                startActivity(Intent(this,SportsActivity::class.java))
            com.vynokurov.app_mars.R.string.app_mars_name ->
                startActivity(Intent(this,AppMarsActivity::class.java))
            com.vynokurov.app_bus_schedule.R.string.app_bus_schedule_name ->
                startActivity(Intent(this, AppBusSchedulerActivity::class.java))
        }
    }
}