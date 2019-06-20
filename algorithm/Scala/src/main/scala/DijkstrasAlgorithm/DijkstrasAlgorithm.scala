import scala.collection.mutable

object DijkstrasAlgorithm extends App {

  case class Node(name: String)

  val sampleGraph: mutable.HashMap[Node, mutable.HashMap[Node, Double]] = mutable.HashMap(
    Node("A") -> mutable.HashMap(Node("B") -> 6, Node("C") -> 2),
    Node("B") -> mutable.HashMap(Node("D") -> 1),
    Node("C") -> mutable.HashMap(Node("D") -> 7, Node("B") -> 3),
    Node("D") -> mutable.HashMap()
  )

  // ノードまでのコストを記録する （StartをA、GoalをDとした場合）
  val cost: mutable.HashMap[Node, Double] = mutable.HashMap(
    Node("B") -> 6,
    Node("C") -> 2,
    Node("D") -> Double.PositiveInfinity
  )

  // 親ノードリスト （StartをA、GoalをDとした場合）
  val parentNode: mutable.HashMap[Node, Node] = mutable.HashMap(
    Node("B") -> Node("A"),
    Node("C") -> Node("A"),
    Node("D") -> Node("")
  )

  dijkstras(sampleGraph, Node("A") ,Node("D"), Seq())

  def dijkstras(graph: mutable.HashMap[Node, mutable.HashMap[Node, Double]], currentNode: Node, goal: Node, visited: Seq[Node]): Unit = {

    println(cost)
    println(parentNode)

    if (currentNode == goal) {
      return
    }

    graph.get(currentNode) match {
      case Some(x) => {
        if (x.nonEmpty) {
          // 最も近いノードを取得する
          findShortestCostNode(x, visited) match {
            case Some(sn) => {
              // 最も近いノードの隣接ノードを取得し、順に処理する
              getAdjacentNodes(graph, sn.head._1) match {
                case Some(adjacentNodes) => {
                  for(an <- adjacentNodes.toList) {
                    if (cost(an._1) > cost(sn.head._1) + an._2) {
                      // 最短コストの更新
                      cost(an._1) = cost(sn.head._1) + an._2
                      // 親ノードの更新
                      parentNode(an._1) = sn.head._1
                    }
                  }
                  // 現状のノードの隣接ノードで未処理のノードがあるかどうか
                  findShortestCostNode(x, visited :+ sn.head._1) match {
                    // 未処理のノードがある場合はそちらのノードを基に探索する
                    case Some(nsn) => dijkstras(graph, currentNode, goal, visited :+ sn.head._1)
                    // ない場合は処理中の最も近いノードを次の探索の基準にする
                    case _ => dijkstras(graph, sn.head._1, goal, visited :+ sn.head._1)
                  }
                }
                case None => ???
              }
            }
          }

        }
      }
      case None => ???
    }
  }

  // 隣接ノードのうち未訪問かつ最短コストのノードを取得
  def findShortestCostNode(nodes: mutable.HashMap[Node, Double], visited: Seq[Node]): Option[mutable.HashMap[Node, Double]] = {
    val node = nodes.filter(x => !visited.contains(x._1))
    if (node.isEmpty) {
      None
    } else {
      Option(mutable.HashMap(node.minBy(_._2)))
    }
  }

  // 隣接ノードを取得する
  def getAdjacentNodes(graph: mutable.HashMap[Node, mutable.HashMap[Node, Double]], node: Node): Option[mutable.HashMap[Node, Double]] ={
    graph.get(node) match {
      case Some(x) => Option(x)
      case None => None
    }
  }

}
