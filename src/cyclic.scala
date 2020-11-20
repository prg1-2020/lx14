import scala.collection.mutable.Set

class Node[T](v: T) {
    val links = Set[Node[T]]()

    override def toString(): String = v.toString()

    def link(v: Node[T]) : Unit = {
        links += v
    }
}

object Cyclic extends App {
    val nodes = 0 to 5 map(new Node(_))
    for ((i, j) <- List((0, 1), (1, 3), (2, 3), (3, 4), (4, 5), (4, 3), (5, 3), (5, 5))) {
        nodes(i).link(nodes(j))
    }
    for (node <- nodes) println(s"$node.links: {${node.links}}")
}