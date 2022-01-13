

fun main(){

    val node1 = DoublyNode(1)
    val node2 = DoublyNode(2)

    node1.next = node2
    node2.prev = node1

    print(node2.toString())
}




data class DoublyNode<T>(var value: T, var next: DoublyNode<T>? = null, var prev: DoublyNode<T>? = null){
    override fun toString(): String {
        return if(next != null || prev != null){
            "$value -> ${next.toString()} \n -> ${prev.toString()}"
        }else{
            "$value"
        }
    }
}
class LinkedListQueue<T>: Queue<T>{


    override fun enqueue(element: T): Boolean {
        TODO("Not yet implemented")
    }

    override fun dequeue(): T? {
        TODO("Not yet implemented")
    }

    override val count: Int
        get() = TODO("Not yet implemented")

    override fun peek(): T? {
        TODO("Not yet implemented")
    }

}