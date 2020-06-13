package codeforces.JuniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

private typealias Point = Pair<Double, Double>
object WastedTime {

    fun dist (p1: Point, p2: Point): Double {
        val (x1, y1) = p1
        val (x2, y2) = p2
        return sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2))
    }

    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (n, k) = br.readLine().split(" ").map { it.toInt() }
        val coor = List(n){br.readLine().split(" ").map { it.toDouble() }}
            .map { it[0] to it[1] }
        val points = coor.zip(coor.drop(1))
        val ans = k*points.fold(0.0){acc, (p1, p2) ->
            acc + dist(p1, p2)/50
        }
        println("%.9f".format(ans))
    }

}
