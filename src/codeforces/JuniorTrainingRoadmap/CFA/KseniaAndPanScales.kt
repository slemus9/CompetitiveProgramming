package codeforces.JuniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val scales = br.readLine().split("|")
    val notUsed = br.readLine()
    val left = scales[0].length
    val right = scales[1].length
    val missing = abs(left - right)
    if (notUsed.length >= missing && (notUsed.length - missing) % 2 == 0) {
        val useToComplete = notUsed.substring(0 until missing)
        val rest = notUsed.substring(missing)
        val rest1 = rest.substring(0 until rest.length/2)
        val rest2 = rest.substring(rest.length/2)
        val newLeft = StringBuilder(scales[0])
        val newRight = StringBuilder(scales[1])
        if (left < right) {
            newLeft.append(useToComplete + rest1)
            newRight.append(rest2)
        } else {
            newLeft.append(rest1)
            newRight.append(useToComplete + rest2)
        }
        println("$newLeft|$newRight")
    } else {
        println("Impossible")
    }
}