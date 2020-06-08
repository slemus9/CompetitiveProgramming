package codeforces.JuniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine()
    val s = br.readLine()
    val contigs = s.fold(ArrayList<StringBuilder>()){
        acc, c -> acc.apply {
            if (isEmpty() || last().last() != c){
                add(StringBuilder(c.toString()))
            } else {
                last().append(c)
            }
        }
    }
    println(
        contigs.fold(0){
            acc, block -> acc + block.length - 1
        }
    )
}