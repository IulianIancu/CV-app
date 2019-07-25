package com.example.cvapp.ui

import android.support.v7.widget.RecyclerView
import android.view.View
import com.challenge.mycvapp.R
import com.example.cvapp.data.model.Work
import kotlinx.android.synthetic.main.viewholder.view.*

class WorkViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(experience: Work) {
        itemView.apply {
            company_text.text = experience.company
            position_text.text = experience.position
            from_to_text.text =
                view.context.getString(R.string.from_to_string, experience.startDate, experience.endDate)
            summary_text.text = experience.summary
        }
    }


}
