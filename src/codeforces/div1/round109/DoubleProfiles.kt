package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    DoubleProfiles.main()
}

object DoubleProfiles {

    val p = 31L

    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        val pows = computePowers(n)
        val neighborHash = Array(n){0L}

        for (i in 0 until m){
            val (v, u) = br.readLine().split(" ").map { it.toInt() - 1}
            neighborHash[v] += pows[u]
            neighborHash[u] += pows[v]
        }

        val meAndNeighborHash = pows.mapIndexed {i, x -> x + neighborHash[i]}.toTypedArray()
        println(
            countDoubles(neighborHash) + countDoubles(meAndNeighborHash)
        )
    }

    fun countDoubles (h: Array<Long>): Long{
        val sortedH = h.sorted()
        var count = 0L
        var res = 0L
        for (i in 1 until h.size){
            if (sortedH[i] == sortedH[i - 1]){
                count++
            } else{
                res += xCombined2(count + 1)
                count = 0
            }
        }
        res += xCombined2(count + 1)

        return res
    }

    fun xCombined2 (x: Long): Long = x*(x - 1)/2

    fun computePowers (n: Int): Array<Long>{
        val pows = Array(n){0L}
        pows[0] = 1L
        for (i in 1 until  n){
            pows[i] = p*pows[i - 1]
        }
        return pows
    }

}
