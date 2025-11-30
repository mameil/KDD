package me.kdshim.kdd_j.Baekjoon

import java.util.LinkedList
import java.util.Queue
import java.util.Stack

class `9012` {
    fun main(){
        val count = readLine()!!.toInt()
        val input = MutableList(count) { readLine()!! }
        for(i in input){
            println(check(i))
        }
    }

    fun check(input: String): String {
        val stack = mutableListOf<String>()

        for(i in input){
            when(i){
                '(' -> stack.add(input)
                ')' -> {
                   if(stack.isEmpty()) {
                       return "NO"
                   }else{
                       stack.removeAt(stack.lastIndex)
                   }
                }
            }
        }

        if(stack.isEmpty()){
            return "YES"
        } else {
            return "NO"
        }
    }
}