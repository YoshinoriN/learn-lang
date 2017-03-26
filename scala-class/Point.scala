/*
コンストラクタの引数をそのまま公開したいは下記でも可
class Point(val x: Int, val y: Int)

複数のコンストラクタは定義できるが、実際に使うことはないらしい。
 */

/*
class Point(_x: Int, _y: Int) {
  val x = _x
  val y = _y
}
*/

class Point(val x: Int, val y: Int) {
  def +(p: Point): Point = {
    new Point(x + p.x, y + p.y)
  }

  override def toString: String = "(" + x + ", " + y + ")"
}