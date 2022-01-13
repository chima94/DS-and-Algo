

fun main(){
    val list = DoubleStackQueue<String>()
    list.enqueue("brian")
    list.enqueue("ray")
    list.enqueue("Eric")
    println(".......Before reversing.....")
    println(list.dequeue())
    println(list.dequeue())
    println(list.dequeue())
    list.enqueue("brian")
    list.enqueue("ray")
    list.enqueue("Eric")
    println(".......After reversing.....")
    list.reverse()
    println(list.dequeue())
    println(list.dequeue())
    println(list.dequeue())
}


class DoubleStackQueue<T>: Queue<T>{
    private val leftStack = Stack<T>()
    private val rightStack = Stack<T>()

    override val isEmpty: Boolean
        get() = leftStack.isEmpty() && rightStack.isEmpty()



    override fun enqueue(element: T): Boolean {
        rightStack.push(element)
        return true
    }

    override fun dequeue(): T? {
        if(leftStack.isEmpty()){
            transferElements()
        }
        return leftStack.pop()
    }

    override val count: Int
        get() = rightStack.count

    override fun peek(): T? {
        if(leftStack.isEmpty()){
            transferElements()
        }
        return leftStack.peek()
    }


    private fun transferElements(){
        var nextElement = rightStack.pop()
        while (nextElement != null){
            leftStack.push(nextElement)
            nextElement = rightStack.pop()
        }
    }
}

fun <T>DoubleStackQueue<T>.nextPlayer(): T?{
    val player = dequeue() ?: return null
    this.enqueue(player)
    return player
}



fun <T>DoubleStackQueue<T>.reverse(){

    val aux = Stack<T>()
    var next = dequeue()
    while (next != null){
        aux.push(next)
        next = dequeue()
    }

    next = aux.pop()
    while (next != null){
        enqueue(next)
        next = aux.pop()
    }
}