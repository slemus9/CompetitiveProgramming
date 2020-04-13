package codeforces.div3.round634Div3

import java.io.BufferedReader
import java.io.InputStreamReader

object CandiesAndTwoSisters {

    fun main (){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val t = br.readLine().toInt()

        for (i in 1 .. t){
            val n = br.readLine().toInt()
            println(n - n/2 - 1)
        }
    }
}

fun main() {
    CandiesAndTwoSisters.main()
}