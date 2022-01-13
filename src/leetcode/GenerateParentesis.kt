package leetcode

fun main(){
    println(generateParentesis())
}



fun generateParentesis():MutableList<String>{
    val list = mutableListOf<String>()
    backtracking(list, "", 0, 0, 3)
    return list
}


fun backtracking(list: MutableList<String>, currentStr: String, open: Int, close: Int, max: Int){
    if(currentStr.length == max * 2){
        list.add(currentStr)
        return
    }
    if(open < max) backtracking(list, "$currentStr(", open + 1, close, max )
    if(close < open) backtracking(list, "$currentStr)", open, close + 1, max)

}