package leetcode

import Node

fun main(){

    val nodeList1 = Node(1)
    val nodeList2 = Node(4)
    val nodeList3 = Node(5)

    nodeList1.next = nodeList2
    nodeList2.next = nodeList3

    val node2List1 = Node(1)
    val node2List2 = Node(3)
    val node2List3 = Node(4)

    node2List1.next = node2List2
    node2List2.next = node2List3

    val node3List1 = Node(2)
    val node3List2 = Node(6)

    node3List1.next = node3List2

    val arr = arrayOf(nodeList1, node2List1, node3List1)
    mergeKSortedList(arr)
}

fun mergeKSortedList(list : Array<Node<Int>>){
    var listNode: Node<Int>? = null
    val  arr = arrayListOf<Int>()

    list.forEach {
        node(it, arr)
    }
    val heap = ComparableHeapImpl.create(arr)

    while (!heap.isEmpty){
        listNode = Node(heap.remove()!!, listNode)
    }
    println(listNode)
}

fun node(node: Node<Int>, arr: MutableList<Int>){
    var n : Node<Int>? = node
    while (n != null){
        arr.add(n.value)
        n = n.next
    }
}