import helper.Node
import helper.ShortestPathHelper
import javax.xml.stream.Location

fun main() {

    val maze = Array(11) { IntArray(11) }

    val customerList = listOf(
        Node(1, 10),
        Node(1, 4),
        Node(2, 1),
        Node(5, 2),
        Node(6, 5),
        Node(8, 4),
        Node(8, 9),
        Node(9, 2)
    )

    val dealer = Node(3, 7)

    customerList.map {
        ShortestPathHelper.BFS(maze, dealer.x, dealer.y, it.x, it.y).asReversed()
    }.forEach { list ->
        list.forEach {
            print("${it.x},${it.y} -> ")
        }
        println("--")
    }
}