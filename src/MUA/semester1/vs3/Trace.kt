package MUA.semester1.s1.vs3

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.PI

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val rs = br.readLine().split(" ").map { it.toInt() }.sorted()
    var totalArea = 0.0
    var i = n - 1

    while (i >= 0){
        if (i == 0){
            totalArea += rs[0]*rs[0]

        }else{
            totalArea += (rs[i]*rs[i]) - (rs[i - 1]*rs[i - 1])
        }
        i -= 2
    }

    println("%.10f".format(PI*totalArea))

}