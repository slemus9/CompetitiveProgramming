package codeforces.juniorTrainingRoadmap.CFB

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (vp, vd, t, f, c) = List(5){br.readLine().toDouble()}
    if (vp >= vd) println(0)
    else {
        var cnt = 0
        var p = vd*(vp*t/(vd - vp))
        while (p < c) {
            p = vd*(vp*(f + p/vd) + p)/(vd - vp)
            ++cnt
        }
        println(cnt)
    }
}