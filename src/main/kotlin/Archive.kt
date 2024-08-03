internal class Archive(
    val name: String,
    val archives: MutableList<Archive> = mutableListOf<Archive>(),
    val notes: MutableList<Note> = mutableListOf<Note>()){


    fun addArchive(archive: Archive){
        archives.add(archive)
    }

    fun addNote(note: Note){
        notes.add(note)
    }
}