package codeforces.juniorTrainingRoadmap.CFB

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    fun readInts () = br.readLine().split(" ").map { it.toLong() }
    val (n, m) = readInts()
    val (x, y) = readInts()
    val k = br.readLine().toInt()
    val vectors = List(k){
        val (dx, dy) = readInts()
        dx to dy
    }

    var steps = 0L
    var currX = x
    var currY = y
    vectors.forEach { (dx, dy) ->
        var newSteps = Long.MAX_VALUE
        if (dx > 0) newSteps = (n - currX)/dx
        if (dx < 0) newSteps = (currX - 1)/-dx
        if (dy > 0) newSteps = min(newSteps, (m - currY)/dy )
        if (dy < 0) newSteps = min(newSteps, (currY - 1)/-dy)
        currX += dx*newSteps
        currY += dy*newSteps
        steps += newSteps
    }
    println(steps)
}