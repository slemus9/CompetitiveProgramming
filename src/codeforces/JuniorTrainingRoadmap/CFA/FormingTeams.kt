package codeforces.JuniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

object FormingTeams {
    enum class ConnectionType {
        CYCLE, NORMAL
    }

    class QuickUnion (val n: Int) {
        private val parent = (0 until n).toMutableList()
        private val size = MutableList(n){1}
        var components = n

        tailrec fun find (p: Int): Int = when(p){
            parent[p] -> p
            else -> find(parent[p])
        }

        fun connected (p: Int, q: Int): Boolean =
            find(p) == find(q)

        fun union (p: Int, q: Int): Pair<ConnectionType, Int> {
            val rootP = find(p)
            val rootQ = find(q)
            return if (rootP != rootQ) {
                components--
                if (size[rootP] < size[rootQ]) {
                    parent[rootP] = rootQ
                    size[rootQ] += size[rootP]
                    ConnectionType.NORMAL to size[rootQ]
                } else {
                    parent[rootQ] = rootP
                    size[rootP] += size[rootQ]
                    ConnectionType.NORMAL to size[rootP]
                }
            } else {
                ConnectionType.CYCLE to size[rootP]
            }
        }
    }

    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (n, m) = br.readLine().split(" ").map { it.toInt()}
        val UF = QuickUnion(n)
        var cnt = 0
        for (i in 1 .. m){
            val (p, q) = br.readLine().split(" ").map { it.toInt() - 1}
            val (type, size) = UF.union(p, q)
            cnt += if (type == ConnectionType.CYCLE && size % 2 == 1) 1 else 0
        }
        println(if ((n - cnt) % 2 == 1) cnt + 1 else cnt)
    }
}
