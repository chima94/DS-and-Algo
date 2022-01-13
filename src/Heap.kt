
import java.util.*
import java.util.Collections.sort
import kotlin.Comparator
import kotlin.collections.ArrayList



fun main(){
    var array = arrayListOf(1, 12, 3, 4, 1, 6, 8, 7)
    val priorityQueue = ComparableHeapImpl.create(array)
//    while (!priorityQueue.isEmpty){
//        println(priorityQueue.remove())
//    }

    //min heap
    val inverseComparator = Comparator<Int> { o1, o2 -> o2.compareTo(o1) }
    val minHeap = ComparatorHeapImpl.create(array, inverseComparator)
    while (!minHeap.isEmpty){
        println(minHeap.remove())
    }
}



interface Collection<Element>{
    val count: Int
        get
    val isEmpty:Boolean
        get() = count == 0

    fun insert(element: Element)

    fun remove(): Element?

    fun remove(index: Int): Element?
}


interface Heap<Element>: Collection<Element>{

    fun peek(): Element?
}

abstract class AbstractHeap<Element>(): Heap<Element>{
    var elements: ArrayList<Element> = ArrayList()
    override val count: Int
        get() = elements.size
    abstract fun compare(a: Element, b: Element): Int
    override fun peek(): Element? = elements.first()
    private fun leftChildIndex(index: Int) = (2 * index) + 1
    private fun rightChildIndex(index: Int) = (2 * index) + 2
    private fun parentIndex(index: Int) = (index - 1) / 2

    override fun insert(element: Element) {
        elements.add(element)
        siftUp(count - 1)
    }


    override fun remove(): Element? {
        if(isEmpty)return null
        Collections.swap(elements, 0, count -1)
        val item = elements.removeAt(count - 1)
        shiftDown(0)
        return item
    }

    override fun remove(index: Int): Element? {
        if(index >= count) return null
        return if(index == count - 1){
            elements.removeAt(count - 1)
        }else{
            Collections.swap(elements, index, count - 1)
            val item = elements.removeAt(count - 1)
            shiftDown(index)
            siftUp(index)
            item
        }
    }



    private fun siftUp(index: Int){
        var child = index
        var parent = parentIndex(child)
        while (child > 0 && compare(elements[child], elements[parent]) > 0){
            Collections.swap(elements, child, parent)
            child = parent
            parent = parentIndex(child)
        }
    }



    private fun shiftDown(index: Int){
        var parent = index
        while (true){
            val left = leftChildIndex(parent)
            val right = rightChildIndex(parent)
            var candidate = parent
            if(left < count && compare(elements[left], elements[candidate]) > 0){
                candidate = left
            }
            if( right < count && compare(elements[right], elements[candidate]) > 0){
                candidate = right
            }
            if(candidate == parent){
                return
            }
            Collections.swap(elements, parent, candidate)
            parent = candidate
        }
    }


//    private fun index(element: Element, i: Int): Int?{
//        if(i >= count){
//            return null
//        }
//        if (sort(element, elements[i])) {
//            return null // 2
//        }
//        if (element == elements[i]) {
//            return i // 3
//        }
//        val leftChildIndex = index(element, leftChildIndex(i))
//        if (leftChildIndex != null) return leftChildIndex
//        val rightChildIndex = index(element, rightChildIndex(i))
//        if (rightChildIndex != null) return rightChildIndex
//        return null
//    }


    protected fun heapify(values: ArrayList<Element>){
        elements = values
        if(elements.isNotEmpty()){
            (count /2 downTo 0).forEach {
                shiftDown(it)
            }
        }
    }


}


class ComparableHeapImpl<Element: Comparable<Element>>(): AbstractHeap<Element>(){
    override fun compare(a: Element, b: Element): Int  = a.compareTo(b)

    companion object{
        fun <Element: Comparable<Element>>create(
            elements:ArrayList<Element>
        ):Heap<Element>{
            val heap = ComparableHeapImpl<Element>()
            heap.heapify(elements)
            return heap
        }
    }

}

class ComparatorHeapImpl<Element>(private val comparator: Comparator<Element>): AbstractHeap<Element>(){
    override fun compare(a: Element, b: Element): Int = comparator.compare(a, b)

    companion object {
        fun <Element> create(
            elements: ArrayList<Element>,
            comparator: Comparator<Element>
        ): Heap<Element> {
            val heap = ComparatorHeapImpl(comparator)
            heap.heapify(elements)
            return heap
        }
    }
}
