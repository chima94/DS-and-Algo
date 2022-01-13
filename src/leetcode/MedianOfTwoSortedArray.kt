package leetcode

fun main(){
    val number1 = listOf(1,2)
    val number2 = listOf(3, 4)
    println(medianOfTwoSortedArray(number1, number2))

}



//alogrithm:
//
//    partitionX  + partitionY = (x + y + 1) / 2
//found
//    maxLeftX <= minRightY
//    maxLeftY <= MinRightX
//else if
//    maxLeftX > minRightY
//    move towards left x
//else
//    move towards right in X

fun medianOfTwoSortedArray(number1: List<Int>, number2: List<Int>):Double{
    val n = number1.size
    val m = number2.size

    if(n > m) return medianOfTwoSortedArray(number2, number1)

    var start = 0
    var end = n
    val realMidInMergedArray = (n + m + 1) / 2

    while (start <= end){

        val mid = (start + end) / 2
        val leftBSize = realMidInMergedArray - mid

        val leftA = if (mid > 0) number1[mid - 1] else Int.MIN_VALUE
        val leftB = if(leftBSize > 0) number2[leftBSize - 1] else Int.MIN_VALUE
        val rightA = if (mid < n) number1[mid] else Int.MAX_VALUE
        val rightB = if(leftBSize < m) number2[leftBSize] else Int.MAX_VALUE

        if(leftA <= rightB && leftB <= rightA){
            if((m + n) % 2 == 0)
                return (leftA.coerceAtLeast(leftB) + rightA.coerceAtMost(rightB)) / 2.0
            return leftA.coerceAtLeast(leftB).toDouble()
        }
        else if(leftA > rightB){
            end = mid - 1
        }
        else{
            start = mid + 1
        }
    }

    return 0.0
}