package com.krupet.hackerrank

// sort in a such way that even numbers belong to uneven indexes and vise versa
// input - 1, 2, 3, 4, 5
// output- 2, 1, 4, 3, 5
fun transformArr(input: List<Int>): List<Int> {

    fun switch(a: Int, b: Int): List<Int> = when {
        a % 2 == 0 -> listOf(a, b)
        else -> listOf(b, a)
    }

    fun reorder(i: List<Int>): List<Int> {
        val (f, s, tail) = i

        return when {
            f != null && s == null && tail.isEmpty() -> listOf(f)
            f != null && s != null && tail.isEmpty() -> switch(f, s)
            f != null && s != null && tail.isNotEmpty() -> switch(f, s) + reorder(tail)
            else -> throw RuntimeException("Ooops!")
        }
    }

    return reorder(input)
}

operator fun <T> List<T>.component1(): T? = if (this.isNotEmpty()) this.first() else null
operator fun <T> List<T>.component2(): T? = if (this.size > 1) this.drop(1).first() else null
operator fun <T> List<T>.component3(): List<T> = if (this.size > 2) this.drop(2).toList() else emptyList()


fun main() {
    transformArr(listOf(1, 2, 3, 4, 5)).forEach(::println)
}
