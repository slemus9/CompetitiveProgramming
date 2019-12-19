package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * https://codeforces.com/contest/1267/problem/B
 */
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val balls = br.readLine()

    var i = 0
    var j = balls.length - 1
    var count = 0
    var possible = true

    while (i <= j && possible){
        count = 0
        val color = balls[i]

        if (balls[i] != balls[j]){
            possible = false
        }else{
            while (i <= j && balls[i] == color){
                i++
                count++
            }
            while (i <= j && balls[j] == color){
                j--
                count++
            }
            if (i < j && count <= 2){
                possible = false
            }
        }
    }
    println(if (possible && count > 1) count + 1 else 0)
}


