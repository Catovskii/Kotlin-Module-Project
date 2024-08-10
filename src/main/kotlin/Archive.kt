data class Archive(
    var name: String,
    val archives: MutableList<Archive> = mutableListOf(),
    val notes: MutableList<Note> = mutableListOf()){
}