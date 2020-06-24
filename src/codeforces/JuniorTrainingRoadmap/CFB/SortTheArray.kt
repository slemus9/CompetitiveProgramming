package codeforces.JuniorTrainingRoadmap.CFB

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val a = br.readLine().split(" ").map { it.toInt() }
    var i = 0
    var startDec = -1
    var endDec = -1

    while (i < n - 1 && endDec == -1) {
        if (a[i] > a[i + 1]){
            if (startDec == -1){
                startDec = i
            }
        } else {
            if (startDec != -1) {
                endDec = i
            }
        }
        i++
    }

    if (startDec == -1){
        println("yes")
        println("1 1")
    } else {
        if (endDec == -1){
            endDec = n - 1
        }
        val modified = a.subList(0, startDec) + a.subList(startDec, endDec + 1).reversed() + a.subList(endDec + 1, n)
        val ordered = a.sorted() == modified

        if (ordered) {
            println("yes")
            println("${startDec + 1} ${endDec + 1}")
        } else {
            println("no")
        }
    }
}