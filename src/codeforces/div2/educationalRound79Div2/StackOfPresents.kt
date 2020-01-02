package codeforces.div2.educationalRound79Div2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class MinStack<A>(val max: (A, A) -> A){
    val st = Stack<Pair<A, A>>()

    fun add(x: A){
        val newMin = if (st.empty()) x else max(x, st.peek().second)
        st.push(x to newMin)
    }

    fun remove(): A = st.pop().first

    fun getMax(): A = st.pop().second

    fun isEmpty(): Boolean = st.isEmpty()
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    for (i in 0 until t){
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        val a = br.readLine().split(" ").map { it.toInt() }
        val b = br.readLine().split(" ").map { it.toInt() }
        val indices = calcIndices(a)
        println(calcMinTime(b, indices))

    }
}

fun calcMinTime(b: List<Int>, indices: Array<Int>): Int{
    val max = {x: Pair<Int, Int> , y: Pair<Int, Int> -> if (x.first > y.second) x else y}
    val removedIndices = MinStack(max)


    tailrec fun go(b: List<Int>, lastTop: Int, count: Int): Int =
        if (b.isEmpty()) count
        else{
            val gift = b.first()
            val pos = indices[gift]

            if (removedIndices.isEmpty()){
                removedIndices.add(pos to 1)
            }else{
                
            }

            val newTop = if (pos == 0) 0 else pos - 1
            if (pos <= lastTop){
                println(count + 1)
                go(b.drop(1), newTop, count + 1)
            }
            else{
                println(count + (2*pos + 1 ))
                go(b.drop(1), newTop, count + (2*pos + 1 ))
            }

        }
    return go(b, 0, 0)
}

fun calcIndices(a: List<Int>): Array<Int>{
    val n = a.size
    val indices = Array(n + 1){_ -> 0}

    for (i in 0 until n){
        indices[a[i]] = i
    }

    return indices
}