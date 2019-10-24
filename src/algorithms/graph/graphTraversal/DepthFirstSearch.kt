package algorithms.graph.graphTraversal

object DepthFirstSearch{
    val G: HashMap<Int, Array<Int>> = HashMap()
    val visited = Array<Boolean>(G.size){_ -> false}
    val color = Array<Int>(G.size){_ -> -1}
    val timeIn = Array(G.size){_ -> 0}
    val timeOut = Array(G.size){_ -> 0}
    var dfsTimer = 0

    /**
     * Generic implementation
     */
    fun dfs1(v: Int){
        visited[v] = true
        for (u in G.get(v)!!){
            if (!visited[u]){
                visited[u] = true
                dfs1(u)
            }
        }
    }

    /**
     * Calculates exit and entry times and colors
     * colors:
     *  0 -> We haven't visited them
     *  1 -> We visited them
     *  2 -> we already exited the vertex
     */
    fun dfs2(v: Int){
        timeIn[v] = dfsTimer++
        color[v] = 1

        for (u in G.get(v)!!)
            if (color[u] == 0)
                dfs2(u)

        color[v] = 2
        timeOut[v] = dfsTimer++
    }
}
