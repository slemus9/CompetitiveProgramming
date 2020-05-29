package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val points = HashMap<String, Int>()
    val rounds = Array(n){"" to 0}

    for (i in 0 until n){
        val (s, p) = br.readLine().split(" ")
        rounds[i] = s to p.toInt()
        points[s] = points.getOrDefault(s, 0) + p.toInt()
    }

    val max = points.maxBy { it.value }!!.value
    val posWinners = points.filter { (_, p) -> p == max }
    val pairList = rounds.copyOf().map { (s, p) -> s to 0 }.toTypedArray()
    val sums = hashMapOf(*pairList)
    println(
        rounds.dropWhile {
                (s, p) ->
                        sums[s] = sums.getOrDefault(s, 0) + p
                        sums[s]!! < max || !(s in posWinners)
        }.first().first
    )
}