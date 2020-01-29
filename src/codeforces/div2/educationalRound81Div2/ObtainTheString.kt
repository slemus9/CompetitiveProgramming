package codeforces.div2.educationalRound81Div2

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()

    for (i in 0 until T){
        val s = br.readLine()
        val t = br.readLine()
        val availableLetters = s.toHashSet()
        var possible = true

        for (t_i in t){
            if (!(t_i in availableLetters)){
                possible = false
                break
            }
        }

        if (!possible){
            println(-1)
        }else{

        }

    }
}