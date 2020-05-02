package com.krupet.misc

// 0 1 2 3 4 5 6 7  8
// 0 1 1 2 3 5 8 13 21
fun fibbRec(index: Int): Int = fibb(index)

fun fibb(index: Int): Int {
    if (index == 0) return 0
    if (index == 1) return 1

    return fibb(index - 2) + fibb(index - 1)
}

val cache: MutableMap<Int, Int> = mutableMapOf(0 to 0, 1 to 1)
fun fibbMem(index: Int): Int {
    if (cache.containsKey(index)) cache[index]
    return cache.computeIfAbsent(index) { fibb(index - 2) + fibb(index - 1) }
}

fun fibbTab(index: Int): Int {
    val arr = Array(index + 1) { 0 }
    arr[0] = 0
    arr[1] = 1

    for (i in 2..index) {
        arr[i] = arr[i - 2] + arr[i - 1]
    }

    return arr.last()
}

fun main() {
    // 2^n
    println(fibb(7))
    // n
    println(fibbTab(7))
    // n
    println(fibbMem(7))
}
