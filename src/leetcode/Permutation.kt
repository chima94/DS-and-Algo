package leetcode



fun main(){
    val numbers = mutableListOf(1,2,3)
    val list : MutableList<List<Int>> = mutableListOf()
    generate(numbers.size, numbers, list)
    println(list)

}



fun generate(k: Int, perm : MutableList<Int>, list: MutableList<List<Int>>){
    if(k == 1){
        list.add(perm.toList())
    }else{
        for (i in 0 until k){
            generate(k - 1, perm, list)
            if( k % 2 == 0){
                swap(perm, i, k - 1)
            }else{
                swap(perm, 0, k - 1)
            }
        }
    }

}

fun swap(list: MutableList<Int>, i:Int, k: Int){
    val temp = list[i]
    list[i] = list[k]
    list[k] = temp

}
