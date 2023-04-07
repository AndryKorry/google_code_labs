/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.vynokurov.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vynokurov.dogglers.R
import com.vynokurov.dogglers.const.Layout
import com.vynokurov.dogglers.data.DataSource
import com.vynokurov.dogglers.model.Dog

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int
): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    val dogsList: List<Dog> = DataSource.dogs
    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        val dogName = view?.findViewById<TextView>(R.id.text_dog_name)
        val dogAge = view?.findViewById<TextView>(R.id.text_dog_age)
        val dogHobby = view?.findViewById<TextView>(R.id.text_dog_hobby)
        val dogImage = view?.findViewById<ImageView>(R.id.item_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        val adapterLayout =
            if (viewType == Layout.GRID) LayoutInflater.from(parent.context).inflate(R.layout.grid_list_item, parent, false)
        else LayoutInflater.from(parent.context).inflate(R.layout.vertical_horizontal_list_item, parent, false)
        return DogCardViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int = dogsList.size

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        val dog = dogsList[position]
        holder.dogName?.text =  dog.name
        holder.dogAge?.text =  dog.age
        val resources = context?.resources
        holder.dogHobby?.text =  resources?.getString(R.string.dog_hobbies, dog.hobbies)
        holder.dogImage?.setImageResource(dog.imageResourceId)
    }
}
