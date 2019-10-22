package GoogleCodeJam2019.qualificationRound

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()


    for (i in 1 .. t){
        val num = br.readLine()
        val a = StringBuilder()
        val b = StringBuilder()

        for (j in 0 until num.length){
            if(num[j] == '4'){
                a.append('3')
                b.append('1')
            }else{
                a.append(num[j])
                b.append('0')
            }
        }

        var j = 0
        while (j < b.length && b[j] == '0'){
            j++
        }

        println("Case #" + i + ": " + a + " " + b.substring(j))
    }
}