package MUA.exam2

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nvbvs = br.readLine().split(" ").map { it.toLong() }
    val n = nvbvs[0].toInt()
    val vb = nvbvs[1]
    val vs = nvbvs[2]
    val xs = br.readLine().split(" ").map { it.toLong() }

    val stops = Array(n){_ -> Point(0,0)}

    for (i in 0 until n){
        stops[i] = Point(xs[i], 0)
    }

    val xyu = br.readLine().split( " ").map { it.toLong() }
    val u = Point(xyu[0], xyu[1])
    val closestPoint = findClosestPoint(stops, u)
    val closestPointTime = dist(closestPoint, Point(0,0))/vb + dist(closestPoint, u)/vs
    val closestPointIndex = stops.indexOf(closestPoint) + 1
    var index = 1
    var foundBetterTime = false

    while (index <= n && !foundBetterTime){
        val s = stops[index - 1]
        if (s != closestPoint){
            val totalTime_s = dist(s, Point(0, 0))/vb + dist(s, u)/vs
            if(totalTime_s < closestPointTime){
                foundBetterTime = true
            }
        }
        index++
    }

    println(
            if (foundBetterTime) index
            else closestPointIndex
    )

}

data class Point(val x: Long, val y: Long)

fun dist(p1: Point, p2: Point): Double =
        sqrt((p1.x - p2.x).toDouble()*(p1.x - p2.x) + (p1.y - p2.y)*(p1.y - p2.y))

fun findClosestPoint(points: Array<Point>, v: Point): Point{
    var min = 1000000.0
    var minPoint = Point(0,0)

    for (p in points){
        val distance = dist(p, v)
        if (distance < min){
            min = distance
            minPoint = p
        }
    }
    return minPoint
}

fun eq(a: Double, b: Double) = abs(a - b) < 0.00001