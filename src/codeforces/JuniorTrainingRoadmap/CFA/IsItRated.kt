package codeforces.JuniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val ratings = List(n){
        br.readLine().split(" ").map { it.toInt() }
    }.map { it.first() to it.last() }
    val existChange = ratings.dropWhile { (a, b) ->
        a == b
    }.isNotEmpty()

    if (existChange){
        println("rated")
    } else {
        val sorted = ratings.sortedByDescending { it.first }
        if (sorted == ratings){
            println("maybe")
        } else {
            println("unrated")
        }
    }
}