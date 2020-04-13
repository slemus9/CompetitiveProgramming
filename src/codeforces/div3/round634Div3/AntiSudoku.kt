package codeforces.div3.round634Div3

import java.io.BufferedReader
import java.io.InputStreamReader

object AntiSudoku{

    fun main (){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val t = br.readLine().toInt()
        val sudoku = MutableList(9){br.readLine().map { "$it".toInt() }.toMutableList()}

        val pairs = listOf(0 to 0, 1 to 3, 2 to 6, 3 to 1, 4 to 4, 5 to 7,
            6 to 2, 7 to 5, 8 to 8)

        for ((i, j) in pairs)
            sudoku[i][j] = (sudoku[i][j] + 1) % 9

        for (i in 0 until 9){
            for (j in 0 until 9){
                print(sudoku[i][j])
            }
            if (i != 8)
                println()
        }

    }
}

fun main() {
    AntiSudoku.main()
}