package codeforces.JuniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val photo = List(n){br.readLine().split(" ")}.flatten()
    val blackAndWhite = photo.dropWhile { it == "B" || it == "W" || it == "G" }.isEmpty()
    println(
        if (blackAndWhite) "#Black&White" else "#Color"
    )
}