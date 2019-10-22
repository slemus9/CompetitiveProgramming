package MUA.semester1.s1.s13

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

data class Vector(val x: Int, val y: Int){

    fun sum(that: Vector): Vector =
            Vector(x + that.x, y + that.y)

    fun mult(n: Int): Vector =
            Vector(x * n, y * n)

    fun isProportional(that: Vector): Boolean =
            x % that.x == 0 && y % that.y == 0

}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val vectors = br.readLine().split(" ").map { it.toInt() }
    val displacement = br.readLine().split(" ").map { it.toInt() }

    val v = Vector(vectors[0], vectors[1])
    val t = Vector(vectors[2], vectors[3])
    val u = Vector(displacement[0], displacement[1])
    val vt = v.sum(t.mult(-1))
    val w = Vector((vt.x)/u.x, vt.y/u.y)

    if (vt.isProportional(u) && (abs(w.x) % 2 == abs(w.y) % 2)){
        println("YES")
    }else{
        println("NO")
    }
}