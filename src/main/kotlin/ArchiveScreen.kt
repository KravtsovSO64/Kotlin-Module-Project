data class Note(val title: String, val content: String)
class ArchiveScreen (private val archive: MutableList<Archive>) : Screen(){

    override fun viewScreen(){
        while (true) {
            println("__________________________")
            println("1. выбор архива")
            println("2. создание архива")
            println("3. выход")
            println("__________________________")

            when(readLine()?.toIntOrNull()) {
                1 -> selectArchive(archive)
                2 -> createArchive(archive)
                3 -> return
                else -> println("неверный ввод, попробуйте снова.")
            }
        }
    }

    fun selectArchive(archives: List<Archive>) {
        println("выберите архив:")
        archives.forEachIndexed { index, archive ->
            println("$index. ${archive.name}")
        }
        val archiveIndex = readLine()?.toIntOrNull()

        if (archiveIndex != null && archiveIndex in archives.indices) {
            val notes = NoteScreen(archives[archiveIndex].notes)
            notes.viewScreen()
        } else {
            println("неверный выбор архива.")
        }
    }

    fun createArchive(archives: MutableList<Archive>) {
        println("введите название нового архива:")
        while (true) {
            val archiveName = readLine() ?: ""
            if (archiveName.isBlank()) {
                println("неверный ввод, попробуйте снова.")
            } else {
                archives.add(Archive(archiveName, mutableListOf()))
                println("архив $archiveName успешно создан.")
                break
            }
        }
    }
}