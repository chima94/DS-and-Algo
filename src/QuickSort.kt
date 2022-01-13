
var i = 1

fun main(){
    val numbers = listOf(52, 37, 63, 14, 17, 8, 6, 25)

    val items = quickSort(numbers)

    print(items)

}



fun quickSort(items: List<Int>): List<Int>{
    if(items.count() < 2){
        return items
    }
    val pivot = items[items.count() / 2]
    val equal = items.filter { it == pivot }
    val less = items.filter { it < pivot }
    val greater = items.filter { it > pivot }
    return quickSort(greater) + equal + quickSort(less)
}