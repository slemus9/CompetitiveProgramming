package algorithms.stringProcessing.stringHashing.problems

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * https://www.spoj.com/problems/NHAY
 */
const val p = 31
const val m = 1000000000 + 9

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var line = br.readLine()

    while (line != null){
        val n = line.toInt()
        val needle = br.readLine()
        val haystack = br.readLine()

        if (haystack.length > n){
            val hs = precHash(haystack, p, m)
            val h = calculateHash(needle, 1, 0)
            calculateAllSubstringHashes(n, haystack, h, hs)
        }
        println()

        line = br.readLine()
    }
}

fun precHash(s: String, p: Int, m: Int): Array<Long>{
    val hs = Array<Long>(s.length){x -> 0}
    var curr = ""

    for (i in 0 until s.length){
        curr += s[i]
        hs[i] = calculateHash(curr, 1, 0)
    }

    return hs
}

fun mod(x: Long, m: Long) = (x % m + m) % m

fun fastSubstringHash(s: String, i: Int, j: Int, hs: Array<Long>): Long =
        mod(hs[j] - hs[if (i == 0) 0 else i - 1], m.toLong())


fun binExp(a: Long, n: Long): Long {
    tailrec fun go(a: Long, n: Long, acc: Long): Long{
        if (a == 0L) return 0
        if (n == 0L) return 1
        if (n == 1L){
            return a * acc
        }
        if (n % 2 == 0L)
            return go(a * a, n/2, acc)
        else
            return go(a * a, (n - 1)/2, a * acc)
    }
    return go(a, n, 1)
}


fun calculateAllSubstringHashes(n: Int, s: String, h: Long, hs: Array<Long>){
    var i = 0
    var j = 0
    var currSub = s[0].toString()
    var reachedEnd = false

    while (j < s.length && !reachedEnd){
        if (currSub.length < n){
            j ++
            currSub += s[j]
        }else{
            val currH = fastSubstringHash(currSub, i, j, hs)
            val exp = h* binExp(p.toLong(), i.toLong())
            if (h* binExp(p.toLong(), i.toLong()) == currH) println(i)
            if (j == s.length - 1) reachedEnd = true
            i ++
            j = i
            currSub = s[i].toString()
        }
    }
}


tailrec fun calculateHash(s: String, p_pow: Long, hash_val: Long): Long =
        if (s.isEmpty())
            hash_val
        else
            calculateHash(s.drop(1), (p * p_pow) % m
                    , (hash_val + (s.first() - 'a' + 1)*p_pow) % m)