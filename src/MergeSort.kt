

fun main(){
    val items = mutableListOf(38,27,43,3,9,82,10)
    val list = mergeSort(items)
    print(list)
}


private fun mergeSort(items: List<Int>): List<Int>{
    if(items.size <= 1){
        return items
    }
    val middle = items.size / 2
    val left = items.subList(0, middle)
    val right = items.subList(middle, items.size)
    return merge(mergeSort(left), mergeSort(right))
}

private fun merge(left: List<Int>, right: List<Int>): List<Int>{
    var leftIndex = 0
    var rightIndex = 0
    var newList : MutableList<Int> = mutableListOf()

    while (leftIndex < left.count() && rightIndex < right.count()){
        if(left[leftIndex] <= right[rightIndex]){
            newList.add(left[leftIndex])
            leftIndex += 1
        }else{
            newList.add(right[rightIndex])
            rightIndex += 1
        }
    }

    while (leftIndex < left.size){
        newList.add(left[leftIndex])
        leftIndex += 1
    }

    while (rightIndex < right.size){
        newList.add(right[rightIndex])
        rightIndex += 1
    }
    return newList
}