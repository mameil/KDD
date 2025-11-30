package me.kdshim.kdd_j.Baekjoon

import java.util.*

class `1926_bfs` {

    fun main(){
        val (n, m) = readLine()!!.split(" ").map{ it.toInt() }
        val map = Array(n){ readLine()!!.split(" ").map{ it.toInt() }.toIntArray() }
        val visited = Array(n) { BooleanArray(m) }

        val dx = intArrayOf(-1, 1, 0, 0)
        val dy = intArrayOf(0, 0, -1, 1)

        var paintCount = 0
        var maxPaintSize = 0

        for(i in 0 until n){
            for(j in 0 until m){
                if(!visited[i][j] && map[i][j] == 1){
                    paintCount++

                    val q: Queue<Pair<Int, Int>> = LinkedList()
                    q.add(Pair(i, j))
                    visited[i][j] = true

                    var paintSize = 1
                    while(q.isNotEmpty()){
                        val (x, y) = q.poll()

                        for(d in 0 until 4){
                            val nx = x + dx[d]
                            val ny = y + dy[d]

                            if(nx in 0 until n && ny in 0 until m && !visited[nx][ny] && map[nx][ny] == 1){
                                visited[nx][ny] = true
                                q.add(Pair(nx, ny))
                                paintSize++
                            }
                        }
                    }

                    maxPaintSize = maxOf(maxPaintSize, paintSize)
                }
            }
        }

        println(paintCount)
        println(maxPaintSize)
    }
}