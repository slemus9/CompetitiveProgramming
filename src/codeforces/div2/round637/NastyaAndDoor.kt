package codeforces.div2.round637

import java.io.BufferedReader
import java.io.InputStreamReader

object NastyaAndDoor {

    fun main () {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val t = br.readLine().toInt()

        for (i in 1 .. t) {
            val (n, k) = br.readLine().split(" ").map { it.toInt() }
            val a = br.readLine().split(" ").map { it.toInt() }
            val peaks = HashMap<Int, Int>()
            var j = 1

            while (j < n - 1){
                if (a[j - 1] < a[j] && a[j] > a[j + 1]){
                    peaks[j - 2] = 1 + peaks.getOrDefault(j - 2, 0)
                }
                j++
            }
            
        }
    }
}

fun main() {
    NastyaAndDoor.main()
}