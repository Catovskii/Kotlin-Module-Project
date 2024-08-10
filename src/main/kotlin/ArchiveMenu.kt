object ArchiveMenu : Menus {
    private var route: ArrayDeque<Archive> = ArrayDeque()
    override val menu: MutableMap<Int, () -> Any> = mutableMapOf()
    private var currentArchive: Archive = Archive("Main")


    override fun createMenu() {
        println()
        println(BreadCrumbs.print(route))

        var i = 1
        menu.clear() // Clear menu
        println("Menu '${currentArchive.name}':")

        // Add archive and notes
        menu[i] = {
            println("Enter archive name: ")
            val name = readln()
            if (name!= "") {currentArchive.archives.add(Archive(name))}
            else {println("You must enter a name to add an archive!")
            }

        }
        println("${i++}. Add archive")

        menu[i] = {
            println("Enter note name: ")
            val name = readln()
            if (name!= "") {
                println("Enter note text: ")
                val text = readln()
                currentArchive.notes.add(Note(name, text))
                }
            else {println("You must enter a name to add a note!")
            }
        }
        println("${i++}. Add note")

        // Delete current archive
        menu[i] = {
            CheckAnswer.areYouSureDelete(
                "Archive '${currentArchive.name}'"
            ) {
                val fatherArchive = route.removeLast()
                fatherArchive.archives.remove(currentArchive)
                currentArchive = fatherArchive
                return@areYouSureDelete Any()
            }

        }
        println("${i++}. Delete current archive")

        // Current archives and notes
        for (archive in currentArchive.archives) {
            menu[i] = {
                route.add(currentArchive)
                currentArchive = archive
            }
            println("${i++} Archive: ${archive.name}")
        }
        for (note in currentArchive.notes){
            menu[i] = {
                val noteMenu = CreateMenu()
                noteMenu.showMenu(NoteMenu(note, currentArchive))
            }
            println("${i++} Note: ${note.name}")
        }

        // EXIT
        menu[i] = {
            currentArchive = route.removeLast()

        }
        println("${i}. Exit")
    }
}