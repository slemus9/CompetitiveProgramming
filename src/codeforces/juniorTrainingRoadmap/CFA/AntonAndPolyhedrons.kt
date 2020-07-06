package codeforces.juniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val polyhedrons = List(n){br.readLine()}
    println(
        polyhedrons.fold(0L){acc, p ->
            val fst = p.first()
            acc + if (fst == 'T') 4
                else if (fst == 'C') 6
                else if (fst == 'O') 8
                else if (fst == 'D') 12
                else 20
        }
    )
}