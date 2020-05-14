package com.krupet.misc

fun main(args: Array<String>) {

    // println(isPalindrom("abcdcba"))
    //println(isPalindrom(""))

    //println(isPalindrom("abccba"))

    val input = Node(1, Node(2, Node(3, Node(4, Node(5, null)))))
    val expectedOutput = Node(1, Node(2, Node(3, Node(5, null))))
    print(removeAt(input, 2))
}

// remove at index starting from the end (how to do this in one iteration)
// n = 2
// 1 -> 2 -> 3 -> 4 -> 5
// 1 -> 2 -> 3 -> 5
data class Node(val value: Int, val next: Node?)


fun removeAt(head: Node, index: Int): Node {

    val values = mutableListOf<Int>()
    var node : Node? = head
    while(node?.next != null) {
        values.add(node.value)
        node = node.next
    }
    values.add(node?.value!!)

    if (index > values.size) return head

    //           |
    // [1, 2, 3, 4, 5]
    val takeUntilIndex = values.size - index

    val resultList = values.take(takeUntilIndex -1) + values.drop(takeUntilIndex)

    // [1, 2, 3, 5]
    var tail = Node(resultList[resultList.size - 1], null)
    for (j in resultList.size - 2 downTo 0) {
        tail = Node(resultList[j], tail)
    }

    // head of a new list
    return tail
}

fun isPalindrom(input: String): Boolean {

    if (input.isEmpty()) return true

    val endIndex = input.length - 1
    for (i in 0 .. (input.length / 2)) {
        if (input[i] != input[endIndex - i]) return false
    }

    return true
}

/// "abcdcba"