object Archives {
    private var route: ArrayDeque<Archive> = ArrayDeque()
    private val menu: MutableMap<Int, () -> Any> = mutableMapOf()
    private var currentArchive: Archive = Archive("Main")


    private fun createArchiveMenu() {
        println()
        println(BreadCrumbs.print(route))

        var i: Int = 1
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

        // Current archives and notes
        for (archive in currentArchive.archives) {
            menu[i] = {
                route.add(currentArchive)
                currentArchive = archive
            }
            println("${i++} Archive: ${archive.name}")
        }
        for (note in currentArchive.notes){
            menu[i] = {println("$i")}
            println("${i++} Note: ${note.name}")
        }

        // EXIT
        menu[i] = {
            currentArchive = route.removeLast()
        }
        println("${i++}. Exit")
    }

    fun showMenu() {
        do {
            createArchiveMenu()
            println("Enter your choice: ")
            val choice = readln()
            try {
                choice.toInt().let {
                    if (choice.toInt() in 1..menu.size) {
                        menu[choice.toInt()]?.let { it() }
                    }
                    else { println("No such point!")}
                }
            }
            catch (e: NoSuchElementException) {
                break
            }
            catch (e: Exception) {
                println("Please enter a number between 1 and ${menu.size}")
            }
        } while (true)
    }
}