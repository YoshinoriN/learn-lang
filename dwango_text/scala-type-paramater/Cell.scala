/*
型パラメータは好きな名前を付け、クラス定義内で使用することができる
1つの要素を保持して、入れる(put)・取り出す(set)ができるクラス
C#でいうset,getという解釈でよい？？？
 */
class Cell[A](var value: A) {
  def put(newValue: A): Unit = {
    value = newValue
  }

  def get(): A = value
}

/*
scala> val cell = new Cell[Int](1)
cell: Cell[Int] = Cell@4246cfff

scala> cell.put(2)

scala> cell.get()
res1: Int = 2

scala> cell.put("String!!")
<console>:13: error: type mismatch;
 found   : String("String!!")
 required: Int
       cell.put("String!!")
                ^

scala>
 */