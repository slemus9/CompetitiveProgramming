package MUA.S201901.s1.s5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

object Benches{
    fun getMaxAndMinK(n: Int, m: Int, benches: IntArray) : IntArray{
        val ans = IntArray(2)
        val max = benches.max()
        ans[1] = m + max!!
        val minPQ = PriorityQueue<Int>()

        for (i in 0 until n){
            minPQ.add(benches[i])
        }


        for (i in 0 until m){
            minPQ.add(minPQ.poll() + 1)
        }

        ans[0] = minPQ.max()!!

        return ans
    }
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val benches = IntArray(n)

    for (i in 0 until n){
        benches[i] = br.readLine().toInt()
    }
    val ans = Benches.getMaxAndMinK(n, m, benches)
    println(ans[0].toString() + " " + ans[1])

}