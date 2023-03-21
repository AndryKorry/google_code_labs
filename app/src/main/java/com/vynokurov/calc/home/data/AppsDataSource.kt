package com.vynokurov.calc.home.data

import com.vynokurov.calc.R
import com.vynokurov.calc.home.model.AppsModel

class AppsDataSource {

    fun loadDataSource(): List<AppsModel> = listOf(
        AppsModel(R.string.app_tip_time),
        AppsModel(R.string.app_affirmations),
        AppsModel(R.string.app_dogglers),
        AppsModel(R.string.app_words_with_activity)
    )
}