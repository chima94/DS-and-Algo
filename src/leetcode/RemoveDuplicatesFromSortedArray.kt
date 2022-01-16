package leetcode

fun main(){
    val nums = arrayOf(1, 1, 2, 3, 4, 4)
    removeDuplicates(nums)
}

fun removeDuplicates(nums: Array<Int>){

    var j = 0
    for(i in 0 until nums.size - 1){
        if(nums[i] != nums[i + 1]){
            nums[j] = nums[i]
            j += 1
        }
    }
    nums[j] = nums[nums.size - 1]
    j += 1
    for(i in 0 until j){
        println(nums[i])
    }
}