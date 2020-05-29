package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val comp3 = compare(0.0001)
    val ts = br.readLine().split(" ").map { it.toDouble() }
    val t = br.readLine().toDouble()
    val max = ts.max()!!
    val min = ts.min()!!
    val inter = ts.sum() - max - min
    val needed = 3*t - inter
    println(
        if (comp3(max, needed) == -1 || comp3(max, needed) == 0) "infinite"
        else if (comp3(min, needed) == 1) "impossible"
        else "%.2f".format(needed)
    )
}

fun compare (ep: Double): (Double, Double) -> Int = {
    a, b ->
        when {
            a - b > ep -> 1
            a - b < -ep -> -1
            else -> 0
        }
}