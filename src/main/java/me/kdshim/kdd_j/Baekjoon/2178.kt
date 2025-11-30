package me.kdshim.kdd_j.Baekjoon

import java.util.LinkedList
import java.util.Queue

class `2178` {
    fun main(){
        val (n, m) = readLine()!!.split(" ").map{ it.toInt() }
        val map = Array(n) {readLine()!!.map{ it - '0'}.toIntArray()}
        val visited = Array(n) { BooleanArray(m){ false } }

        val dx = intArrayOf(-1, 1, 0, 0)
        val dy = intArrayOf(0, 0, -1, 1)

        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.add(Pair(0, 0))
        visited[0][0] = true

        var steps = Array(n) { IntArray(m) { 0 }}

        while(queue.isNotEmpty()){
            val (x, y) = queue.poll()
            for (i in 0 until 4){
                val nx = x + dx[i]
                val ny = y + dy[i]
                if(nx in 0 until n && ny in 0 until m && !visited[nx][ny] && map[nx][ny] == 1){
                    queue.add(Pair(nx, ny))
                    visited[nx][ny] = true
                    steps[nx][ny] = steps[x][y] + 1
                }
            }
        }

        println(steps[n-1][m-1])
    }
}