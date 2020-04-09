package MUA.S201901.s1.vs3

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val axy = br.readLine().split(" ").map { it.toDouble() }
    val a = axy[0]
    val x = axy[1]
    val y = axy[2]

    var sq = -1

    if (abs(x) < a/2){
        if (abs(y) > 0 && abs(y) < a){
            sq = 1
        }else if (abs(y) > a && abs(y) < 2*a ){
            sq = 2
        }else if( abs(y) > 3*a && abs(y) < 4*a){
            sq = 5
        }
    }else if (abs(x) < a){
        if (abs(y) > 2*a && abs(y) < 3*a){
            if (y > 0){
                sq = 4
            }else{
                sq = 3
            }
        }else if (abs(y) > 4*a && abs(y) < 5*a){
            if (y > 0){
                sq = 7
            }else{
                sq = 6
            }
        }
    }

    print(sq)
}