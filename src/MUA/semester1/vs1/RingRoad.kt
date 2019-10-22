package MUA.semester1.s1.vs1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private val graph = HashMap<Int, HashMap<Int, Int>>()
private val bidirectionalGraph = HashMap<Int, ArrayList<Int>>()
private val path1: Queue<Int> = LinkedList<Int>()
private val path2 = Stack<Int>()

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()


    for (i in 1 .. n){
        val abc = br.readLine().split(" ").map { it.toInt() }
        val a = abc[0]
        val b = abc[1]
        val c = abc[2]

        if (!graph.containsKey(a)){
            graph.put(a, HashMap())
        }
        graph.get(a)?.put(b, c)

        if (!bidirectionalGraph.containsKey(a)){
            bidirectionalGraph.put(a, ArrayList())
        }
        bidirectionalGraph.get(a)?.add(b)
        if (!bidirectionalGraph.containsKey(b)){
            bidirectionalGraph.put(b, ArrayList())
        }
        bidirectionalGraph.get(b)?.add(a)
    }

    dfs(n, 1)
    path1.add(1)
    path2.push(1)

    var path1Cost = 0
    var path2Cost = 0

    var n1 = path1.remove()
    while (path1.isNotEmpty()){
        val n2 = path1.remove()
        if (!graph.containsKey(n1) || !graph.get(n1)!!.containsKey(n2)){
            path1Cost += graph[n2]!![n1]!!
        }
        n1 = n2
    }

    n1 = path2.pop()
    while (path2.isNotEmpty()){
        val n2 = path2.pop()
        if (!graph.containsKey(n1) || !graph.get(n1)!!.containsKey(n2)){
            path2Cost += graph[n2]!![n1]!!
        }
        n1 = n2
    }

    val ans = if(path1Cost <= path2Cost) path1Cost else path2Cost
    println(ans)

}

fun dfs(n: Int, s: Int){
    val marked = Array<Boolean>(n + 1){x -> false}
    dfs(s, marked)
}

fun dfs(s: Int, marked: Array<Boolean>){
    marked[s] = true
    path1.add(s)
    path2.push(s)
    val adj = bidirectionalGraph.get(s)
    if (adj != null){
        for (node in adj){
            if (!marked[node]){
                dfs(node, marked)
            }
        }
    }
}