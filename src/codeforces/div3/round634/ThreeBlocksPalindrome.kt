package codeforces.div3.round634

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

object ThreeBlocksPalindrome {

    fun <A> groupByConsecutive (xs: List<A>): List<List<A>> {
        val groups = xs.zipWithNext().fold(ArrayList<ArrayList<A>>() to arrayListOf(xs.first())){
            (acc, group), (x, y) ->
                if (x == y) acc to group.apply { this.add(x) }
                else acc.apply { this.add(group) } to arrayListOf(y)
        }
        return if (groups.second.isEmpty()) groups.first else groups.first.apply { this.add(groups.second) }
    }

    fun getCount (a: List<Int>, alphabet: Set<Int>): Map<Int, List<Int>>{
        val n = a.size
        val count = HashMap<Int, List<Int>>()
        for (j in alphabet){
            count[j] = List(n + 1){0}.foldIndexed(ArrayList<Int>() to 0){
                i, (sumArr, acc), _ ->
                    if (i == 0) sumArr.apply { this.add(0) } to 0
                    else
                        if (a[i - 1] == j) sumArr.apply { this.add(acc + 1) } to acc + 1
                        else sumArr.apply { this.add(acc) } to acc
            }.first
        }
        return count
    }

    fun getCountInRange (lo: Int, hi: Int, j: Int, count: Map<Int, List<Int>>) =
        count[j]!![hi] - count[j]!![lo - 1]

    fun getMaxInRange (lo: Int, hi: Int, count: Map<Int, List<Int>>, alphabet: Set<Int>) =
        alphabet.fold(0){
            acc, j -> max(acc, getCountInRange(lo, hi, j, count))
        }

    fun getIndices (groups: List<List<Int>>): Map<Int, List<Pair<Int, Int>>>{
        val n = groups.size
        val idxs = HashMap<Int, ArrayList<Pair<Int, Int>>>()
        var prevSize = 0
        for (i in 0 until n){
            val a_i = groups[i].first()
            idxs[a_i] = idxs.getOrDefault(a_i, ArrayList()).apply { this.add(prevSize to groups[i].size) }
            prevSize += groups[i].size
        }
        return idxs
    }

    fun main (){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val t = br.readLine().toInt()

        for (i in 1 .. t){
            val n = br.readLine().toInt()
            val a = br.readLine().split(" ").map { it.toInt() }
            val groups = groupByConsecutive(a)
            val alphabet = a.toSet()
            val count = getCount(a, alphabet)
            val idxs = getIndices(groups)
            val currIdxs = idxs.map { (g_id, _) -> g_id to 0 }.toMap().toMutableMap()

            println(currIdxs)
            println(groups)
            println(count)
            println(getMaxInRange(1, n, count, alphabet))
            println(idxs)

            val ans = groups.take(groups.size/2 + 1).fold(0){
                acc, group ->
                    val sz = group.size
                    val j = group.first()
                    val currIdx = currIdxs[j]!!
                    val windowSz = idxs[j]!!.size - 1
                    val lo = idxs[j]!![currIdx].first + 1
                    println(idxs[j])
                    val lastIndexJ = idxs[j]!![windowSz].first + 1
                    val hi = if (lastIndexJ != lo) lastIndexJ else lastIndexJ + sz - 1
                    currIdxs[j] = currIdxs[j]!! + 1
                    println("j: $j, currIdx: $currIdx, lo: $lo, hi: $hi hiSize: ${idxs[j]!![windowSz].second}")
                    val outer = getCountInRange(lo, hi - 1 + idxs[j]!![windowSz].second, j, count)
                    val loInner = lo + sz
                    val hiInner = if (currIdx + 1 >= windowSz) loInner else idxs[j]!![currIdx + 1].first
                    println("   loInner: $loInner, hiInner: $hiInner")
                    val inner = if (sz == 1) 0 else getMaxInRange(loInner, hiInner, count, alphabet)
                    println("   outer: $outer, inner: $inner, acc: $acc")
                    max(acc, outer + inner)

            }

            println(ans)
        }
    }
}

fun main() {
    ThreeBlocksPalindrome.main()
}