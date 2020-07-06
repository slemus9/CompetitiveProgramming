package codeforces.juniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val shifting = br.readLine()
    val s = br.readLine()
    val keys = ("qwertyuiop" + "asdfghjkl;" + "zxcvbnm,./").toList()
    val keysIndices = keys.zip(keys.indices).toMap()
    println(
        s.fold(StringBuilder()){acc, c ->
            acc.apply {
                append(
                    if (shifting == "R") keys[keysIndices[c]!! - 1]
                    else keys[keysIndices[c]!! + 1]
                )
            }
        }
    )
}