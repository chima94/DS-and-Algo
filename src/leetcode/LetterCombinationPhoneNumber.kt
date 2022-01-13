package leetcode

fun main(){
    letterCombinationPhoneNumber("23")
}


fun letterCombinationPhoneNumber(digits: String){
    val hashMap = hashMapOf<Char, String>()
    hashMap['2'] = "abc"
    hashMap['3'] = "def"
    hashMap['4'] = "ghi"
    hashMap['5'] = "jkl"
    hashMap['6'] = "mno"
    hashMap['7'] = "qprs"
    hashMap['8'] = "tuv"
    hashMap['9'] = "wxyz"

    val result = mutableListOf<String>()
    backTracking(digits, 0, result, hashMap, "")
    println(result)

}


fun backTracking(
    digits: String,
    index: Int,
    result: MutableList<String>,
    hashMap: HashMap<Char, String>,
    currentString: String
){
    if(currentString.length == digits.length){
        result.add(currentString)
        return
    }

    val str = hashMap[digits[index]]
    for(c in str!!){
        backTracking(digits, index + 1  , result, hashMap, currentString+c)
    }
}