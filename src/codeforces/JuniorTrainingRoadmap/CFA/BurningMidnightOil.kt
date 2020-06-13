package codeforces.JuniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

object BurningMidnightOil {
    fun calcSum (v: Int, k: Int): Int {
        tailrec fun go (summand: Int, acc: Int): Int =
            if (summand == 0) acc
            else go(summand/k, acc + summand)
        return go(v, 0)
    }

    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (n, k) = br.readLine().split(" ").map { it.toInt() }
        var l = 1
        var r = n
        while (l < r) {
            val m = (l + r)/2
            val sum = calcSum(m, k)
            if (sum < n) {
                l = m + 1
            } else {
                r = m
            }
        }
        println(l)
    }
}
