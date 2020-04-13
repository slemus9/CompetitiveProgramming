package codeforces.div3.round634Div3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

object ConstructTheString {

    fun main (){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val t = br.readLine().toInt()

        for (i in 1 .. t){
            val (n, a, b) = br.readLine().split(" ").map { it.toInt() }
            val subs = StringBuilder("a")
            var count = 1
            for (i in 1 until a){
                if (count == b){
                    subs.append(subs[i - 1])
                } else{
                    subs.append(subs[i - 1] + 1)
                    count++
                }
            }

            val ans = subs

            if (a == 1){
                for (i in 1 until n){
                    ans.append(subs[i - 1] + 1)
                }
            } else{
                val m = subs.length
                var i = m
                while (i < n){
                    ans.append(subs[i % m])
                    i++
                }
            }

            println(ans)
        }
    }
}

fun main() {
    ConstructTheString.main()
}