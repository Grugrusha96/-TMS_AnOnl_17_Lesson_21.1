package com.example.lesson211

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.lesson211.databinding.FragmentAddNotesBinding

class AddNotesFragment : Fragment() {

private var binding:FragmentAddNotesBinding? = null




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
       return FragmentAddNotesBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.run {
            addNotesButton.setOnClickListener {


            val name:String = nameEditText.text.toString()
            val text:String = textEditText.text.toString()
            val data:String = dateEditText.text.toString()
                val id = NotesDB.getListNotes().last().id + 1
            NotesDB.addNotes(
            Notes(id, name, text, data)
            )
            Toast.makeText(requireContext(), "Заметка добавлена", Toast.LENGTH_SHORT).show()
            parentFragmentManager.popBackStack()

        }

        }
    }
}