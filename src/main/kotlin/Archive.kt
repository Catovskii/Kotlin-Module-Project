data class Archive(
    val name: String,
    val archives: MutableList<Archive> = mutableListOf(),
    val notes: MutableList<Note> = mutableListOf()){
}