package com.example.lesson211.ui.mainFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lesson211.data.Notes
import com.example.lesson211.db.NotesDB
import com.example.lesson211.db.Subscriber
import com.example.lesson211.repositories.NotesRepository

class MainViewModel : ViewModel(), Subscriber {

    val listNotes = MutableLiveData<List<Notes>>()

    private val notesRepository = NotesRepository()

    init {
        NotesDB.subscribe(this)
    }

    override fun onCleared() {
        super.onCleared()
        NotesDB.unsubscribe(this)
    }

    fun getListNotes(){
       listNotes.value =  notesRepository.getListNotes()
    }


    override fun update() {
        getListNotes()
    }
}