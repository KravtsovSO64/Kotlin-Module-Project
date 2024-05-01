class NoteScreen (val note : MutableList<Note>) : Screen() {

    override fun viewScreen() {
            while (true) {
                println("__________________________")
                println("1. выбор заметки")
                println("2. создание заметки")
                println("3. вернуться к выбору архива")
                println("__________________________")

                when(readLine()?.toIntOrNull()) {
                    1 -> selectNote(note)
                    2 -> createNote(note)
                    3 -> return
                    else -> println("Неверный ввод, попробуйте снова.")
                }
            }
    }
    private fun selectNote(notes: List<Note>) {
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

    private fun createNote(notes: MutableList<Note>) {
        println("введите название заметки:")
        flag@ while (true) {
            val title = readLine() ?: ""
            if (title.isBlank()) {
                println("неверный ввод, название не может быть пустым.")
                println("введите название снова")
            } else {
                println("введите содержание заметки:")
                while (true){
                    val content = readLine() ?: ""
                    if (content.isBlank()){
                        println("неверный ввод, содержание не может быть пустым.")
                        println("введите содержание снова")
                    } else {
                        notes.add(Note(title, content))
                        println("заметка \"$title\" успешно добавлена.")
                            break@flag
                    }
                }
            }
        }
    }


    private fun displayNoteContent(note: Note) {
        println("заметка \"${note.title}\":")
        println(note.content)
    }

}