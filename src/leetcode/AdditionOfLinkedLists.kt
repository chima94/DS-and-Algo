package leetcode

import Node


fun main(){

}


fun additionOfLinkedLists(node1: Node<Int>?, node2: Node<Int>?):Node<Int>?{
    var ptr1 = node1
    var ptr2 = node2

    var sum = 0
    var carry = 0
    var result: Node<Int>? = null

    while (ptr1 != null || ptr2 != null){
        sum = 0
        ptr1?.let { sum += it.value }
        ptr2?.let { sum += it.value }
        sum += carry
        carry = sum / 10
        sum %= 10
        result = Node(value = sum, next = result)
        ptr1 = ptr1?.next
        ptr2 = ptr2?.next
    }
    if(carry > 0){
        result = Node(value = carry, next = result)
    }
    return result
}