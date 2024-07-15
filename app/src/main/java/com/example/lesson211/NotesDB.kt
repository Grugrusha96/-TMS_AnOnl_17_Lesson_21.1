package com.example.lesson211

object NotesDB {
   private val listNotes = arrayListOf(
        Notes(1,"Алексей", "Привет всем", "18.03.2024"),
        Notes(2,"Алексей", "Я тут новенький", "18.03.2024"),
        Notes(3,"Алексей", "надеюсь все получится", "18.03.2024"),
        Notes(4,"Алексей", "Рад с вами познакомиться", "18.03.2024"),
        Notes(5,"Алексей", "всем удачи", "18.03.2024")
    )
    private val subscribers = arrayListOf<Subscriber>()

    fun  getNotesById(id:Int):Notes?{
        return listNotes.find { it.id == id }
    }
    fun addNotes(notes: Notes){
        listNotes.add(notes)
        notifySubscribes()
    }
    fun getListNotes() = listNotes

    fun subscribe(subscriber: Subscriber){
        subscribers.add(subscriber)
    }
    fun unsubscribe(subscriber: Subscriber){
        subscribers.remove(subscriber)
    }
    private fun notifySubscribes(){
        subscribers.forEach{
            it.update()
        }
    }
}