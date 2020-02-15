package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    TextEditor.main()
}

object TextEditor {

    val p = 31L
    val m = (1e9 + 9).toLong()

    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val A = br.readLine()
        val B = br.readLine()
        val n = br.readLine().toInt()
        val indices = searchIndices(A, B)

        if (indices.size < n){
            println("IMPOSSIBLE")
        } else{

        }
    }

    fun searchIndices (A: String, B: String): MutableList<Int>{
        val indices = mutableListOf<Int>()
        val c = B.first()
        for (i in 0 until A.length){
            if (A[i] == c){
                indices.add(i)
            }
        }
        return indices
    }

    fun computePrefixHash (s: String): Array<Long>{
        val n = s.length
        val prefixh = Array(n){0L}
        var pow = 1L
        prefixh[0] = s[0] - 'a' + 1L
        for (i in 0 until n){
            pow = (pow*p) % m
            prefixh[i] = (prefixh[i - 1] + (s[i] - 'a' + 1)*pow) % m
        }
        return prefixh
    }

}