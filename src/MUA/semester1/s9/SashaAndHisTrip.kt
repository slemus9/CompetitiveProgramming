package MUA.semester1.s1.s9

import java.io.BufferedReader
import java.io.InputStreamReader

fun findMin(n: Int, v: Int): Int {
    var cap = 0
    var money = 0
    var rem: Int
    for (i in 1 .. n){
        rem = n - i
        if (cap < rem){
            val missingInTank: Int
            if ((v - cap) <= rem){
                missingInTank = v - cap
            }else{
                missingInTank = rem
            }
            cap += missingInTank
            money += i*missingInTank
        }
        cap--
    }
    return money
}

fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nv = br.readLine().split(" ").map { it.toInt() }
    val n = nv[0]
    val v = nv[1]
    println(findMin(n, v))

}