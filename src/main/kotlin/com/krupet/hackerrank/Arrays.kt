package com.krupet.hackerrank

import java.util.*

fun minimumBribes(q: Array<Int>): Unit {
    var bribes = 0
    val size = q.size
    for (i in 0 until size) {
        if (q[i] - i > 3) {
            println("Too chaotic")
            return
        } else {
            for (j in 0 .. i) {
                if (q[j] > q[i]) bribes++
            }
        }
    }

    println(bribes)
}



fun hourglassSum(arr: Array<Array<Int>>): Int {

    val sums: MutableList<Int> = mutableListOf()
    for (i in 0..3)
        for (j in 0..3)
            sums.add(
                arr[i][j] + arr[i][j + 1] + arr[i][j + 2]
                        + arr[i + 1][j + 1]
                        + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2]
            )

    return sums.max() ?: 0
}


fun rotLeft(a: Array<Int>, d: Int): Array<Int> {
    if (d == 0 || d == a.size) return a
    return a.copyOfRange(d, a.size) + a.copyOfRange(0, d)
}

fun minimumSwaps(arr: Array<Int>): Int {

    val visited = BooleanArray(arr.size)
    val cache = mutableMapOf<Int, Int>()
    for (i in 0 until arr.size)
        cache[i] = arr[i]

    var hopCount: Int = 0

    for (j in 0 until arr.size) {
        if (visited[j] == false) {
            visited[j] = true

            if (j == cache[j]!! + 1) {
                continue
            } else {
                var current = cache[j]!! - 1
                var next: Int
                while (visited[current] == false) {
                    visited[current] = true
                    next = cache[current]!! - 1
                    current = next
                    hopCount++
                }
            }
        }
    }

    return hopCount
}

// not all passed
fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {

    val arr = IntArray(n)

    for (i in 0 until queries.size) {
        val commands = queries[i]
        val toIndex = commands[1]
        val fromInd = commands[0] - 1
        if (toIndex == fromInd) continue
        arr[fromInd] += commands[2]
        if (toIndex == arr.size) continue
        arr[toIndex] += - commands[2]
    }

    for (j in 1 until arr.size) {
        arr[j] = arr[j -1] + arr[j]
    }

    return arr.max()!!.toLong()
}


fun freqQuery(queries: Array<Array<Int>>): Array<Int> {

    val countMap = mutableMapOf<Int, Int>()
    val freqMap = mutableMapOf<Int, Int>()
    val result: MutableList<Int> = LinkedList()

    for (query in queries) {
        val value = query[1]
        when (query[0]) {
            1 -> {
                val count = countMap[value] ?: 0
                countMap[value] = count + 1

                freqMap[count] = (freqMap[count] ?: 0) - 1
                freqMap[count + 1] = (freqMap[count + 1] ?: 0) + 1
            }
            2 -> {
                val count = countMap[value] ?: 0
                if (count > 0) {
                    countMap[value] = if (count == 0) count else count - 1

                    freqMap[count] = (freqMap[count] ?: 0) - 1
                    freqMap[count - 1] = (freqMap[count - 1] ?: 0) + 1
                }
            }
            3 -> if ((freqMap[value] ?: 0) > 0 ) result.add(1) else result.add(0)
        }
    }

    return result.toTypedArray()
}


fun main() {
    freqQuery(arrayOf(
        arrayOf(1, 5),
        arrayOf(1, 6),
        arrayOf(3, 2),
        arrayOf(1, 10),
        arrayOf(1, 10),
        arrayOf(1, 6),
        arrayOf(2, 5),
        arrayOf(3, 2)
    )).forEach { println(it) }
}
