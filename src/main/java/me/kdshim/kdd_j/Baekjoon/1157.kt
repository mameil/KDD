package me.kdshim.kdd_j.Baekjoon

class `1157` {
    fun main(){
        val input = readLine()!!.lowercase()

        val counts = MutableList(26) { 0 }

        for (ch in input){
            val index = ch - 'A'
            counts[index] = counts[index] + 1
        }

        val max = counts.maxOrNull()!!
        val maxCount = counts.count { it == max }

        if(maxCount > 1){
            println("?")
        } else {
            println('A' + counts.indexOf(max))
        }
    }

}