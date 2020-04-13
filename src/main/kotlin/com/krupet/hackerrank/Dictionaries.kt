package com.krupet.hackerrank

fun checkMagazine(magazine: Array<String>, note: Array<String>): Unit {

    val noteCount = note.groupingBy { it }.eachCount()
    val magazineCount = magazine.groupingBy { it }.eachCount()

    if (noteCount.any { magazineCount[it.key] ?: 0 < it.value }) {
        println("No")
    } else {
        println("Yes")
    }
}

fun twoStrings(s1: String, s2: String): String {

    val first = s1.toCharArray().distinct()
    return if (s2.toCharArray().any { first.contains(it) }) {
        "YES"
    } else {
        "NO"
    }

}

// not solved sherlockAndAnagrams("cdcd") != 5
fun sherlockAndAnagrams(s: String): Int {
    if (s.toCharArray().distinct().size == 1) return s.length * (s.length + 1) / 2
    if (s.toCharArray().withIndex().none { s.indexOf(it.value) != it.index }) return 0

    val substrings = mutableListOf<String>()
    for (i in 0..s.length) {
        for (j in i + 1..s.length) {
            substrings.add(s.substring(i, j))
        }
    }

    val map = substrings.groupingBy { it.toCharArray().sorted().joinToString(separator = "") }.eachCount()
    return map
        .filter { it.value >= 2 }
        .map { it.value / 2 }
        .sum()
}

// LONG MATTERS!!!! Counts should be long!
fun countTriplets(arr: Array<Long>, r: Long): Long {

    val right: MutableMap<Long, Long> = arr.groupingBy { it }.eachCount().mapValues { it.value.toLong()}.toMutableMap()
    val left: MutableMap<Long, Long> = mutableMapOf()

    var count = 0L

    for (i in 0 until arr.size) {
        var c1 = 0L
        var c3 = 0L

        val mid = arr[i]

        right[mid] = right.getOrDefault(mid, 0L) - 1L

        if (left.containsKey(mid / r) && mid % r == 0L) {
            c1 = left.getOrDefault(mid / r, 0L)
        }

        if (right.containsKey(mid * r)) {
            c3 = right.getOrDefault(mid * r, 0L)
        }

        count += c1 * c3

        left[mid] = left.getOrDefault(mid, 0L) + 1L
    }


    return count
}


fun main() {
//    println(sherlockAndAnagrams("abc"))
//    println(sherlockAndAnagrams("mom"))
    println(sherlockAndAnagrams("cdcd"))
}
