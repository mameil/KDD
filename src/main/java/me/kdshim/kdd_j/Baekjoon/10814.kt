package me.kdshim.kdd_j.Baekjoon

class `10814` {

    data class Person(val age: Int, val name: String, val createdIndex: Int)

    fun main(){
        val n = readLine()!!.toInt()
        val personList = mutableListOf<Person>()

        for(i in 1..n){
            val (a, n) = readLine()!!.split(" ")
            personList.add(Person(a.toInt(), n, i))
        }

        personList.sortBy { it.age }
        personList.sortWith(compareBy({ it.age }, { it.createdIndex }))
        personList.forEach { println("${it.age} ${it.name}") }
    }
}