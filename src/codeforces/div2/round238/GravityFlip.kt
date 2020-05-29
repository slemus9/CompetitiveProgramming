package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val a = br.readLine().split(" ").map { it.toInt() }
    val count = Array(105){0}
    for (a_i in a){
        count[a_i]++
    }

    val asorted = Array(n){0}
    var i = 0
    var j = 0

    while (i < count.size){
        if (count[i] != 0){
            asorted[j] = i
            count[i]--
            j++
        }else{
            i++
        }
    }
    println(asorted.joinToString(" "))
}