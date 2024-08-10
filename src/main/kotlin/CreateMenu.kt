class CreateMenu {
    fun showMenu(obj: Menus) {
        do {
            println("-".repeat(40))
            obj.createMenu()
            println("Enter your choice: ")
            val choice = readln()
            try {
                choice.toInt().let {
                    if (choice.toInt() in 1..obj.menu.size) {
                        obj.menu[choice.toInt()]?.let { it() }
                    } else {
                        println("No such point!")
                    }
                }
            } catch (e: NoSuchElementException) {
                break
            } catch (e: Exception) {
                println("Please enter a number between 1 and ${obj.menu.size}")
            }
        } while (true)
    }
}

