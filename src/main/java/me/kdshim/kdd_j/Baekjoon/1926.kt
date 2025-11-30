package me.kdshim.kdd_j.Baekjoon

class `1926` {
    fun main(){
        val (n, m) = readLine()!!.split(" ").map{ it.toInt() }
        val map = Array(n) { readLine()!!.split(" ").map{it.toInt()}.toIntArray() }
        val visited = Array(n) { BooleanArray(m) { false } }

        val dx = intArrayOf(-1, 1, 0, 0)
        val dy = intArrayOf(0 , 0, -1, 1)

        var paintSizeList = mutableListOf<Int>()
        var paintCount = 0

        fun fn(x: Int, y: Int): Int{
            visited[x][y] = true
            var paintSize = 1
            for(i in 0 until 4){
                val nx = x + dx[i]
                val ny = y + dy[i]

                if(nx in 0 until n && ny in 0 until m && !visited[nx][ny] && map[nx][ny] == 1){
                    paintSize += fn(nx, ny)
                }
            }

            return paintSize
        }

        for(i in 0 until n){
            for(j in 0 until m){
                if(!visited[i][j] && map[i][j] == 1){
                    paintCount++
                    paintSizeList.add(fn(i, j))
                }
            }
        }

        println(paintCount)
        println(paintSizeList.maxOrNull())
    }
}