package com.example.lesson211.ui.notes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lesson211.data.Notes
import com.example.lesson211.repositories.NotesRepository

class NotesViewModel: ViewModel() {

    val notes = MutableLiveData<Notes>()

    private val notesRepository = NotesRepository()

  fun getNotesById(id: Int){
      notes.value = notesRepository.getNotesById(id)
  }
}