package com.example.lesson211

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.lesson211.databinding.FragmentNotesBinding


private const val ID_NOTES_ARG = "idNotes"

class NotesFragment: Fragment (){

    private var  binding: FragmentNotesBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentNotesBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getInt(ID_NOTES_ARG)?.let {
         NotesDB.getNotesById(id)?.run {
              binding?.userName?.text = this.name
             binding?.textMessage?.text = this.text
             binding?.textMessageData?.text = this.date
         }
        }
    }
    companion object{
        fun getFragment(id: Int): NotesFragment{
            return NotesFragment().apply {
                arguments = bundleOf(ID_NOTES_ARG to id)
            }
        }
    }
}