

fun main(){
    val word = "chima is good"
    val r = mergeSort(word.split("\\s".toRegex()))
    print(r)
}

fun reverse(word: CharArray){
    val newList = mutableListOf<Char>()
    val l = word.size
    for (i in l - 1 downTo 0){
        newList.add(word[i])
    }
    println(newList.joinToString(""))
}

fun reverseWord(word: List<String>){
    val newItem = mutableListOf<String>()
    for(i in word.size - 1 downTo 0){
        newItem.add(word[i])
    }
    println(newItem.joinToString(" "))
}

private fun mergeSort(items: List<String>): List<String>{
    if(items.size <= 1){
        return items
    }
    val middle = items.size / 2
    val left = items.subList(0, middle)
    val right = items.subList(middle, items.size)
    return merge(mergeSort(left), mergeSort(right))
}

private fun merge(left: List<String>, right: List<String>): List<String>{
    var leftIndex = 0
    var rightIndex = 0
    var newList : MutableList<String> = mutableListOf()

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


