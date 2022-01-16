package leetcode

import Node

fun main(){
    val node1 = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)
    val node4 = Node(4)
    val node5 = Node(5)

    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5

    reverseKGroup(node1, 3)
}


fun reverseKGroup(node: Node<Int>, k: Int){
    val dummy = Node(0, node)
    var groupPrev = dummy

    while (true){
        val kth: Node<Int> = getKthNode(groupPrev, k) ?: break
        val groupNext = kth.next
        var prev = kth.next
        var curr = groupPrev.next

        while (curr != groupNext){
            val temp = curr?.next
            curr?.next = prev
            prev = curr
            curr = temp
        }
        val temp = groupPrev.next
        groupPrev.next = kth
        groupPrev = temp!!
    }
    println(dummy.next)
}

fun getKthNode(node: Node<Int>, k: Int): Node<Int>?{
    var curr: Node<Int>? = node
    var kth = k
    while (curr != null  && kth > 0){
        curr = curr.next
        kth -= 1
    }
    return curr
}