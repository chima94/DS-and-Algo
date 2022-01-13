package leetcode

fun main(){
    val arr = arrayOf(-2, -1, 0, 0, 1, 2)
    fourSum(arr, target = 0)
}


fun fourSum(numbers: Array<Int>, target: Int){
   val res = mutableListOf<List<Int>>()

    for (i in 0 until numbers.size - 3){
        if(i != 0 && numbers[i] != numbers[i - 1]){
            continue
        }
        for(j in i + 1 until numbers.size - 2){
            if(j != i + 1 && numbers[j] == numbers[j - 1]){
                continue
            }
            println(j)
            var left = j + 1
            var right = numbers.size - 1

            while (left < right){
                val sum = numbers[i] + numbers[j] + numbers[left] + numbers[right]
                if(sum < target){
                    left++
                }
                else if(sum > target){
                    right --
                }
                else{
                    val arr = mutableListOf(numbers[i], numbers[j], numbers[left], numbers[right])
                    res.add(arr)
                    right--
                    left++

                    while (left < right && numbers[left] == numbers[left + 1])left++
                    while (left < right && numbers[right] == numbers[right + 1]) right--
                }
            }
        }
    }

    //println(res)

}