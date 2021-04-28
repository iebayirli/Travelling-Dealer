package helper

import java.util.*

object ShortestPathHelper {

    private const val M = 11
    private const val N = 11

    var row = intArrayOf(-1, 0, 0, 1)
    var col = intArrayOf(0, -1, 1, 0)

    private fun isValid(mat: Array<IntArray>, visited: Array<BooleanArray>, row: Int, col: Int): Boolean {
        return (row >= 0) && (row < M) && (col >= 0) && (col < N)
                && !visited[row][col]
    }

    private fun backtrackPath(n: Node): List<Node> {
        var iter : Node? = n
        val path = mutableListOf<Node>()
        while (iter != null) {
            path.add(iter)
            iter = iter.parent
        }
        return path
    }

    fun BFS(mat: Array<IntArray>, startX: Int, startY: Int, x: Int, y: Int): List<Node> {
        var i = startX
        var j = startY

        val visited = Array(M) { BooleanArray(N) }
        val q = LinkedList<Node>()

        visited[i][j] = true
        q.add(Node(i, j))

        while (!q.isEmpty()) {
            val node = q.remove()

            i = node.x
            j = node.y

            if (i == x && j == y) {
                return backtrackPath(node)
            }

            for (k in 0..3) {
                if (isValid(mat, visited, i + row[k], j + col[k])) {
                    visited[i + row[k]][j + col[k]] = true
                    val cor = Node(i + row[k], j + col[k], node)
                    q.add(cor)
                }
            }
        }
        return emptyList()
    }
}