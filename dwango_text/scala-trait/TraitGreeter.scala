trait TraitGreeter {
  def greet(): Unit
}

/**
  * このtraitは起動時に挨拶（greet）する。
  * 継承していないのにgreetメソッドを使える。
  */
trait Robot {
  //自分自身の方にアノテーションを記述できる。これを自分型という。
  self: TraitGreeter =>

  def start(): Unit = greet()
  //Scalaのfinalはオーバーライドさせないを意味する。加えてインライン化の指定を意味する。
  override final def toString = "Robot"
}


/**
 Robotを動作させるにはgreetメソッドを実装したトレイトが必要
 自分型を使うには中小トレイトを指定し、後から実装を追加（DI）する。

 val r = new Robot with HelloGreeter
 r: Robot with HelloGreeter = Robot

 r.start
 Hello!
 */
trait HelloGreeter extends TraitGreeter {
  def greet(): Unit = println("Hello!")
}

/*
 継承で作ったこっちはgreetメソッドを呼び出せるが、Robotの方（自分型で作った）はgreetを呼び出せない...らしい
 Robotの方でも呼び出せてしまう...
 */
trait Robot2 extends TraitGreeter {
  def start(): Unit = greet()
  override final def toString = "Robot"
}