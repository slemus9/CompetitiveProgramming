package codeforces.div2.round580

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    if (n % 2 == 0) println("NO")
    else{
        println("YES")
        var curr = 0
        var off = 0

        for (i in 0 until 2*n){
            val num = 2*curr + off
            print("${num + 1} ")
            curr = (curr + 1) % n
            off = (off + 1) % 2

        }


    }
}