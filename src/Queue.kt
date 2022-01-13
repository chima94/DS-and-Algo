

fun main(){
    val queue = ArrayListQueue<Int>()
    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)
    queue.enqueue(4)
    print(queue.dequeue())
}


interface Queue<T>{
    fun enqueue(element: T): Boolean
    fun dequeue(): T?

    val count: Int
        get

    val isEmpty: Boolean
        get() = count == 0

    fun peek(): T?
}

class ArrayListQueue<T>: Queue<T>{

    private val list = ArrayList<T>()

    override val count: Int
        get() = list.size

    override fun toString(): String = list.toString()

    override fun enqueue(element: T): Boolean {
        list.add(element)
        return true
    }

    override fun dequeue(): T? =
        if(list.isEmpty())  null else list.removeAt(0)



    override fun peek(): T? {
        return list.getOrNull(0)
    }

}