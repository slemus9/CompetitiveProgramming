package codeforces.juniorTrainingRoadmap.CFB

import java.io.BufferedReader
import java.io.InputStreamReader

object ChatOnline {
    fun intersects (p1: Pair<Int, Int>, p2: Pair<Int, Int>): Boolean =
            (p1.first >= p2.first && p1.first <= p2.second) || (p2.first >= p1.first && p2.first <= p1.second)

    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (p, q, l, r) = br.readLine().split(" ").map { it.toInt() }
        val littleX = List(p){
            val (a, b) = br.readLine().split(" ").map { it.toInt() }
            a to b
        }
        val littleZ = List(q){
            val (c, d) = br.readLine().split(" ").map {it.toInt()}
            c to d
        }

        var cnt = 0
        for (i in l .. r) {
            val validRanges = littleZ.map { (a, b) -> a + i to b + i }
            val validMoment = validRanges.any { p ->
                littleX.any { intersects(p, it) }
            }
            cnt += if (validMoment) 1 else 0
        }

        println(cnt)
    }
}
