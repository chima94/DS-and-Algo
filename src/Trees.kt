//import javax.swing.tree.TreeNode
//
//fun main(){
//
//    val lineage = TreesNode("Nwakigwe")
//    val firstChild = TreesNode("chima")
//    val lastChild = TreesNode("chinalu")
//    val chimaFirst = TreesNode("james")
//    val chimaLast = TreesNode("sofia")
//    val naluFirst = TreesNode("kachi")
//    val naluLast = TreesNode("brian")
//
//    lineage.add(firstChild)
//    lineage.add(lastChild)
//
//    firstChild.add(chimaFirst)
//    firstChild.add(chimaLast)
//
//    lastChild.add(naluFirst)
//    lastChild.add(naluLast)
//
//    lineage.printOnLevelOrder()
//    lineage.search("chima")?.let{
//        println("word was found")
//    } ?: println("Not found")
//
//
//
//}
//
//
//
//
//fun makeTrees(): TreesNode<String>{
//    val tree = TreesNode("Beverages")
//
//    val hot = TreesNode("hot")
//    val cold = TreesNode("cold")
//
//    val tea = TreesNode("tea")
//    val coffee = TreesNode("coffee")
//    val chocolate = TreesNode("cocoa")
//
//    val blackTea = TreesNode("black")
//    val greenTea = TreesNode("Green")
//    val chaiTea = TreesNode("chai")
//
//    val soda = TreesNode("soda")
//    val milk = TreesNode("milk")
//
//    val gingerAle = TreesNode("ginger ale")
//    val bitterLemon = TreesNode("bitter lemon")
//
//    tree.add(hot)
//    tree.add(cold)
//
//    hot.add(tea)
//    hot.add(coffee)
//    hot.add(chocolate)
//
//    cold.add(soda)
//    cold.add(milk)
//
//    tea.add(blackTea)
//    tea.add(greenTea)
//    tea.add(chaiTea)
//
//    soda.add(gingerAle)
//    soda.add(bitterLemon)
//    return tree
//}
//
//
//class TreesNode<T>(val value: T){
//    private val children = mutableListOf<TreesNode<T>>()
//
//    fun add(node: TreesNode<T>){
//        children.add(node)
//    }
//
//    fun getAllNodes(node: (TreesNode<T>) -> Unit){
//        node(this)
//        children.forEach {
//           it.getAllNodes(node)
//        }
//    }
//
//    fun printOnLevelOrder(){
//        val queue = DoubleStackQueue<TreesNode<T>>()
//        queue.enqueue(this)
//        var currentLevelNode = 0
//
//        while (queue.isEmpty.not()){
//            currentLevelNode = queue.count
//
//            while (currentLevelNode > 0){
//                val node = queue.dequeue()
//                node?.let{
//                    print("${it.value} ")
//                    it.children.forEach { queue.enqueue(it) }
//                    currentLevelNode--
//                }
//            }
//            println()
//        }
//    }
//
//    fun search(value: T):TreesNode<T>?{
//        var result: TreesNode<T>? = null
//        children.forEach{
//            if(it.value == value){
//                result = it
//            }
//        }
//        return result
//    }
//
//}
//
//
//
