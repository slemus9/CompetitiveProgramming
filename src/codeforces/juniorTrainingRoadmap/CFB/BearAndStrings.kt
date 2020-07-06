package codeforces.juniorTrainingRoadmap.CFB

import java.io.BufferedReader
import java.io.InputStreamReader

fun getLps (s: String): Array<Int>{
    val n = s.length
    val lps = Array(n){0}
    var j = 0
    var i = 1

    while (i < n){
        if (s[i] == s[j]){
            lps[i] = j + 1
            i++
            j++
        } else{
            if (j == 0){
                lps[i] = 0
                i++
            } else{
                j = lps[j - 1]
            }
        }
    }
    return lps
}

fun kmpSearch (pattern: String, s: String): List<Int> {
    val indices = ArrayList<Int>()
    val n = s.length
    val m = pattern.length
    var i = 0
    var j = 0
    val lps = getLps(s)

    while (i < n){
        if (j == m){
            indices.add(i - m)
            j = 0
        } else if (s[i] == pattern[j]){
            i++
            j++
        } else{
            if (j == 0){
                i++
            } else{
                j = lps[j - 1]
            }
        }
    }

    if (j == m) indices.add(i - m)
    return indices
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine()
    val n = s.length
    val indices = kmpSearch("bear", s)
    println(n)
    println(indices)
    println(
        indices.fold(0){acc, i ->
            println(acc + if (i == 0) n - (i + 3)
            else if (i == n - 4) i + 1
            else n - (i + 3) + i)
            acc + if (i == 0) n - (i + 3)
                else if (i == n - 4) i + 1
                else n - (i + 3) + i + 1
        }
    )
}