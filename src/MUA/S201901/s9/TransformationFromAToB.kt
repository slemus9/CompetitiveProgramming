package MUA.S201901.s1.s9

import java.io.BufferedReader
import java.io.InputStreamReader

fun <A, B, C> memo (f: (A, B) -> C): (A, B) -> C{
    val vals = mutableMapOf<Pair<A, B>, C>()
    return {
        x: A, y: B -> vals.getOrPut(Pair(x, y)){f(x, y)}
    }

}


fun isThereAWay(a: Long, b: Long): List<Long> {

    fun go(a: Long, b: Long, ls: List<Long>): List<Long> =
        if(a == b) ls + listOf(b)
        else if (a > b || a < 0) emptyList()
        else go(a*2, b, ls + listOf(a)) + go(a*10 + 1, b, ls + listOf(a))


    return go(a, b, emptyList())
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val ab = br.readLine().split(" ").map { it.toLong() }
    val a = ab[0]
    val b = ab[1]
    val result = memo(::isThereAWay)(a, b)
    if (result.isEmpty()){
        println("NO")
    }else{
        println("YES")
        println(result.size)
        print(result[0])
        for (i in 1 until result.size){
            print(" " + result[i])
        }
    }

}