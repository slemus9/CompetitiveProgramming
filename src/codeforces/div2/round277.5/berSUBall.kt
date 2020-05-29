package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val boys = sort(br.readLine().split(" ").map { it.toInt() })
    val m = br.readLine().toInt()
    val girls = sort(br.readLine().split(" ").map { it.toInt() })

    val takenBoys = Array(n){x -> false}
    val takenGirls = Array(m){x -> false}

    var i = 0
    var j = 0
    var count = 0

    while (i < n && j < m){

        if (i == j){
            if (isValidPair(boys[i], girls[i]) && !takenBoys[i] && !takenGirls[i]){
                count ++
                takenBoys[i] = true
                takenGirls[i] = true
                i ++
                j ++
            }else{
                if (boys[i] < girls[i]) i ++
                else j ++
            }
        }else{
            if (isValidPair(boys[i], girls[j]) && !takenBoys[i] && !takenGirls[j]){
                takenBoys[i] = true
                takenGirls[j] = true
                count ++
                i ++
                j ++
            }else{
                if (i > j){
                    if (boys[i] > girls[j]) j++
                    else i++
                }
                else{
                    if (girls[j] > boys[i]) i++
                    else j++
                }
            }
        }

    }
    println(count)

}


fun isValidPair(x: Int, y: Int) = abs(x - y) <= 1


fun sort(xs: List<Int>): Array<Int>{
    val count = Array(110){x -> 0}
    for (x in xs){
        count[x] += 1
    }

    val sorted = Array(xs.size){x -> 0}

    var i = 0
    var j = 0

    while (i < count.size){
        while (count[i] > 0){
            sorted[j] = i
            count[i]--
            j++
        }
        i++
    }

    return sorted
}