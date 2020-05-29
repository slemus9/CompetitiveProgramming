package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    Password.main()
}

object Password{

    val p = 31L
    val m = (1e9 + 9).toLong()
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s by lazy { br.readLine() }
    val n = s.length
    val pows by lazy { computePowers(n) }
    val inv by lazy { computePowersInverse() }
    val h by lazy { computeHashes(s) }

    fun main() {

        val lenLps = computeLps(s)
        if (lenLps == 0){
            println("Just a legend")
        } else{
            var i = 1
            var j = i + lenLps - 1
            var found = false
            val hash = h[lenLps - 1]

            while (i < n - lenLps && !found){
                val h_i_j = substringHash(i, j)
                if (h_i_j == hash) found = true
                else{
                    i ++
                    j = i + lenLps - 1
                }
            }

            println(
                if (found) s.substring(0 until lenLps)
                else "Just a legend"
            )
        }
    }

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
            inv[i] = modInverse(pows[i], m)
        }
        return inv
    }

    fun gcdExtended(a: Long, b: Long): Triple<Long, Long, Long>{
        tailrec fun go(a: Long, b: Long, x: Long, y: Long, prevx: Long, prevy: Long): Triple<Long, Long, Long> =
            if (b == 0L) Triple(a, prevx, prevy)
            else {
                val q = a/b
                go(b, a % b, prevx -  q*x, prevy - q*y, x, y)
            }
        return go(a, b, 0, 1, 1, 0)
    }

    fun modInverse(a: Long, m: Long): Long {
        val gcd = gcdExtended(a, m)
        val g = gcd.first
        val x = gcd.second
        if (g != 1L) return -1
        else return (x % m + m) % m
    }

    fun computeLps (s: String): Int{
        val n = s.length
        val lps = Array(n){_ -> 0}
        var len = 0
        var i = 1

        while (i < n){
            if (s[i] == s[len]){
                lps[i] = len + 1
                len++
                i++
            }else{
                if (len > 0){
                    len = lps[len - 1]
                }else{
                    lps[i] = 0
                    i++
                }
            }
        }

        return if (lps[n - 1] >= n/2 && lps[n - 1] > 0) lps[lps[n - 1] - 1] else lps[n - 1]
    }
}
