package codeforces.juniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine()
    val numLow = s.fold(0) {
            acc, c ->  if (c.isLowerCase()) acc + 1 else acc
    }
    val numCap = s.length - numLow
    println(if (numLow < numCap){
        s.toUpperCase()
    } else {
        s.toLowerCase()
    })
}