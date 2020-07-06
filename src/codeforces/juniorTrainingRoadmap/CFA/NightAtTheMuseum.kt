package codeforces.juniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine()
    var prevPos = 0
    var cnt = 0
    for (c in s) {
        val pos = c - 'a'
        val steps = min(abs(pos - prevPos), abs(26 - abs(pos - prevPos)))
        cnt += steps
        prevPos = pos
    }
    println(cnt)
}