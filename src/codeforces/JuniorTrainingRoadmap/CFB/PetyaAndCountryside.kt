package codeforces.JuniorTrainingRoadmap.CFB

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun increasingLongestSubseq (h: List<Int>): MutableList<Int> {
    val n = h.size
    val icls = MutableList(n){1}
    for (i in 1 until n) {
        icls[i] = if (h[i - 1] <= h[i]) icls[i - 1] + 1 else 1
    }
    return icls
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val h = br.readLine().split(" ").map { it.toInt() }
    val icls = increasingLongestSubseq(h)
    val ricls = increasingLongestSubseq(h.reversed()).reversed()
    val maxInc = icls.max()
    val maxRInc = ricls.max()
    val peakIndices = (0 until n).filter { icls[it] == maxInc }
    val peakRIndices = (0 until n).filter { ricls[it] == maxRInc }
    val maxPeakIdx = peakIndices.maxBy { i ->
        if (i == n - 1) icls[i] else icls[i] + ricls[i + 1]
    }!!
    val maxPeakRIdx = peakRIndices.maxBy { i ->
        if (i == 0) ricls[i] else ricls[i] + icls[i - 1]
    }!!
    val maxPeak =
        if (maxPeakIdx == n - 1) icls[maxPeakIdx]
        else icls[maxPeakIdx] + ricls[maxPeakIdx + 1]
    val maxPeakR =
        if (maxPeakRIdx == 0) ricls[maxPeakRIdx]
        else ricls[maxPeakRIdx] + icls[maxPeakRIdx - 1]
    println(max(maxPeak, maxPeakR))
}