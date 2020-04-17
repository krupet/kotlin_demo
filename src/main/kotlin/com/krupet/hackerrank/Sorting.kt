package com.krupet.hackerrank

//Array is sorted in 3 swaps.
//First Element: 1
//Last Element: 3
fun countSwaps(a: Array<Int>): Unit {

    var count = 0

    fun swap(i: Int, j: Int): Unit {
        val temp = a[j]
        a[j] = a[i]
        a[i] = temp

        count++
    }

    for (i in 0 until a.size){
        for (j in 0 until a.size -1) {
            if (a[j] > a[j + 1]) swap(j, j + 1)
        }
    }

    println("Array is sorted in $count swaps.")
    println("First Element: ${a[0]}")
    println("Last Element: ${a[a.size - 1]}")

}

fun maximumToys(prices: Array<Int>, k: Int): Int {

    val sorted = prices.sortedArray()
    var acc = 0
    var number = 0
    for (i in 0 until sorted.size) {
        acc += sorted[i]
        if (acc >= k) break
        number++
    }

    return number
}

fun activityNotifications(expenditure: Array<Int>, d: Int): Int {

    var sum = expenditure.take(d).sum()
    var count = 0.0
    val medianDelimiter = d.toDouble()
    for (i in d until expenditure.size) {
        if ((2 * (sum / medianDelimiter)) <= expenditure[i]) count++
        sum -= expenditure[i - d]
        sum += expenditure[i]
    }

    return count.toInt()
}

fun main() {
    println(activityNotifications(arrayOf(1, 2, 3, 4, 4), 4))
}
