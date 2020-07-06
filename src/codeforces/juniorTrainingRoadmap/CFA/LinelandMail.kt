package codeforces.juniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

object LinelandMail {
    fun distance (a: Int, b: Int): Int =
        abs(a - b)

    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val n = br.readLine().toInt()
        val x = br.readLine().split(" ").map { it.toInt() }
        var i = 0
        while (i < n) {
            val min = if (i == 0) {
                distance(x[i], x[i + 1])
            } else if (i == n - 1) {
                distance(x[i - 1], x[i])
            } else {
                min(distance(x[i], x[i + 1]), distance(x[i - 1], x[i]))
            }
            val max = if (i == 0) {
                distance(x[i], x[n - 1])
            } else if (i == n - 1) {
                distance(x[0], x[i])
            } else {
                max(distance(x[i], x[n - 1]), distance(x[0], x[i]))
            }
            println("$min $max")
            i++
        }
    }
}

fun main() {
    LinelandMail.main()
}
