package codeforces.div2.round578Div2

import java.io.BufferedReader
import java.io.InputStreamReader

val hotel = Array<Int>(10){x -> 0}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val events = br.readLine()

    var l = 0
    var r = 9

    for (i in 0 until n){
        if (events[i] == 'L'){

            var changed = false
            for (j in 0 .. l){
                if (hotel[j] == 0){
                    l = j
                    changed = true
                    break
                }
            }

            if (!changed){
                hotel[l] = 1
                l ++
            }

        }
        else if (events[i] == 'R'){

            var changed = false
            for (j in 9 .. r){
                if (hotel[j] == 0){
                    r = j
                    changed = true
                    break
                }
            }

            if (!changed){
                hotel[r] = 1
                r --
            }
        } else {
            val room = events[i].toString().toInt()
            hotel[room] = 0
        }
    }

    for (i in 0 .. 9){
        print(hotel[i])
    }
}