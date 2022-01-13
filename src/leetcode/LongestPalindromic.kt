package leetcode

fun main(){
    val word = "babad"
    println(word.longestPalindromic())
}



//longest palindrome in a string
fun String.longestPalindromic(): String{

    if (this.isEmpty()) return ""
    var start = 0
    var end = 0
    for(i in 0 until this.length){
        val len1 = expandFromMiddle(this, i, i)
        val len2 = expandFromMiddle(this, i, i + 1)
        val len = len1.coerceAtLeast(len2)
        if(len > end - start){
            start = i - ((len - 1) / 2)
            end = i + (len / 2)
        }
    }
    return this.substring(start, end + 1)
}

//helper function of the palindrome
fun expandFromMiddle(s: String, left: Int, right: Int):Int{
    if(s == null || left > right) return 0
    var left1 = left
    var right1 = right
    while (left1 >= 0 && right1 < s.length && s[left1] == s[right1]){
        left1--
        right1++
    }
    return right1 - left1 - 1
}