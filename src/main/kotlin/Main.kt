import java.util.*

data class Archive(val name: String, val notes: MutableList<Note>)

fun main() {
    val archives = mutableListOf<Archive>()
    val active = ArchiveScreen(archives)
    active.viewScreen()
}