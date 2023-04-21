package com.vynokurov.calc.home.data

import com.vynokurov.calc.home.model.AppsModel

class AppsDataSource {

    fun loadDataSource(): List<AppsModel> = listOf(
        AppsModel(com.vynokurov.tiptime.R.string.app_tip_time_name),
        AppsModel(com.vynokurov.dogglers.R.string.app_dogglers_name),
        AppsModel(com.vynokurov.wordsapp.R.string.app_words_name),
        AppsModel(com.vynokurov.affirmations.R.string.app_affirmations_name),
        AppsModel(com.vynokurov.unscramble.R.string.app_unscramble_name),
        AppsModel(com.vynokurov.cupcakeapp.R.string.app_cupcake_name),
        AppsModel(com.vynokurov.app_sports.R.string.app_sports_name),
        AppsModel(com.vynokurov.app_mars.R.string.app_mars_name)
    )
}