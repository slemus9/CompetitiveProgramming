package MUA.S201901.s1.vs3

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.pow
import kotlin.math.sqrt

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val rd = br.readLine().split(" ").map { it.toDouble() }
    val r = rd[0]
    val d = rd[1]
    val n = br.readLine().toInt()

    // sausages
    val ss = Array(n){t -> Triple(0.0, 0.0, 0.0) }

    for (i in 0 until n){
        val xyr = br.readLine().split(" ").map { it.toDouble() }
        ss[i] = Triple(xyr[0], xyr[1], xyr[2])
    }

    var count = 0

    for (i in 0 until n){
        val s = ss[i]
        val x = s.first
        val y = s.second
        val ri = s.third
        if (checkIfCircleIsInsideCrust(d, r, ri, x, y)){
            count ++
        }

    }



    println(count)
}

fun checkIfCircleIsInsideCrust(d: Double, r: Double, ri: Double, x: Double, y: Double): Boolean{
    val fromCenterToCircle = sqrt(x.pow(2) + y.pow(2))
    return (fromCenterToCircle + ri <= r && fromCenterToCircle - ri >= r - d)
}
