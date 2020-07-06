package codeforces.juniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val s = br.readLine()
    val (APoints, DPoints) = s.fold(0 to 0) {(a, d), c ->
        if (c == 'A') a + 1 to d else a to d + 1
    }
    println(
        if (APoints == DPoints) {
            "Friendship"
        } else if (APoints > DPoints) {
            "Anton"
        } else {
            "Danik"
        }
    )
}