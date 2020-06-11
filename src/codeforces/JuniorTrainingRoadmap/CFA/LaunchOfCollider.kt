package codeforces.JuniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val movement = br.readLine().toList()
    val maxBound = 1000000001
    val x = br.readLine().split(" ").map { it.toInt() }
    if (n == 1){
        println(-1)
    } else {
        val vectors = x.zip(movement)
        val pairs = vectors.zip(vectors.drop(1))
        val timeToCollision = pairs.map { (v1, v2) ->
            val (x, x_dir) = v1
            val (y, y_dir) = v2
            if (x_dir == 'R' && y_dir == 'L') abs(x - y)/2
            else maxBound
        }
        val minTime = timeToCollision.min()!!
        println(if (minTime == maxBound) -1 else minTime)
    }
}