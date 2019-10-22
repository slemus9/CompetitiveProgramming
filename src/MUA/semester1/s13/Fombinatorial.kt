package MUA.semester1.s1.s13

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    for (i in 1 .. t){
        val nmq = br.readLine().split(" ").map { it.toInt() }
        val n = nmq[0]
        val m = nmq[1]
        val q = nmq[2]


    }
}