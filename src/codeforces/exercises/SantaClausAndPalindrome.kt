package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    SantaClausAndPalindrome.main()
}

object SantaClausAndPalindrome {

    val p = 31L
    val m = (1e9 + 9).toLong()
    var pows = mutableListOf<Long>()
    var prefixes = mutableListOf<Long>()
    var suffixes = mutableListOf<Long>()
    val a = mutableListOf<Int>()

    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (k, n) = br.readLine().split(" ").map { it.toInt() }
        pows = computePowers(n)
        for (i in 0 until k){
            val (s_i, a_i) = br.readLine().split(" ")
            a.add(a_i.toInt())
            prefixes.add(computeHash(s_i))
            suffixes.add(computeHash(s_i.reversed()))
        }


        println(prefixes)
        println(suffixes)
        println(a)

        val used = HashMap<Long, Int>()
        var beauty = 0
        for (i in 0 until k){
            val prefix_i = prefixes[i]
            for (j in 0 until k){
                val suffix_j = suffixes[j]
                val sum = a[i] + a[j]
                if (i != j && prefix_i == suffix_j && sum > 0){
                    if (prefix_i in used && used[prefix_i]!! > sum){
                        beauty -= used[prefix_i]!!
                        beauty += sum
                        used[prefix_i] = sum
                    } else{
                        used[prefix_i] = sum
                        beauty += sum
                    }
                }
            }
        }

        println(beauty)

        val unusedPre = prefixes.filterIndexed {i, _ -> !(prefixes[i] in used)}
        val unusedSu = suffixes.filterIndexed {i, _ -> !(prefixes[i] in used)}

        for (i in unusedPre.indices){
            if (unusedPre[i] == unusedSu[i] && a[i] > 0){
                beauty += a[i]
            }
        }

        println(beauty)
    }

    fun isPalindrome (s: String): Boolean{
        var isPalindrome = true
        var i = 0
        var j = s.length - 1
        while (i < j && isPalindrome){
            if (s[i] != s[j]) isPalindrome = false
            else{
                i++
                j--
            }
        }
        return isPalindrome
    }

    fun computeHash (s: String): Long{
        val n = s.length
        var prev = s[0] - 'a' + 1L
        var hash = 0L
        for (i in 0 until n){
            hash = (prev + (s[i] - 'a' + 1) * pows[i]) % m
        }
        return hash
    }

    fun computePowers (n: Int): MutableList<Long>{
        val pows = MutableList(n){0L}
        pows[0] = 1
        for (i in 1 until n){
            pows[i] = (p*pows[i - 1]) % m
        }
        return pows
    }
}