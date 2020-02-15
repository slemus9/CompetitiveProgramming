package FacebookTest2020

import java.io.BufferedReader
import java.io.InputStreamReader

data class PileCount (val quantity: Int, val height: Int)
data class PileTransformState (val count: PileCount, val stepsTaken: Long)

fun pilesOfBoxes(boxesInPiles: Array<Int>): Long {
    val heightGrouping = boxesInPiles.groupBy { it }.map { (k, v) ->  PileCount(v.size, k)}
    val sortedHeights = heightGrouping.sortedByDescending { it.height }

    return  sortedHeights.fold(PileTransformState(sortedHeights[0].copy(quantity = 0), 0) ){ transform, pileCount ->
        val newPileCount = PileCount(transform.count.quantity + pileCount.quantity, pileCount.height)
        PileTransformState(newPileCount, transform.stepsTaken + transform.count.quantity)
    }.stepsTaken
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val piles = Array(n){br.readLine().toInt()}
    println(pilesOfBoxes(piles))
}