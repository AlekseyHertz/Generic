class NotesNotFoundException(message: String) : RuntimeException(message)

data class Note(
    var idNote: Int, //
    val ownerId: Int,
    val title: String,
    val text: String, // текст заметки
    val data: Int,
    val commentNumber: Int,
    var countNotes : Int, // кол-во заметок
    val comment: String
)

object NoteService {
    private var note: MutableList<Note> = mutableListOf()
    private var lastId = 0

    fun clearNotes () {
        val notes = mutableListOf<Note>()
        lastId = 0
    }

    fun addNotes(note: Note): Int{
        note += note.copy(id = ++lastId)
        return note.last().id
    }

    fun createCommentNotes(idNote: Int, note: Note) {
        val note = note.find {it.id ==idNote}
        if (note!=null) {
            addNotes(note)
        } else {
            throw NotesNotFoundException ("notes not find")
        }
    }

    fun getCommentNotes(): MutableList<Note> {
        val listOfNotDeletedNotes = mutableListOf<Note>()
        for (note in note) {
            if (!note.isDeleted) {
                listOfNotDeletedNotes.add(note)
            }
        }
        return  listOfNotDeletedNotes
    }

    fun deleteNotes(lastId: Int, note: Note) {
        for (note: in note) {
            if ()
        }
        note.remote(idNote)
    }

    fun deleteCommentNotes(commentNumber: Int, note: Note) {
        //commentNumber
    }

}