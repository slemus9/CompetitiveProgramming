package codeforces.juniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

object BeautifulMatrix {

    fun findPos (M: List<List<Int>>): Pair<Int, Int> {
        for (i in 0 until 5) {
            for (j in 0 until 5) {
                if (M[i][j] == 1)
                    return i + 1 to j + 1
            }
        }
        return -1 to -1
    }

    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val M = List(5){br.readLine().split(" ").map { it.toInt() }}
        val (i, j) = findPos(M)
        println(abs(i - 3) + abs(j - 3))
    }
}

fun main() {
    BeautifulMatrix.main()
}
