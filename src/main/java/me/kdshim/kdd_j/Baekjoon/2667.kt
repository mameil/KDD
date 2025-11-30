package me.kdshim.kdd_j.Baekjoon

import kotlin.collections.get
import kotlin.collections.set
import kotlin.text.get

class `2667` {

    fun main(){
        val n = readLine()!!.toInt()
        val map = Array(n) { readLine()!!.map { it - '0' }.toIntArray() }
        val visited = Array(n) { BooleanArray(n) }
        val dx = intArrayOf(-1, 1, 0, 0)
        val dy = intArrayOf(0, 0, -1, 1)

        val result = mutableListOf<Int>()

        fun fn(x: Int, y: Int): Int{
            visited[x][y] = true
            var cnt = 1
            for(i in 0 until 4){
                val nx = x + dx[i]
                val ny = y + dy[i]
                if(nx in 0 until n && ny in 0 until n && !visited[nx][ny] && map[nx][ny] == 1){
                    cnt += fn(nx, ny)
                }
            }

            return cnt
        }

        for(i in 0 until n){
            for(j in 0 until n){
                if(!visited[i][j] && map[i][j] == 1){
                    result.add(fn(i, j))
                }
            }
        }

        println(result.size)
        result.sorted().forEach{println(it)}
    }


}