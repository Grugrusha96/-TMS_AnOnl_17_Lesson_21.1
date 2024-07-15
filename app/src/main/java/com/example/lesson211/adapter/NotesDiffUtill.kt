package com.example.lesson211.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.lesson211.Notes

class NotesDiffUtill : DiffUtil.ItemCallback<Notes>() {

    override fun areItemsTheSame(oldItem: Notes, newItem: Notes): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: Notes, newItem: Notes): Boolean {
        return false
    }
}