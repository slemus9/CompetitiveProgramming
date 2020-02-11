package algorithms.stringProcessing.stringHashing

import algorithms.algebra.fundamentals.binExpRec
import algorithms.algebra.modularArithmetic.modularInverse.modInverse
import codeforces.exercises.Password
import java.io.BufferedReader
import java.io.InputStreamReader

object StringHashing {
    val p = 31L
    val m = (1e9 + 9).toLong()
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s by lazy { br.readLine() }
    val n = s.length
    val pows by lazy { computePowers(n) }
    val inv by lazy { computePowersInverse() }
    val h by lazy { computeHashes(s) }

    fun substringHash (i: Int, j: Int): Long =
        (inv[i]*((h[j] - h[if (i == 0) 0 else i - 1]) % m + m) % m) % m

    fun computePowers (n: Int): Array<Long>{
        val pows = Array(n){0L}
        pows[0] = 1
        for (i in 1 until n){
            pows[i] = (pows[i - 1] % m * p % m) % m
        }
        return pows
    }

    fun computeHashes (s: String): Array<Long>{
        val n = s.length
        val h = Array(n){0L}
        h[0] = (s[0] - 'a' + 1) % m
        for (i in 1 until n){
            h[i] = (h[i - 1] + ((s[i] - 'a' + 1) % m) * pows[i]) % m
        }
        return h
    }

    fun computePowersInverse (): Array<Long>{
        val n = pows.size
        val inv = Array(n){0L}
        for (i in 0 until n){
            inv[i] = algorithms.algebra.modularArithmetic.modularInverse.modInverse(pows[i], m)
        }
        return inv
    }
    
}
