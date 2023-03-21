package com.vynokurov.calc.home.adapter

import androidx.annotation.StringRes
import androidx.recyclerview.widget.RecyclerView
import com.vynokurov.calc.databinding.AppsItemBinding

class AppsViewHolder(
    private val binding: AppsItemBinding,
    private val listener: AppsClickListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(@StringRes appName: Int) = with(binding) {
        itemTitle.text = binding.root.context.getText(appName)
        root.setOnClickListener { listener.onAppClick(appName) }
    }

}