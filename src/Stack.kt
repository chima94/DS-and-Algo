import javax.swing.text.Element

fun main(){
//    val list = LinkedList<Int>()
//    list.append(1)
//    list.append(2)
//    list.append(3)
//    list.append(4)
//    list.append(5)
//
//    list.printInReverseOrder()
//    val word = "hello(w)or(ld)"
//    println(word.checkperentesis())
}


//fun <T> LinkedList<T>.printInReverseOrder(){
//    val stack = Stack<T>()
//
//    for(node in this){
//        stack.push(node)
//    }
//    var data = stack.pop()
//    while (data != null){
//        println(data)
//        data = stack.pop()
//    }
//}

//The time complexity of this algorithm is O(n), where n is the number of characters in
//the string. This algorithm also incurs an O(n) space complexity cost due to the usage
//of the Stack data structure
fun String.checkperentesis(): Boolean{
    val stack = Stack<Char>()
    for (character in this){
       when (character){
           '(' -> stack.push(character)
           ')' -> if(stack.isEmpty()){
               return false
           }else{
               stack.pop()
           }
       }
    }
    return stack.isEmpty()
}


class Stack <T>{
    private val storage = arrayListOf<T>()
    val count: Int
        get() = storage.size

    override fun toString() = buildString {
        appendln("....top....")
        storage.asReversed().forEach {
            appendln("$it")
        }
        appendln("..........")
    }

    fun isEmpty() = count == 0


    fun peek(): T?{
        return storage.lastOrNull()
    }

    fun push(element: T){
        storage.add(element = element)
    }

    fun pop(): T?{
        if(storage.size == 0){
            return null
        }
        return storage.removeAt(storage.size - 1)
    }

    companion object{
        fun <T> createStack(elements: Iterable<T>):Stack<T>{
            val stack = Stack<T>()
            for (element in elements){
                stack.push(element)
            }
            return stack
        }
    }

}

fun <T> stackOf(vararg elements: T): Stack<T>{
    return Stack.createStack(elements.toList())
}