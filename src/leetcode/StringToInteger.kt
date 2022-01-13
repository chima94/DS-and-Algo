package leetcode

fun main(){
    println(stringToInteger("4193"))
}

fun stringToInteger(s: String): Int{

    var i = 0
    var negative = 1
    var res = 0
    while (i < s.length){
        if(s[i] == ' '){
            i++
        }
        break
    }
    if(i < s.length && s[i] == '-'){
        negative = -1
        i++
    }
    if(i < s.length && s[i] == '+'){
        i++
    }
    val hashset = hashSetOf('0','1','2','3','4','5','6','7','8','9')
    while (i < s.length && hashset.contains(s[i])){
        if(res > Int.MAX_VALUE / 10 && (res == Int.MAX_VALUE /10 && s[i].code > 7)){
            return Int.MAX_VALUE
        }
        res = res * 10 + s[i].digitToInt()
        i++


    }
    return res * negative
}