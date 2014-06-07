package week4

import scala.collection.immutable.HashMap
import org.scalatest._

class StronglyConnectedComponentsTest extends FlatSpec {
  
  "The dfs function" should "return and ordered list of vertices" in {
    val graph = Map(
        1 -> List(2, 3, 4),
        3 -> List(4),
        4 -> List(2))
        
    val expected = List(1, 3, 4, 2)
    
    val result = StronglyConnectedComponents.dfs(graph)
    
    assert(expected == result)
  }

}