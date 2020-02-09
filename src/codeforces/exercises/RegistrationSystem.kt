package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val count = HashMap<String, Int>()
    for (i in 0 until n){
        val s = br.readLine()
        if (s in count){
            println("$s${count[s]}")
            count[s] = count[s]!! + 1
        }else{
            println("OK")
            count[s] = 1
        }
    }
}