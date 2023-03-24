package com.vynokurov.calc.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vynokurov.calc.R
import com.vynokurov.calc.home.model.AppsModel

class AppsAdapter (
    private val dataset: List<AppsModel>,
    private val listener: AppsClickListener
) : RecyclerView.Adapter<AppsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AppsViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.apps_item, parent, false),
        listener
    )

    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: AppsViewHolder, position: Int) {
        holder.bind(dataset[position].stringResourceId)
    }
}