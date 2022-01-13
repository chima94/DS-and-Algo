import java.util.Queue


fun main(){
    val graph = AdjacencyList<String>()
    val singapore = graph.createVertex("Singapore")
    val tokyo = graph.createVertex("Tokyo")
    val hongKong = graph.createVertex("Hong Kong")
    val detroit = graph.createVertex("Detroit")
    val sanFrancisco = graph.createVertex("San Francisco")
    val washingtonDC = graph.createVertex("Washington DC")
    val austinTexas = graph.createVertex("Austin Texas")
    val seattle = graph.createVertex("Seattle")

    graph.add(EdgeType.UNDIRECTED, singapore, hongKong, 300.0)
    graph.add(EdgeType.UNDIRECTED, singapore, tokyo, 500.0)
    graph.add(EdgeType.UNDIRECTED, hongKong, tokyo, 250.0)
    graph.add(EdgeType.UNDIRECTED, tokyo, detroit, 450.0)
    graph.add(EdgeType.UNDIRECTED, tokyo, washingtonDC, 300.0)
    graph.add(EdgeType.UNDIRECTED, hongKong, sanFrancisco, 600.0)
    graph.add(EdgeType.UNDIRECTED, detroit, austinTexas, 50.0)
    graph.add(EdgeType.UNDIRECTED, austinTexas, washingtonDC, 292.0)
    graph.add(EdgeType.UNDIRECTED, sanFrancisco, washingtonDC,
        337.0)
    graph.add(EdgeType.UNDIRECTED, washingtonDC, seattle, 277.0)
    graph.add(EdgeType.UNDIRECTED, sanFrancisco, seattle, 218.0)
    graph.add(EdgeType.UNDIRECTED, austinTexas, sanFrancisco, 297.0)

//    println(graph.weight(singapore, tokyo))
//    graph.edges(sanFrancisco).forEach {
//        println("${it.destination.data} : price -> ${it.weight}")
//    }
    val vertex = graph.breadthFirstSearch(singapore)
    vertex.forEach {
        println(it.data)
    }

}

enum class EdgeType{
    DIRECTED,
    UNDIRECTED
}

data class Vertex<T>(val index: Int, val data: T)
data class Ref<T>(var value: T)


data class Edge<T>(
    val source: Vertex<T>,
    val destination: Vertex<T>,
    val weight: Double? = null
)

interface Graph<T>{
    fun createVertex(data: T): Vertex<T>

    fun addDirectedEdge(
        source: Vertex<T>,
        destination: Vertex<T>,
        weight: Double?

    )

    fun addUndirectedEdge(
        source: Vertex<T>,
        destination: Vertex<T>,
        weight: Double?
    )

    fun add(
        edge: EdgeType,
        source: Vertex<T>,
        destination: Vertex<T>,
        weight: Double?
    )

    fun edges(source: Vertex<T>): ArrayList<Edge<T>>
    fun weight(source: Vertex<T>, destination: Vertex<T>): Double?
}


class AdjacencyList<T>: Graph<T>{

    private val adjacencies: HashMap<Vertex<T>, ArrayList<Edge<T>>> = HashMap()

    override fun toString(): String {
        return buildString { // 1
            adjacencies.forEach { (vertex, edges) -> // 2
                val edgeString = edges.joinToString{ it.destination.data.toString() } // 3
                append("${vertex.data} ---> [ $edgeString ]\n") // 4
            }
        }
    }

    override fun createVertex(data: T): Vertex<T> {
        val vertex = Vertex(adjacencies.count(), data)
        adjacencies[vertex] = ArrayList()
        return vertex
    }

    override fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        val edge = Edge(source, destination, weight)
        adjacencies[source]?.add(edge)
    }

    override fun addUndirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        addDirectedEdge(source, destination, weight)
        addDirectedEdge(destination, source, weight)
    }

    override fun add(edge: EdgeType, source: Vertex<T>, destination: Vertex<T>, weight: Double?){
        when(edge){
            EdgeType.DIRECTED -> addDirectedEdge(source, destination, weight)
            EdgeType.UNDIRECTED -> addUndirectedEdge(source, destination, weight)
        }
    }

    override fun edges(source: Vertex<T>): ArrayList<Edge<T>> = adjacencies[source] ?: arrayListOf()

    override fun weight(source: Vertex<T>, destination: Vertex<T>): Double? {
        return edges(source).firstOrNull(){it.destination == destination}?.weight
    }


    //number of paths in a vertice
    fun  numberOfPaths(source: Vertex<T>, destination: Vertex<T>): Int{
        val numberOfPaths = Ref(0)
        val visited: MutableSet<Vertex<T>> = mutableSetOf()
        paths(source, destination, visited, numberOfPaths)
        return numberOfPaths.value
    }


    fun paths(
        source: Vertex<T>,
        destination: Vertex<T>,
        visited: MutableSet<Vertex<T>>,
        pathCount: Ref<Int>
    ){
        visited.add(source)
        if(source == destination){
            pathCount.value += 1
        }else{
            val neighbors = edges(source = source)
            neighbors.forEach { edge ->
                if(edge.destination !in visited){
                    paths(edge.destination, destination, visited, pathCount)
                }
            }
        }
        visited.remove(source)
    }


    fun breadthFirstSearch(source: Vertex<T>): ArrayList<Vertex<T>>{
        val queue = DoubleStackQueue<Vertex<T>>()
        val enqueued = ArrayList<Vertex<T>>()
        val visited = ArrayList<Vertex<T>>()

        queue.enqueue(source)
        enqueued.add(source)

        while (true){
            val vertex = queue.dequeue() ?: break
            visited.add(vertex)

            val neighborEdges = edges(vertex)
            neighborEdges.forEach {
                if(!enqueued.contains(it.destination)){
                    queue.enqueue(it.destination)
                    enqueued.add(it.destination)
                }
            }
        }
        return visited
    }

}





class AdjacencyMatrix<T>: Graph<T>{

    private val vertices = arrayListOf<Vertex<T>>()
    private val weights = arrayListOf<ArrayList<Double?>>()

    override fun createVertex(data: T): Vertex<T> {
        val vertex = Vertex(vertices.count(), data)
        vertices.add(vertex)
        weights.forEach {
            it.add(null)
        }
        val row = ArrayList<Double?>(vertices.count())
        repeat(vertices.count()){
            row.add(null)
        }
        weights.add(row)
        return vertex
    }



    override fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        weights[source.index][destination.index] = weight
    }

    override fun addUndirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        addDirectedEdge(source, destination, weight)
        addDirectedEdge(destination, source, weight)
    }

    override fun add(edge: EdgeType, source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        when(edge){
            EdgeType.DIRECTED -> addDirectedEdge(source, destination, weight)
            EdgeType.UNDIRECTED -> addUndirectedEdge(source, destination, weight)
        }
    }

    override fun edges(source: Vertex<T>): ArrayList<Edge<T>> {
        val edges = arrayListOf<Edge<T>>()
        (0 until weights.size).forEach { column ->
            val weight = weights[source.index][column]
            if(weight != null){
                edges.add(Edge(source, vertices[column], weight))
            }
        }
        return edges
    }

    override fun weight(source: Vertex<T>, destination: Vertex<T>): Double? {
        return weights[source.index][destination.index]
    }

    override fun toString(): String {
        // 1
        val verticesDescription = vertices
            .joinToString(separator = "\n") { "${it.index}: ${it.data}" }
        // 2
        val grid = weights.map { row ->
            buildString {
                (0 until weights.size).forEach { columnIndex ->
                    val value = row[columnIndex]
                    if (value != null) {
                        append("$value\t")
                    } else {
                        append("ø\t\t")
                    }
                }
            }
        }
        val edgesDescription = grid.joinToString("\n")
        // 3
        return "$verticesDescription\n\n$edgesDescription"
    }

}




