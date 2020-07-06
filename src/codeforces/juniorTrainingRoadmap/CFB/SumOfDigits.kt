package codeforces.juniorTrainingRoadmap.CFB

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().chunked(1)
        .groupBy { it }.map { (d, ds) -> d.toInt() to ds.size  }
    if (n.size == 1 && n.first().second == 1 && n.first().first in 0 .. 9){
        println(0)
    } else {
        var cnt = 1
        var ans = n.fold(0){acc, (d, count) -> acc + d*count}
        while (!(ans in 0 .. 9)) {
            val digits = ans.toString().chunked(1)
                .groupBy { it }.map { (d, ds) -> d.toInt() to ds.size }
            ans = digits.fold(0){acc, (d, count) -> acc + d*count}
            cnt++
        }
        println(cnt)
    }
}