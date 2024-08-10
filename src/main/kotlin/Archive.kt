data class Archive(
    val name: String,
    val archives: MutableList<Archive> = mutableListOf<Archive>(),
    val notes: MutableList<Note> = mutableListOf<Note>()){
}