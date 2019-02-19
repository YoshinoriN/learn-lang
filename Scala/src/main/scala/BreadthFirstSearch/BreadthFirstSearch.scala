package breadthfirstsearch

import scala.collection.mutable

object BreadthFirstSearch extends App {

  case class Node(name: String)

  val sampleGraph: Map[Node, Seq[Node]] = Map(
      Node("A") -> Seq(Node("B"), Node("C"), Node("D")),
      Node("C") -> Seq(Node("E"), Node("F")),
      Node("B") -> Seq(Node("F")),
      Node("D") -> Seq(Node("G"), Node("H")),
      Node("E") -> Seq(Node("J")),
      Node("F") -> Seq(Node("I")),
      Node("G") -> Seq(Node("J")),
      Node("H") -> Seq()
    )

  val queue = new mutable.Queue[Node]
  queue.enqueue(Node("A"))
  bfs(sampleGraph, Node("G"), Seq())

  def bfs(graph: Map[Node, Seq[Node]], goal: Node, visited: Seq[Node]): Boolean = {
    if (queue.isEmpty) {
      println("Not Found")
      return false
    }

    val q = queue.dequeue()
    println(s"$q $queue")
    if (q == goal) {
      println("Found")
      return true
    }

    if (visited.contains(q)) {
      bfs(graph, goal, visited)
    } else {
      graph.get(q) match {
        case Some(x) => {
          x.foreach(y => queue.enqueue(y))
          bfs(graph, goal, visited :+ q)
        }
        case _ => bfs(graph, goal, visited :+ q)
      }
    }
  }

}

/*
Node(A) Queue()
Node(B) Queue(Node(C), Node(D))
Node(C) Queue(Node(D), Node(F))
Node(D) Queue(Node(F), Node(E), Node(F))
Node(F) Queue(Node(E), Node(F), Node(G), Node(H))
Node(E) Queue(Node(F), Node(G), Node(H), Node(I))
Node(F) Queue(Node(G), Node(H), Node(I), Node(J))
Node(G) Queue(Node(H), Node(I), Node(J))
Found
 */
