package leetcode

import java.util.*

fun main(){

   val word = "PAYPALISHIRING" //PAHNAPLSIIGYIR  PINALSIGYAHRPI
    println(word.zigzagConversion(4))
}

fun String.zigzagConversion(numRow: Int): String{
    if(numRow <= 1) return this
    var result = StringBuilder()
    for(i in 0 until numRow){
        var j = i
        var up = true
        while (j < this.length){
            result = result.append(this[j])
            if(i == 0 || i == numRow - 1){
                j += (2 * numRow - 2)
            }else{
                j += if(up){
                    (2 * (numRow - i) - 2)
                }else{
                    i * 2
                }
                up = !up
            }
        }
    }
    return result.toString()
}

