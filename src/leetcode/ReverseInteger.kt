package leetcode

fun main(){
    println(reverseInteger(123))
}


fun reverseInteger(number: Int): Int{
    if(number == 1 || number == 0){
        return number
    }
    var res = 0
    var x = number
    while (x != 0){
        val pop = x % 10
        x /= 10
        if(res > Int.MAX_VALUE/10 || (res == Int.MAX_VALUE/10 && pop > 7)){
            return 0
        }
        if(res < Int.MIN_VALUE/10 || (res == Int.MIN_VALUE/10 && pop < -8)){
            return 0
        }
        res = res * 10 + pop
    }
    return res
}