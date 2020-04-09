package codeforces.div2.round631Div2

import java.io.BufferedReader
import java.io.InputStreamReader

object DreamoonLikesPermutations {

    fun isPermutation (i: Int, j: Int, a: List<Int>): Boolean{
        val len = j - i
        val used = HashMap<Int, Int>()
        for (k in i until j){
            used[a[k]] = 1 + used.getOrDefault(a[k], 0)
        }
        //println("Array Range: ${i until j}. Permutation Range: ${1 .. len}")
        //(1 .. len).forEach{x -> println("$x ${used[x] == 1}")}
        return (1 .. len).dropWhile { it in used && used[it] == 1 }.isEmpty()
    }

    fun main (){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val t = br.readLine().toInt()

        for (i in 1 .. t){
            val n = br.readLine().toInt()
            val a = br.readLine().split(" ").map { it.toInt() }
            val max = a.max()!!
            val firstCase = isPermutation(0, max, a) && isPermutation(max, n, a)
            val secondCase = isPermutation(0, n - max, a) && isPermutation(n - max, n, a)
            if (firstCase && secondCase && n - max != max){
                println(2)
                println("${n - max} ${max}")
                println("${max} ${n - max}")
            } else if (firstCase){
                println(1)
                println("${max} ${n - max}")
            } else if (secondCase){
                println(1)
                println("${n - max} ${max}")
            } else{
                println(0)
            }
        }
    }
}

fun main() {
    DreamoonLikesPermutations.main()
}