package leetcode

import Node

fun main(){

    val node1 = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)
    val node4 = Node(4)
    val node5 = Node(5)
    val node6 = Node(6)

    node1.next = node2
    node2.next = node3
    node3.next = node4


    swapNodes(node1)
}


fun swapNodes(node: Node<Int>){

    var head: Node<Int>? = node
    val dummy = Node(0, head)
    var prev = dummy

    while (head?.next != null){
        val nextpair = head.next?.next
        val second = head.next

        second?.next = head
        head.next = nextpair
        prev.next = second

        prev = head
        head = nextpair
    }

    println(dummy.next)


}