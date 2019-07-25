package com.example.cvapp.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.challenge.mycvapp.R
import com.example.cvapp.data.model.Work

class WorkAdapter : RecyclerView.Adapter<WorkViewHolder>() {

    private val workExperienceList = mutableListOf<Work>()

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): WorkViewHolder {
        return WorkViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.viewholder, parent, false)
        )
    }

    override fun getItemCount(): Int = workExperienceList.size

    override fun onBindViewHolder(holder: WorkViewHolder, position: Int) {
        holder.bind(workExperienceList.get(position))
    }

    fun setItems(items : List<Work>) {
        if (workExperienceList.isNotEmpty()) {
            workExperienceList.clear()
        }
        workExperienceList.addAll(items)
    }
}