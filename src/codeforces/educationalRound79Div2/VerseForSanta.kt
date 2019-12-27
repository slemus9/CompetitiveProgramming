package codeforces.educationalRound79Div2

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    for (i in 0 until t){
        val (n, s) = br.readLine().split(" ").map { it.toLong() }
        val a = br.readLine().split(" ").map { it.toLong() }
        var count = 0
        var time = 0L
        var max = -1L
        var posMax = -1
        var i = 0

        while (i < a.size ){
            time += a[i]
            if (a[i] > max){
                max = a[i]
                posMax = i
            }
            i++
            if (time <= s){
                count++
            }else{
                break
            }
        }

        var countSkipped = count
        time -= max
        while (i < a.size ){
            if (time + a[i] <= s){
                time += a[i]
                countSkipped++
            }else{
                break
            }
            i++
        }
        println(if (countSkipped > count) posMax + 1 else 0)
    }
}