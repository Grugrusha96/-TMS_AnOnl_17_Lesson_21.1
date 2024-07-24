package com.example.lesson211.repositories

import com.example.lesson211.data.Notes
import com.example.lesson211.db.NotesDB

class NotesRepository {

    fun  getListNotes() = NotesDB.getListNotes()

    fun addNotes(name:String, text:String, data:String){
        val id = NotesDB.getListNotes().last().id + 1
        NotesDB.addNotes(
            Notes(id, name, text, data)
        )
    }

    fun getNotesById(id: Int) = NotesDB.getNotesById(id)
}