package com.sophia.saveandshowmyactivitytoday.adapter

import android.graphics.Color
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sophia.saveandshowmyactivitytoday.databinding.ListItemBinding
import com.sophia.saveandshowmyactivitytoday.databinding.ListItemCheckBinding
import com.sophia.saveandshowmyactivitytoday.entity.Check

class ViewAllAdapter : ListAdapter<Check, ViewAllAdapter.ViewAllViewHolder>(

    object : DiffUtil.ItemCallback<Check>() {
        override fun areItemsTheSame(oldItem: Check, newItem: Check): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Check, newItem: Check): Boolean =
            oldItem == newItem

    }

) {
    inner class ViewAllViewHolder(private val binding: ListItemCheckBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(check: Check) {
            binding.tvText.text = check.content
            binding.tvDate.text = check.date

            binding.tvText.paintFlags = binding.tvText.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewAllViewHolder =
        ViewAllViewHolder(
            ListItemCheckBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewAllViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}