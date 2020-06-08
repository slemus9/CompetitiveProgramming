package codeforces.div3.round605

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

object NearestOppositeParity {

    fun sameParity (x: Int, y: Int): Boolean = x and 1 == y and 1

    fun bfs (a: List<Int>, G: HashMap<Int, ArrayList<Int>>): Array<Int> {
        val n = a.size
        val queue: Queue<Int> = LinkedList()
        val ans = Array(n){-1}
        for ((a_i, i) in a.zip(a.indices)) {
            if (i + a_i < n && !sameParity(a_i, a[i + a_i]) ||
                i - a_i >= 0 && !sameParity(a_i, a[i - a_i])){
                ans[i] = 1
                queue.add(i)
            }
        }

        while (queue.isNotEmpty()) {
            val v = queue.remove()
            if (G.containsKey(v)){
                for (u in G[v]!!) {
                    if (ans[u] == -1) {
                        ans[u] = ans[v] + 1
                        queue.add(u)
                    }
                }
            }
        }
        return ans
    }

    fun main () {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val n = br.readLine().toInt()
        val a = br.readLine().split(" ").map { it.toInt() }
        val G = HashMap<Int, ArrayList<Int>>()

        for ((a_i, i) in a.zip(a.indices)) {
            if (i + a_i < n && sameParity(a_i, a[i + a_i])){
                G[i + a_i] = G.getOrDefault(i + a_i, ArrayList()).apply { add(i) }
            }
            if (i - a_i >= 0 && sameParity(a_i, a[i - a_i])) {
                G[i - a_i] = G.getOrDefault(i - a_i, ArrayList()).apply { add(i) }
            }
        }

        println(bfs(a, G).joinToString(" "))
    }
}

fun main() {
    NearestOppositeParity.main()
}