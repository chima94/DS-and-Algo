import java.util.LinkedList

fun main(){
    val list2 = LinkedList<Int>()
    list2.add(10)
    list2.add(19)
    list2.add(3)
    list2.add(14)
    list2.add(50)

}



fun fib(n: Int): Int{
    if(n <= 2) return 1
    return fib(n - 1) + fib(n - 2)
}