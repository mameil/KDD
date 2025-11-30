package me.kdshim.kdd_j.Baekjoon

class `11659` {
    fun main(){
        val (n, m) = readLine()!!.split(" ").map{ it.toInt() }
        val arr = readLine()!!.split(" ").map{ it.toInt() }

        val prefix = IntArray(n+1){ 0 }
        for(i in 1..n) {
            prefix[i] = prefix[i-1] + arr[i-1]
        }

        repeat(m) {
            val (start, end) = readLine()!!.split(" ").map{ it.toInt() }
            println(prefix[end] - prefix[start-1])
        }
    }
}