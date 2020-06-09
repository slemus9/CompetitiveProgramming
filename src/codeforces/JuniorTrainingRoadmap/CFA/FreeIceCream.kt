package codeforces.JuniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, x) = br.readLine().split(" ").map { it.toLong() }
    var iceCream = x
    var distress = 0
    for (i in 1 .. n){
        val (sign, num) = br.readLine().split(" ")
        val d = if (sign == "+") num.toLong() else -num.toLong()
        if (iceCream + d < 0) {
            distress += 1
        } else {
            iceCream += d
        }
    }
    println("$iceCream $distress")
}