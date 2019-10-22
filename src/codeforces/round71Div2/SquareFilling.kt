package codeforces.round71Div2

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nm = br.readLine().split(" ").map { it.toInt() }
    val n = nm[0]
    val m = nm[1]
    val A = Array(n){ List(m){x -> 0}}
    val marked = Array(n){Array(m){x -> false}}

    for (i in 0 until n){
        A[i] = br.readLine().split(" ").map { it.toInt() }
    }

    var allZeroes = true

    val movements = ArrayList<Pair<Int, Int>>()
    for (i in 0 until n - 1){
        for (j in 0 until m - 1){
            if (A[i][j] == 1){
                allZeroes = false
                if (A[i][j + 1] == 1 && A[i + 1][j] == 1 && A[i + 1][j + 1] == 1){
                    movements.add(Pair(i + 1,j + 1))
                }
                marked[i][j] = true
                marked[i][j + 1] = true
                marked[i + 1][j] = true
                marked[i + 1][j + 1] = true
            }
        }
    }

    if (allZeroes){
        println(0)
    }else{
        if (movements.size == 0){
            println(-1)
        }else{

            var allOnesMarked = true
            var i = 0
            var j = 0

            while (i < n && allOnesMarked){
                while (j < m && allOnesMarked){
                    if (A[i][j] == 1 && !marked[i][j]) allOnesMarked = false
                    j++
                }
                j = 0
                i++
            }


            if (allOnesMarked){
                println(movements.size)
                for ((i, j) in movements){
                    println("$i $j")
                }
            }else{
                println(-1)
            }

        }

    }

}