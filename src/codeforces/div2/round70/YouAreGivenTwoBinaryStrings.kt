package codeforces.div2.round70

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    for (k in 1 .. t){
        var x = br.readLine().reversed()
        var y = br.readLine().reversed()

        var j = 0


        while (j < y.length ){
            if (y[j] == '1'){
                break
            }
            j++
        }

        var i = j

        while (i < x.length ){
            if (x[i] == '1'){
                break
            }
            i++
        }

        println(i - j)

    }
}