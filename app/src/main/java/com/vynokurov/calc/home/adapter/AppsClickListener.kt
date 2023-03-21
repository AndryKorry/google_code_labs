package com.vynokurov.calc.home.adapter

import androidx.annotation.StringRes

interface AppsClickListener {
    fun onAppClick(@StringRes name: Int)
}