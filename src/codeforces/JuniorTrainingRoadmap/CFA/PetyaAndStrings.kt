package codeforces.JuniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s1 = br.readLine().map { it.toLowerCase() }
    val s2 = br.readLine().map { it.toLowerCase() }
    val comp = s1.zip(s2).dropWhile { (c1, c2) -> c1 == c2 }
    println(
        if (comp.isEmpty()) {
            0
        } else{
            val (c1, c2) = comp.first()
            if (c1 > c2) 1 else -1
        }
    )
}