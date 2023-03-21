package com.vynokurov.calc.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vynokurov.calc.R
import com.vynokurov.calc.databinding.AppsItemBinding
import com.vynokurov.calc.home.model.AppsModel

class AppsAdapter (
    private val dataset: List<AppsModel>,
    private val listener: AppsClickListener
) : RecyclerView.Adapter<AppsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AppsViewHolder (
        AppsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        listener
    )

    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: AppsViewHolder, position: Int) {
        holder.bind(dataset[position].stringResourceId)
    }
}