package MUA.S201901.s1.s8

import java.io.BufferedReader
import java.io.InputStreamReader

object ArrayWithoutLocalMaximums

data class Triple(var decreasing: Int, var estable : Int, var increasing: Int)

fun add(a: Int, b: Int, base: Int): Int{
    return ((a % base) + (b % base)) % base
}

fun main(args: Array<String>) {
    val modBase = 998244353
    val maxNum = 200
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }

    val M = Array(n + 1){Array<Triple>(maxNum + 1){x -> Triple(0,0,0)}}

    val lastColumn = M[n]
    val lastNum = arr[n - 1]
    if(lastNum != -1){
        if (lastNum + 1 <= maxNum){
            lastColumn[lastNum].decreasing = 1
        }
        lastColumn[lastNum].estable = 1
    }else{
        for (i in 1 .. maxNum){
            val canBeDecreasing = i + 1 <= maxNum
            if (canBeDecreasing){
                lastColumn[i].decreasing = 1
            }
            lastColumn[i].estable = 1
        }
    }


    for (i in n - 1 downTo 1){
        val numInArr = arr[i]
        if(numInArr != -1){
            val canBeDecreasing = (numInArr + 1 <= maxNum) && (i != 1)
            val canBeIncreasing = numInArr - 1 > 0
            val triple = M[i][numInArr]
            val frontColumn = M[i + 1]


            for (k in 1 until frontColumn.size){
                val sumEst = triple.estable
                if (k > numInArr){
                    triple.estable = add(frontColumn[k].increasing, sumEst, modBase)

                }else if (k < numInArr){
                    triple.estable = add(frontColumn[k].decreasing, sumEst, modBase)
                }else{
                    triple.estable = add(frontColumn[k].estable, sumEst, modBase)
                }
            }
            if (canBeDecreasing){
                triple.decreasing = triple.estable
            }
            if (canBeIncreasing){

                for (k in 1 until frontColumn.size){
                    val sumInc = triple.increasing
                    if (k > numInArr){
                        triple.increasing = add(frontColumn[k].increasing, sumInc, modBase)

                    }else if (k == numInArr){
                        triple.increasing = add(frontColumn[k].estable, sumInc, modBase)
                    }
                }
            }


        }else{
            for (j in 1 until n){
                val canBeDecreasing = (i + 1 <= maxNum) && (i != 1)
                val canBeIncreasing = i - 1 > 0
                val triple = M[i][j]
                val frontColumn = M[i + 1]

                for (k in 1 until frontColumn.size){
                    val sumEst = triple.estable
                    if (k > j){
                        triple.estable = add(frontColumn[k].increasing, sumEst, modBase)

                    }else if (k < j){
                        triple.estable = add(frontColumn[k].decreasing, sumEst, modBase)
                    }else{
                        triple.estable = add(frontColumn[k].estable, sumEst, modBase)
                    }
                }

                if (canBeDecreasing){

                    for (k in 1 until frontColumn.size){
                        triple.decreasing = triple.estable
                    }
                }
                if (canBeIncreasing){

                    for (k in 1 until frontColumn.size){
                        val sumInc = triple.increasing
                        if (k > j){
                            triple.increasing = add(frontColumn[k].increasing, sumInc, modBase)

                        }else if (k == j){
                            triple.increasing = add(frontColumn[k].estable, sumInc, modBase)
                        }
                    }
                }

            }
        }

    }


    var result = 0
    for (t in M[1]){
        result = add(t.decreasing, result, modBase)
        result = add(t.estable, result, modBase)
        result = add(t.increasing, result, modBase)
    }

    println(result)

}