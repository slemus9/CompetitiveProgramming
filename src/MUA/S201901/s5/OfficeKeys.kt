package MUA.S201901.s1.s5

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

object OfficeKeys{

    val limit = 1000000000


    fun findMinTime(n: Int, k: Int, p: Int, people: List<Int>, keys: List<Int>) : Int{
        val d = Array(n + 1){IntArray(k + 1)}
        val ps = IntArray(n + 1)
        val ks = IntArray(k + 1)
        for(i in 1 .. n){
            ps[i] = people[i - 1]
        }
        for(i in 1 .. k){
            ks[i] = keys[i - 1]
        }

        for (i in 1 .. n){
            for (j in 0 .. k){
                d[i][j] = limit
            }
        }

        for (i in 1 .. n){
            for (j in i .. k){
                d[i][j] = d[i][j - 1]
                val totalDistance = abs(ps[i] - ks[j]) + abs(ks[j] - p)
                d[i][j] = min(d[i][j-1], max(d[i-1][j-1], totalDistance))
            }
        }
        return d[n][k]
    }
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nkp = br.readLine().split(" ").map { it.toInt() }
    val people = br.readLine().split(" ").map { it.toInt() }
    val keys = br.readLine().split(" ").map { it.toInt() }
    people.sorted()
    keys.sorted()

    println(OfficeKeys.findMinTime(nkp[0], nkp[1], nkp[2], people, keys))
}