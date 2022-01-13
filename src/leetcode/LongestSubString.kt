package leetcode

fun main(){

}


fun String.longestSubString(): Int{
    val hashSet : HashSet<Char> = HashSet()
    var a_pointer = 0
    var b_pointer = 0
    var max = Integer.MIN_VALUE

    while (a_pointer < this.length){
        if (!hashSet.contains(this[a_pointer])){
            hashSet.add(this[a_pointer])
            max = Math.max(hashSet.count(), max)
            a_pointer++
        }else{
            hashSet.remove(this[b_pointer])
            b_pointer++
        }
    }
    return max
}