package com.krupet.hackerrank

fun repeatedString(s: String, n: Long): Long {

    if (s =="a") return n

    fun countA(str: String): Long = str.toCharArray().count { it == 'a' }.toLong()

    val numberOfFullStrings = n / s.length
    val substringLastIndex = n % s.length

    return countA(s) * numberOfFullStrings + countA(s.substring(0, substringLastIndex.toInt()))

}

fun sockMerchant(n: Int, ar: Array<Int>): Int =
    ar.take(n)
        .groupBy { it }
        .map { (_, v) -> v.size / 2 }.sum()


// println(countingValleys(8, "UDDDUDUU"))
fun countingValleys(n: Int, s: String): Int {

    var altitude = 0
    var valleys = 0

    for (i in 0 until n) {
        if (s[i] == 'D') {
            altitude--
            if (altitude == -1) valleys++
        }
        if (s[i] == 'U') altitude++
    }

    return valleys
}

// jumpingOnClouds(arrayOf(0, 0, 1, 0, 0, 1, 0)) == 4
// jumpingOnClouds(arrayOf(0, 0, 0, 0, 1, 0))    == 3
fun jumpingOnClouds(c: Array<Int>): Int {

    var jumps = 0
    var i = 0

    while (i == c.size - 2 || i < c.size - 1) {
        if (c[i + 2] == 1) {
            jumps++
            i++
        } else {
            jumps++
            i+=2
        }
    }
    return jumps
}

fun main() {
    println(jumpingOnClouds(arrayOf(0, 0, 1, 0, 0, 1, 0)) == 4)
    println(jumpingOnClouds(arrayOf(0, 0, 0, 0, 1, 0))    == 3)
}
