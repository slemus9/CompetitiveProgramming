package codeforces.round71Div2

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    for (i in 1 .. t){
        val bpf = br.readLine().split(" ").map { it.toInt() }
        val b = bpf[0]
        val p = bpf[1]
        val f = bpf[2]

        val hc = br.readLine().split(" ").map { it.toInt() }
        val h = hc[0]
        val c = hc[1]

        val numHambs = b/2
        var profit = 0

        if (p + f <= numHambs){
            profit = p*h + f*c
        }else{
            if (h > c){
                val beef = min(numHambs, p)
                profit += beef*h + min(numHambs - beef, f)*c
            }else{
                val chicken = min(numHambs, f)
                profit += chicken*c + min(numHambs - chicken, p)*h
            }
        }

        println(profit)
    }
}