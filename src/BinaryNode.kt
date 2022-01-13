//import java.lang.Integer.max
//
//fun main(){
//
//    val zero = BinaryNode(0)
//    val one = BinaryNode(1)
//    val five = BinaryNode(5)
//    val seven = BinaryNode(7)
//    val eight = BinaryNode(8)
//    val nine  = BinaryNode(9)
//
//    seven.leftChild = one
//    seven.rightChild  = nine
//    one.leftChild = zero
//    one.rightChild = five
//    nine.leftChild = eight
//
//
//    val tree = seven
//    tree.breadthFirstTraversal {
//        println(it)
//    }
////    val serializeTree = tree.serialization()
////    println(serializeTree)
////
////    println(tree.deserializedOptimized(serializeTree))
//}
//
//class BinaryNode<T: Comparable<T>>(var value: T){
//
//    var leftChild: BinaryNode<T>? = null
//    var rightChild: BinaryNode<T>? = null
//
//    val min: BinaryNode<T>?
//        get() = leftChild?.min ?: this
//
//    val isBinarySearchTree: Boolean
//        get() = isBST(this, min = null, max = null)
//
//    var height = 0
//
//    val leftheight: Int
//        get() = leftChild?.height ?: -1
//
//    val rightHeight: Int
//        get() = rightChild?.height ?: -1
//
//    val balanceFactor: Int
//        get() = leftheight - rightHeight
//
//    override fun toString() = diagram(this)
//
//
//    override fun equals(other: Any?): Boolean {
//        return if(other != null && other is BinaryNode<*>){
//            this.value == other.value && this.leftChild == other.leftChild && other.rightChild == this.rightChild
//        }else{
//            false
//        }
//    }
//
//
//    private fun diagram(node: BinaryNode<T>?,
//                        top: String = "",
//                        root: String = "",
//                        bottom: String = ""): String {
//        return node?.let {
//            if (node.leftChild == null && node.rightChild == null) {
//                "$root${node.value}\n"
//            } else {
//                diagram(node.rightChild, "$top ", "$top┌──", "$top│ ") +
//                        root + "${node.value}\n" + diagram(node.leftChild,
//                    "$bottom│ ", "$bottom└──", "$bottom ")
//            }
//        } ?: "${root}null\n"
//    }
//
//
//    fun traverseInOrder(visit: (T) -> Unit){
//        leftChild?.traverseInOrder(visit)
//        visit(value)
//
//        rightChild?.traverseInOrder(visit)
//    }
//
//
//    //or it can be called dept-first-traversal
//    fun traversePreOrder(visit: (T) -> Unit){
//        visit(value)
//        leftChild?.traversePreOrder(visit)
//        rightChild?.traversePreOrder(visit)
//    }
//
//    fun traversePostOrder(visit: (T) -> Unit){
//        leftChild?.traversePostOrder(visit)
//        rightChild?.traversePostOrder(visit)
//        visit(value)
//    }
//
//    fun height(node: BinaryNode<T>? = this): Int{
//        return node?.let {
//            1 + max(height(node.leftChild), height(node.rightChild))
//        } ?: -1
//    }
//
//    fun traversePreOrderWithNull(visit: (T?) -> Unit){
//        visit(value)
//        leftChild?.traversePreOrderWithNull(visit) ?: visit(null)
//        rightChild?.traversePreOrderWithNull(visit) ?: visit(null)
//    }
//
//    fun serialization(node: BinaryNode<T> = this): MutableList<T?>{
//        val list = mutableListOf<T?>()
//        node.traversePreOrderWithNull { list.add(it) }
//        return list
//    }
//
//    fun deserialize(list: MutableList<T?>): BinaryNode<T>?{
//        val rootValue = list.removeAt(list.size - 1) ?: return null
//
//        val root = BinaryNode<T>(rootValue)
//        root.leftChild = deserialize(list)
//        root.rightChild = deserialize(list)
//        return root
//    }
//
//    fun deserializedOptimized(list: MutableList<T?>): BinaryNode<T>?{
//        return deserialize(list.asReversed())
//    }
//
//    //breath-first-traversal
//    fun breadthFirstTraversal(visit: (T) -> Unit){
//        val queue = DoubleStackQueue<BinaryNode<T>>()
//        queue.enqueue(this)
//
//        var node = queue.dequeue()
//        while (node != null){
//            visit(node.value)
//            node.leftChild?.let { queue.enqueue(it) }
//            node.rightChild?.let { queue.enqueue(it) }
//            node = queue.dequeue()
//        }
//    }
//
//
//    private fun isBST(tree: BinaryNode<T>?, min: T?, max: T?):
//            Boolean {
//
//        tree ?: return true
//
//        if (min != null && tree.value <= min) {
//            return false
//        } else if (max != null && tree.value > max) {
//            return false
//        }
//
//
//        return isBST(tree.leftChild, min, tree.value) && isBST(tree.rightChild, tree.value, max)
//    }
//
//
//
//
//
//
//
//
//
//
//
//}
