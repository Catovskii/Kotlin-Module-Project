interface Menus {
    val menu: MutableMap<Int, () -> Any>
    fun createMenu ()
}