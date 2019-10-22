package MUA.semester1.s1.s3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

object UniformString{

    fun getStringToMaximizaMinFreq(n: Int, k: Int): String{

        val d = n / k
        val rem = n % k
        val a_ascii = 97
        var s = StringBuilder()

        for (i in 0 until k){
            s.append((a_ascii + i).toChar().toString().repeat(d))
        }

        s.append((a_ascii + k - 1).toChar().toString().repeat(rem))
        return s.toString()
    }
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    for (i in 0 until t){
        val nk = br.readLine().split(" ").map { it.toInt() }
        println(UniformString.getStringToMaximizaMinFreq(nk[0], nk[1]))
    }
}