

fun main(){

   val numbers = listOf(1, 3, 4, 5, 7)
   val result = slideWindowAlgorithm(3, numbers)
   //println(result)


}


//Grid traveller
//dynamic programming using memoization
fun gridTraveller(m: Int, n: Int, map: HashMap<String, Int> = hashMapOf()): Int{
   val key = "$n,$m"
   if(map.containsKey(key)) return map[key]!!
   if(m == 1 || n == 1) return 1
   if (m == 0 || n == 0) return 0
   map[key] = gridTraveller(m - 1, n, map) + gridTraveller(m, n - 1, map)
   return map[key]!!
}

//can sum problem
fun canSum(targetSum: Int, lists: List<Int>, map: HashMap<String, Boolean> = hashMapOf()): Boolean{
   if(map.containsKey(targetSum.toString())) return map[targetSum.toString()]!!
   if(targetSum == 0) return true
   if(targetSum < 0) return false

   for(num in lists){
      val remainder = targetSum - num
      if(canSum(remainder, lists, map)){
         map[targetSum.toString()] = true
         return true
      }
   }
   map[targetSum.toString()] = false
   return false
}


fun divisiby_60(numbers: List<Int>): Int{
   var count = 0

   for (i in numbers.indices){
      for (j in 1 until numbers.size){
         if (j + i < numbers.size){
            val add = numbers[i] + numbers[j + i]
            if((add % 60) == 0) count += 1
         }
      }
   }
   return count
}





//[1, 3, 4, 5, 7]
fun slideWindowAlgorithm(window: Int, lists: List<Int>): Int{

   var slide = 3
   var max = Integer.MIN_VALUE
   var currentRunningWindow = 0
   for(i in lists.indices){
      currentRunningWindow += lists[i]
      if(i >= slide - 1){
         max = currentRunningWindow.coerceAtLeast(max)
         currentRunningWindow -= lists[i - (slide - 1)]
      }
   }
   return max
}




