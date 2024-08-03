object Menu {

    fun <T> listMenu(t:T) {
        // NEW

        //LIST ITEMS
        when (t) {
            is Note -> {
                println(t.name)
            }
            is Archive -> {
                for (a in t.archives.indices) {
                    println(t.archives[a])
                }
                for (n in t.notes.indices) {
                    println(t.notes[n])
                }
            }
        }
        // DELETE

        // EXIT
    }


}