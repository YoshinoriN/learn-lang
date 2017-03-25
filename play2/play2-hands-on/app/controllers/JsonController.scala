package controllers

import play.api.mvc._

import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.db.slick._
import slick.driver.JdbcProfile
import models.Tables._
import javax.inject.Inject
import scala.concurrent.Future
import slick.driver.H2Driver.api._

import play.api.libs.json._
import play.api.libs.functional.syntax._

//play2のJSONサポートによるDSLでの記述
object JsonController {
  // Scalaオブジェクト(UsersRow)をJSONに変換するにはWritesを定義
  implicit val usersRowWritesWrites = (
    (__ \ "id"       ).write[Long]   and
    (__ \ "name"     ).write[String] and
    (__ \ "companyId").writeNullable[Int]
    )(unlift(UsersRow.unapply))
}

/* play2のJSONサポートによるDSLを使わない場合
implicit val usersRowWritesFormat = new Writes[UsersRow]{
  def writes(user: UsersRow): JsValue = {
    Json.obj(
      "id"        -> user.id,
      "name"      -> user.name,
      "companyId" -> user.companyId
    )
  }
}
*/

class JsonController @Inject()(val dbConfigProvider: DatabaseConfigProvider) extends Controller
  with HasDatabaseConfigProvider[JdbcProfile] {

  /**
    * 一覧表示
    */
  def list = TODO

  /**
    * ユーザ登録
    */
  def create = TODO

  /**
    * ユーザ更新
    */
  def update = TODO

  /**
    * ユーザ削除
    */
  def remove(id: Long) = TODO
}