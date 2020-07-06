package codeforces.juniorTrainingRoadmap.CFB

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, a) = br.readLine().split(" ").map { it.toInt() }
    val t = br.readLine().split(" ").map { it.toInt() }
    val dist = (1..n).map{ abs(a - it)}
    val bcd = (1..n).zip(t).groupBy { (i, t_i) -> dist[i - 1] }
    var cnt = 0
    for ((d, cities) in bcd) {
        if (cities.size == 1 && cities.first().second == 1){
            cnt++
        } else {
            if (cities.all { it.second == 1 }){
                cnt += 2
            }
        }
    }
    println(cnt)
}