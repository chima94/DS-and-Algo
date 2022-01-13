

fun main(){
    val list = arrayListOf(1, 2, 3, 3, 3, 4, 5, 5)
    print(list.findIndices(3))

}


fun <T: Comparable<T>>ArrayList<T>.binarySearcher(
    value: T,
    range: IntRange = indices
): Int?{


    if(range.first > range.last){
        return null
    }
    val size = range.last - range.first + 1
    val middle = range.first + size / 2
    return when{
        this[middle] == value -> middle
        this[middle] > value -> binarySearcher(value, range.first until middle)
        else -> binarySearcher(value, (middle + 1)..range.last)
    }
}

fun <T: Comparable<T>>ArrayList<T>.findIndices(
    value: T,
): IntRange?{

    val startIndex = startIndexi(value, 0..size) ?: return null
    val endIndex = endIndexi(value, 0..size) ?: return null
    return startIndex..endIndex
}


fun <T: Comparable<T>>ArrayList<T>.startIndexi(
    value: T,
    range: IntRange
): Int?{

    val middleIndex = range.first + (range.last / 2) + 1

    if (middleIndex == 0 || middleIndex == size - 1) {
        return if (this[middleIndex] == value) {
            middleIndex
        } else {
            null
        }
    }

    return when{
        this[middleIndex] == value ->{
            if(this[middleIndex - 1] != value){
                middleIndex
            }else{
                startIndexi(value, range.start until middleIndex)
            }
        }
        this[middleIndex] > value -> startIndexi(value, range.first until middleIndex)
        else -> startIndexi(value, (middleIndex + 1)..range.last)
    }
}



private fun <T : Comparable<T>> ArrayList<T>.endIndexi(
    value: T,
    range: IntRange
): Int? {

    val middleIndex = range.first + (range.last / 2)

    if (middleIndex == 0 || middleIndex == size - 1) {
        return if (this[middleIndex] == value) {
            middleIndex
        } else {
            null
        }
    }

    return when{
        this[middleIndex] == value ->{
            if(this[middleIndex + 1] != value){
                middleIndex
            }else{
                startIndexi(value, range.start until middleIndex)
            }
        }
        this[middleIndex] > value -> startIndexi(value, range.first until middleIndex)
        else -> startIndexi(value, (middleIndex + 1)..range.last)
    }

}