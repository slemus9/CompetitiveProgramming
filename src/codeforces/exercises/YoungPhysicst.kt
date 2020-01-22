package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

data class Vector(val x: Int, val y: Int, val z: Int){
    infix fun add (v: Vector): Vector =
        Vector(x + v.x, y + v.y, z + v.z)

    fun isZero (): Boolean = x == 0 && y == 0 && z == 0
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val forces = Array(n){Vector(0, 0, 0)}

    for (i in 0 until n){
        val (x, y, z) = br.readLine().split(" ").map { it.toInt() }
        forces[i] = Vector(x, y, z)
    }

    val sum = forces.fold(Vector(0, 0, 0)){acc, v -> v add acc}
    println(if (sum.isZero()) "YES" else "NO")
}