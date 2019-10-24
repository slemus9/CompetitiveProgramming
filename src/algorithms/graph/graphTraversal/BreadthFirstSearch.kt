package algorithms.graph.graphTraversal

import java.util.*
import kotlin.collections.HashMap

class BreadthFirstSearch(val G: HashMap<Int, Array<Int>>){
    val q: Queue<Int> = LinkedList()
    val used = Array<Boolean>(G.size){_ -> false}
    val distances = Array<Int>(G.size){_ -> 0}
    val parents = Array<Int>(G.size){_ -> -1}

    fun bfs(s: Int){
        q.add(s)
        used[s] = true
        while (q.isNotEmpty()){
            val v = q.poll()
            for (u in G.get(v)!!){
                if (!used[u]){
                    used[u] = true
                    q.add(u)
                    distances[u] = distances[v] + 1
                    parents[u] = v
                }
            }
        }
    }

    /**
     * Display shortest path from a source s to a node u
     */
    fun displayPath(s: Int, u: Int): List<Int>{
        //bfs(s)
        if (!used[u]) return LinkedList<Int>()
        else{
            val path = LinkedList<Int>()
            var v = u
            while (v != 1){
                path.add(v)
                v = parents[v]
            }
            return path
        }
    }
}
