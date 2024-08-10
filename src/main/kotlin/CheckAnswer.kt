object CheckAnswer {
    fun areYouSureDelete(whatDelete: String, action: () -> Any){
        println("Are you sure you want to delete this ${whatDelete.lowercase()}?")
        println("1. Yes")
        println("2. No")
        println("Enter your choice: ")
        val choice = readln().toInt()
        if (choice == 1) {
            action()
            println("$whatDelete deleted")
        } else {
            println("$whatDelete not deleted")
        }
    }
}