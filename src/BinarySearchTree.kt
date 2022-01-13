//import java.lang.Integer.max
//import kotlin.math.pow
//
//fun main(){
//    val tree = BinarySearchTree<Int>()
//    (0..14).forEach {
//        tree.insert(it)
//    }
//
//    tree.remove(1)
//    println(tree)
//
//}
//
//class BinarySearchTree<T: Comparable<T>>{
//
//    var root: BinaryNode<T>? = null
//
//
//    override fun toString(): String = root?.toString() ?: "empty tree"
//
//
//    fun insert(value: T){
//        root = insert(root, value)
//    }
//
//
//    private fun insert(
//        node: BinaryNode<T>?,
//        value: T
//    ):BinaryNode<T>{
//        node ?: return BinaryNode(value)
//        if (value < node.value) {
//            node.leftChild = insert(node.leftChild, value)
//        } else {
//            node.rightChild = insert(node.rightChild, value)
//        }
//        val balancedNode = balanced(node)
//        balancedNode.height = max(balancedNode.leftheight ?: 0,
//            balancedNode.rightHeight ?: 0) + 1
//        return balancedNode
//    }
//
//
//    fun contain(value: T): Boolean{
//        var current = root
//        while (current != null){
//            if (current.value == value){
//                return true
//            }
//            current = if(value < current.value){
//                current.leftChild
//            }else{
//                current.rightChild
//            }
//        }
//        return false
//    }
//
//
//    fun remove(value: T){
//        root = remove(root, value)
//    }
//
//    private fun remove(node: BinaryNode<T>?, value: T): BinaryNode<T>?{
//        node ?: return null
//        when{
//            value == node.value ->{
//                if(node.leftChild == null && node.rightChild == null){
//                    return null
//                }
//                if(node.leftChild == null){
//                    return node.rightChild
//                }
//                if(node.rightChild == null){
//                    return node.leftChild
//                }
//                node.rightChild?.min?.value?.let { node.value = it }
//                node.rightChild = remove(node.rightChild, node.value)
//            }
//            value < node.value -> node.leftChild = remove(node.leftChild, value)
//            else -> node.rightChild = remove(node.rightChild, value)
//        }
//        val balancedNode = balanced(node)
//        balancedNode.height = max(
//            balancedNode.leftheight,
//            balancedNode.rightHeight
//        ) + 1
//        return balancedNode
//    }
//
//
//    fun contains(subtree: BinarySearchTree<T>): Boolean{
//
//        val set = mutableSetOf<T>()
//        root?.traverseInOrder {
//            set.add(it)
//        }
//        var isEqual = true
//
//        subtree.root?.traverseInOrder {
//            isEqual = isEqual && set.contains(it)
//        }
//        return isEqual
//    }
//
//
//    fun displayElement(){
//        root?.traverseInOrder {
//            println(it)
//        }
//    }
//
//    private fun leftRotate(node: BinaryNode<T>): BinaryNode<T>{
//        val pivot = node.rightChild!!
//        node.rightChild = pivot.leftChild
//        pivot.leftChild = node
//
//        node.height = Integer.max(node.leftheight, node.rightHeight) + 1
//        pivot.height = Integer.max(pivot.leftheight, pivot.rightHeight) + 1
//        return pivot
//    }
//
//
//    private fun rightRotate(node: BinaryNode<T>): BinaryNode<T> {
//        val pivot = node.leftChild!!
//        node.leftChild = pivot.rightChild
//        pivot.rightChild = node
//        node.height = Integer.max(node.leftheight, node.rightHeight) + 1
//        pivot.height = Integer.max(pivot.leftheight, pivot.rightHeight) + 1
//        return pivot
//    }
//
//
//    private fun rightLeftRotate(node: BinaryNode<T>): BinaryNode<T> {
//        val rightChild = node.rightChild ?: return node
//        node.rightChild = rightRotate(rightChild)
//        return leftRotate(node)
//    }
//
//
//    private fun leftRightRotate(node: BinaryNode<T>): BinaryNode<T> {
//        val leftChild = node.leftChild ?: return node
//        node.leftChild = rightRotate(leftChild)
//        return rightRotate(node)
//    }
//
//    private fun balanced(node: BinaryNode<T>): BinaryNode<T> {
//        return when (node.balanceFactor) {
//            2 -> {
//                if (node.leftChild?.balanceFactor == -1) {
//                    leftRightRotate(node)
//                } else {
//                    rightRotate(node)
//                }
//            }
//            -2 -> {
//                if (node.rightChild?.balanceFactor == 1) {
//                    rightLeftRotate(node)
//                } else {
//                    leftRotate(node)
//                }
//            }
//            else -> node
//        }
//    }
//
//
//    fun leafNodes(height: Int): Int {
//        return 2.0.pow(height).toInt()
//    }
//
//
//
//
//
//    fun nodes(height: Int): Int {
//        return 2.0.pow(height + 1).toInt() - 1
//    }
//}