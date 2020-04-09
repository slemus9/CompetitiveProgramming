package MUA.S201901.s1.s3

import java.io.BufferedReader
import java.io.InputStreamReader

object LittleElephantAndCandies{

    fun allElephantsHappy(elephants: List<Int>, n: Int, c: Int): Boolean{
        var count = c

        for (j in 0 until n){
            count -= elephants[j]
            if (count < 0){
                return false
            }
        }
        return true
    }
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    for (i in 0 until t){
        val nc = br.readLine().split(" ").map { it.toInt() }
        val n = nc[0]
        var c = nc[1]
        val elephants = br.readLine().split(" ").map { it.toInt() }
        val allHappy = LittleElephantAndCandies.allElephantsHappy(elephants, n, c)

        if (allHappy){
            println("Yes")
        }else{
            println("No")
        }
    }
}