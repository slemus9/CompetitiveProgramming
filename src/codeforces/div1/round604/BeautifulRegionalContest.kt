package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * https://codeforces.com/problemset/problem/1264/A
 */
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    for (i in 0 until t) {
        val n = br.readLine().toInt()
        val p = br.readLine().split(" ").map { it.toInt() }.toTypedArray()

        if (n / 2 < 3) {
            println("0 0 0")
        } else {
            val eqIncrR = buildEqIncrR(p)
            val g = eqIncrR[0]

            if (g >= n/2){
                println("0 0 0")
            }else{
                val rem = n/2 - g
                var j = eqIncrR[0]
                var s = eqIncrR[j]
                j += s

                if (g >= s){
                    while (j < n/2 && g >= s){
                        val incr = eqIncrR[j]
                        if (j + incr + 1 <= n/2 + 1){
                            s += incr
                            j += incr
                        }else{
                            j = n/2
                        }
                    }
                }

                if (s >= rem){
                    println("0 0 0")
                }else{
                    var b = 0

                    while (j < n/2){
                        val incr = eqIncrR[j]
                        if (j + incr + 1 <= n/2 + 1){
                            b += incr
                            j += incr
                        }else{
                            j = n/2
                        }
                    }
                    println(if (g >= b) "0 0 0" else "$g $s $b")
                }
            }

        }
    }
}

fun buildEqIncrR(p: Array<Int>): Array<Int>{
    val eqIncrR = Array(p.size){_ -> 1}
    for (i in p.size - 2 downTo 0){
        if (p[i] == p[i + 1]){
            eqIncrR[i] += eqIncrR[i + 1]
        }
    }
    return eqIncrR
}
