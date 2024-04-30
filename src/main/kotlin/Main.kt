import java.util.*

data class Archive(val name: String, val notes: MutableList<Note>)

data class Note(val title: String, val content: String)

fun main() {
    val archives = mutableListOf<Archive>()

    while (true) {
        println("__________________________")
        println("1. выбор архива")
        println("2. создание архива")
        println("3. выход")
        println("__________________________")

        when(readLine()?.toIntOrNull()) {
            1 -> selectArchive(archives)
            2 -> createArchive(archives)
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
        displayNotes(archives[archiveIndex].notes)
    } else {
        println("неверный выбор архива.")
    }
}

fun createArchive(archives: MutableList<Archive>) {
    println("введите название нового архива:")
    val archiveName = readLine() ?: ""
    archives.add(Archive(archiveName, mutableListOf()))
    println("архив $archiveName успешно создан.")
}

fun selectNote(notes: List<Note>) {
    println("выберите заметку:")
    notes.forEachIndexed { index, note ->
        println("$index. ${note.title}")
    }
    val noteIndex = readLine()?.toIntOrNull()

    if (noteIndex != null && noteIndex in notes.indices) {
        displayNoteContent(notes[noteIndex])
    } else {
        println("неверный выбор заметки.")
    }
}

fun createNote(notes: MutableList<Note>) {
    println("введите название заметки:")
    val title = readLine() ?: ""
    println("введите содержание заметки:")
    val content = readLine() ?: ""
    notes.add(Note(title, content))
    println("заметка \"$title\" успешно добавлена.")
}

fun displayNoteContent(note: Note) {
    println("заметка \"${note.title}\":")
    println(note.content)
}

fun displayNotes(notes: MutableList<Note>) {
    while (true) {
        println("__________________________")
        println("1. выбор заметки")
        println("2. создание заметки")
        println("3. вернуться к выбору архива")
        println("__________________________")

        when(readLine()?.toIntOrNull()) {
            1 -> selectNote(notes)
            2 -> createNote(notes)
            3 -> return
            else -> println("Неверный ввод, попробуйте снова.")
        }
    }
}