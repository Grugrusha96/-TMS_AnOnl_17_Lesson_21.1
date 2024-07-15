package com.example.lesson211.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.lesson211.Notes
import com.example.lesson211.databinding.UserListItemBinding


class UserAdapter(
    private val onClick:(contact:Notes)->Unit
): ListAdapter<Notes, NotesViewHolder>(NotesDiffUtill()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(
            UserListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener{
            onClick(getItem(position))
        }
    }

}

