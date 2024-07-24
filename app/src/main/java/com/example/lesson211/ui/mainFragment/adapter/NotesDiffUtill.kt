package com.example.lesson211.ui.mainFragment.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.lesson211.data.Notes

class NotesDiffUtill : DiffUtil.ItemCallback<Notes>() {

    override fun areItemsTheSame(oldItem: Notes, newItem: Notes): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: Notes, newItem: Notes): Boolean {
        return false
    }
}