package com.example.lesson211.ui.addNotes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lesson211.repositories.NotesRepository

class AddNotesViewModel: ViewModel() {

    val notesAdded = MutableLiveData<Unit>()

    private val notesRepository = NotesRepository()

    var error: (()-> Unit)? = null

    fun addNotes (name:String, text:String, data:String) {
        if (name.isBlank() || text.isBlank() || data.isBlank()) {
            error?.invoke()
        } else {
            notesRepository.addNotes(name, text, data)
            notesAdded.value = Unit
        }
    }

}