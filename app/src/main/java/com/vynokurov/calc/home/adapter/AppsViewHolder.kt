package com.vynokurov.calc.home.adapter

import android.view.View
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.recyclerview.widget.RecyclerView
import com.vynokurov.calc.R

class AppsViewHolder(
    private val view: View,
    private val listener: AppsClickListener
) : RecyclerView.ViewHolder(view) {

    fun bind(@StringRes appName: Int) {
        view.findViewById<TextView>(R.id.item_title).text = view.context.getText(appName)
        view.setOnClickListener { listener.onAppClick(appName) }
    }

}