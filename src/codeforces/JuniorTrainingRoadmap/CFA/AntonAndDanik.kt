package codeforces.JuniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val s = br.readLine()
    val games = s.groupBy { it }
    val APoints = games.getOrDefault('A', emptyList()).size
    val DPoints = games.getOrDefault('D', emptyList()).size
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