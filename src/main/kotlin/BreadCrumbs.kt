object BreadCrumbs {
        fun print(route: ArrayDeque<Archive>): String {
            var breadCrumbs = ""
            for (archive in route) {
                breadCrumbs += "${archive.name} > "
            }
            return breadCrumbs
    }
}