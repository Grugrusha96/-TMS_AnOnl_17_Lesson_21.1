package com.example.lesson211.ui.mainFragment.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.lesson211.data.Notes
import com.example.lesson211.databinding.UserListItemBinding


class NotesViewHolder(
    private val binding: UserListItemBinding):
    RecyclerView.ViewHolder(binding.root) {

        fun bind(notes: Notes){
            binding.run{
                userName.text = notes.name
                textMessage.text = notes.text
                textMessageData.text = notes.date
            }
        }
    }



   // fun bind (notes: Notes) {
      //  with(userListItemBinding) {
       //     userName.text = notes.name
       //     textMessage.text = notes.text
        //    textMessageData.text = notes.date

       // }
  //  }

  //  companion object {
       // fun from(parent: UserListItemBinding): NotesViewHolder {
       //     val layoutInflater = LayoutInflater.from(parent.context)
//val binding = UserListItemBinding.inflate(layoutInflater, parent, false)
     //       return NotesViewHolder(binding)
     //   }
   // }

//}