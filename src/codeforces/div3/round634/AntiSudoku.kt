package codeforces.div3.round634

import java.io.BufferedReader
import java.io.InputStreamReader

object AntiSudoku{

    fun main (){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val t = br.readLine().toInt()

        val pairs = listOf(0 to 0, 1 to 3, 2 to 6, 3 to 1, 4 to 4, 5 to 7,
            6 to 2, 7 to 5, 8 to 8)

        for (i in 1 .. t){
            val sudoku = MutableList(9){br.readLine().map { "$it".toInt() } as MutableList }

            for ((i, j) in pairs)
                sudoku[i][j] = (sudoku[i][j]) % 9 + 1

            for (i in 0 until 9){
                println(sudoku[i].joinToString(""))
            }
        }
    }
}

fun main() {
    AntiSudoku.main()
}