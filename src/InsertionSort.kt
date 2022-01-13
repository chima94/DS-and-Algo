import java.util.LinkedList

fun main(){
    val items = mutableListOf(2, 1, 8, 4, 5, 10)
    val result = insertionSort(items)
    print(result)
    val list = LinkedList<Int>()
    list.add(5)
}


fun insertionSort(item: MutableList<Int>): List<Int>{
    for (i in 1 until  item.size){
        val current = item[i]
        var j = i - 1
        while (j >= 0 && item[j] > current){
            item[j + 1] = item[j]
            item[j] = current
            j -= 1
        }
    }
    return item
}