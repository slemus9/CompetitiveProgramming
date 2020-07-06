package codeforces.juniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

object DieRoll {
    tailrec fun gcd (a: Int, b: Int): Int =
        if (a == 0) b
        else gcd(b % a, a)

    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (Y, W) = br.readLine().split(" ").map { it.toInt() }
        val maxPoint = max(Y, W)
        val left = 6 - maxPoint + 1
        val g = gcd(6, left)
        println("${left/g}/${6/g}")
    }
}

fun main() {
    DieRoll.main()
}