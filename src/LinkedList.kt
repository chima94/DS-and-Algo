

fun main(){
//    val list = LinkedList<Int>()
//    list.add(5)
//    list.add(0)
//    list.add(10)
//    list.add(11)
//
//    val other = LinkedList<Int>()
//    other.add(50)
//    other.add(2)
//    other.add(3)
//    other.add(6)
//
//    print(list.mergeSorted(other))
}




data class Node<T>(var value: T, var next: Node<T>? = null){
    override fun toString(): String {
        return if(next != null){
            "$value -> ${next.toString()}"
        }else{
            "$value"
        }
    }
}


//class LinkedListIterator<T> constructor(
//    private var linkedList: LinkedList<T>
//): Iterator<T>, MutableIterator<T>{
//
//    private var index = 0
//    private var lastNode: Node<T>? = null
//
//    override fun hasNext(): Boolean {
//        return index < linkedList.size
//    }
//
//    override fun next(): T {
//        if(index >= linkedList.size) throw IndexOutOfBoundsException()
//
//        lastNode = if(index == 0){
//            linkedList.nodeAt(0)
//        }else{
//            lastNode?.next
//        }
//        index++
//        return lastNode!!.value
//    }
//
//    override fun remove() {
//        if(index == 1){
//            linkedList.pop()
//        }else{
//            val preVNode = linkedList.nodeAt(index - 2) ?: return
//            linkedList.removeAfter(preVNode)
//            lastNode = preVNode
//        }
//        index--
//    }
//
//}
//
//
//
//class LinkedList<T>: Iterable<T>, Collection<T>, MutableIterable<T>, MutableCollection<T>{
//
//    private var head : Node<T>? = null
//    private var tail : Node<T>? = null
//    override var size = 0
//        private set
//
//    override fun isEmpty(): Boolean{
//        return size == 0
//    }
//
//    override fun toString(): String {
//        return if(!isEmpty()){
//            "${head.toString()}"
//        }else{
//            "list is empty"
//        }
//    }
//
//
//    override fun iterator(): MutableIterator<T> {
//        return LinkedListIterator(this)
//    }
//
//
//    fun push(value: T){
//        head = Node(value = value, next = head)
//        if(tail == null){
//            tail = head
//        }
//        size++
//    }
//
//    fun append(value: T){
//        if(isEmpty()){
//            push(value)
//            return
//        }
//        tail!!.next = Node(value = value)
//        tail = tail!!.next
//        size++
//    }
//
//    fun nodeAt(index: Int): Node<T>?{
//        var currentNode = head
//        var currentIndex = 0
//
//        while (currentNode != null && currentIndex < index){
//            currentNode = currentNode.next
//            currentIndex++
//        }
//        return currentNode
//    }
//
//
//    fun insert(value: T, afterNode: Node<T>): Node<T>{
//        val newNode = Node(value = value, next = afterNode.next)
//        afterNode.next = newNode
//        size++
//        return newNode
//    }
//
//    fun pop():T?{
//        if(!isEmpty()){
//            val result = head!!.value
//            head = head!!.next
//            return result
//        }
//        return null
//    }
//
//
//    fun removeAfter(node: Node<T>){
//
//        if (node.next == null){
//            tail = node
//        }
//        if (node.next != null){
//            size --
//        }
//        node.next = node.next?.next
//        println(head)
//    }
//
//
//    fun removeLast(){
//        val head = head
//        if(head!!.next == null)  pop()
//        size --
//        var prev = head
//        var current = head
//        var next = current.next
//
//        while (next != null){
//            prev = current
//            current = next
//            next = current.next
//        }
//        prev!!.next = null
//        tail = prev
//    }
//
//
//    override fun contains(element: T): Boolean {
//        for (item in this){
//            if(item == element) return true
//        }
//        return false
//    }
//
//
//    override fun containsAll(elements: Collection<T>): Boolean {
//        for (searched in elements){
//            if(!contains(searched)) return false
//        }
//        return true
//    }
//
//    override fun add(element: T): Boolean {
//        append(element)
//        return true
//    }
//
//    override fun addAll(elements: Collection<T>): Boolean {
//        for (element in elements){
//            append(element)
//        }
//        return true
//    }
//
//    override fun clear() {
//        head = null
//        tail = null
//        size = 0
//    }
//
//    override fun remove(element: T): Boolean {
//        val iterator = iterator()
//        while (iterator.hasNext()){
//            val item = iterator.next()
//            if(item == element){
//                iterator.remove()
//                return true
//            }
//        }
//        return false
//    }
//
//    override fun removeAll(elements: Collection<T>): Boolean {
//        var result = false
//        for(item in elements){
//            result = remove(item) || result
//        }
//        return result
//    }
//
//    override fun retainAll(elements: Collection<T>): Boolean {
//        var result = false
//        val iterator = this.iterator()
//        while(iterator.hasNext()){
//            val item = iterator.next()
//            if(!elements.contains(item)){
//                iterator.remove()
//                result = true
//            }
//        }
//        return result
//    }
//
//
//}
//
//
//fun <T> LinkedList<T>.printInReverse(){
//    this.nodeAt(0)?.printInReverse()
//}
//
////time complexity O(n)
//fun <T> Node<T>.printInReverse(){
//    this.next?.printInReverse()
//    if(this.next != null){
//        print(" -> ")
//    }
//    print(this.value.toString())
//}
//
//
//
////time complexity O(n)
////runner technique
//fun <T> LinkedList<T>.getMiddleNode(): Node<T>?{
//
//    var slow = this.nodeAt(0)
//    var fast = this.nodeAt(0)
//    while (fast != null){
//        fast = fast.next
//        if(fast != null){
//            fast = fast.next
//            slow = slow?.next
//        }
//    }
//    return slow
//}
//
//
//fun <T> addInReverse(list: LinkedList<T>, node: Node<T>){
//    val next = node.next
//    if(next != null){
//        addInReverse(list, next)
//    }
//    list.append(node.value)
//}
//
//
//fun <T>LinkedList<T>.reverse():LinkedList<T>{
//    val result = LinkedList<T>()
//    val head = this.nodeAt(0)
//    if(head != null){
//        addInReverse(result, head)
//    }
//    return result
//}
//
//
//fun <T: Comparable<T>>append(
//    result: LinkedList<T>,
//    node: Node<T>
//): Node<T>?{
//    result.append(node.value)
//    return node.next
//}
//
//
//fun <T: Comparable<T>>LinkedList<T>.mergeSorted(
//    otherList: LinkedList<T>
//):LinkedList<T>{
//    if(this.isEmpty()) return otherList
//    if(otherList.isEmpty()) return this
//
//    val result = LinkedList<T>()
//    var left = nodeAt(0)
//    var right = otherList.nodeAt(0)
//
//    while (left != null && right != null){
//        if(left.value < right.value){
//            left = append(result, left)
//        }else{
//            right = append(result, right)
//        }
//    }
//
//    while (left != null){
//        left = append(result, left)
//    }
//    while (right != null){
//        right = append(result, right)
//    }
//    return result
//}
//
//fun <T : Comparable<T>>LinkedList<T>.sort():LinkedList<T>?{
//    if(this.isEmpty()) return null
//    val node = nodeAt(0)
//    println(node?.next)
//    return null
//}