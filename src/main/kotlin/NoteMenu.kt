import exceptions.BreakException

class NoteMenu(private val note: Note, private val currentArchive: Archive) : Menus
{
    override val menu: MutableMap<Int, () -> Any> = mutableMapOf()

    override fun createMenu() {
        println()
        showNote(this.note)
        println()
        println("Menu '${this.note.name}':")
        var i = 1
        //Edit
        menu[i] = {
            println("What do you want to edit?")
            println("1. Title")
            println("2. Content")
            println("Enter your choice: ")
            val choice = readln().toInt()
            when (choice) {
                1 -> {
                    println("Enter new name: ")
                    val newTitle = readln()
                    this.note.name = newTitle
                }
                2 -> {
                    println("Enter new text: ")
                    val newContent = readln()
                    this.note.text = newContent
                }
            }
        }
        println("${i++}. Edit current note")

        // Delete current note
        menu[i] = {
            CheckAnswer.areYouSureDelete(
                "Note '${this.note.name}'"
            ) {
                currentArchive.notes.remove(this.note)
                println("Note '${this.note.name}' deleted")
                throw BreakException()
            }
        }
        println("${i++}. Delete current note")

        //Exit
        menu[i] = {
            throw NoSuchElementException()
        }
        println("${i}. Exit")
        }

    private fun showNote(note: Note) {
        println("Note: ${note.name}")
        println("Content: ${note.text}")
    }
}

