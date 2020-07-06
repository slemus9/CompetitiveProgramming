package codeforces.juniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

object PoloThePenguinAndSegments {
    fun value (segments: List<Pair<Int, Int>>): Int =
        segments.fold(0){acc, (l, r) -> acc + r - l + 1}

    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (n, k) = br.readLine().split(" ").map { it.toInt() }
        val segments = List(n){br.readLine().split(" ").map { it.toInt() }}
            .map { it[0] to it[1] }
        val currValue = value(segments)
        val required = min(k + k*(currValue/k), if (currValue % k == 0) k*(currValue/k) else Int.MAX_VALUE)
        println(required - currValue)
    }
}
