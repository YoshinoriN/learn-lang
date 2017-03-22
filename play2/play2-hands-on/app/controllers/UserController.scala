package controllers

import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.i18n.{MessagesApi, I18nSupport}
import play.api.db.slick._
import slick.driver.JdbcProfile
import models.Tables._
import javax.inject.Inject
import scala.concurrent.Future
import slick.driver.H2Driver.api._
//コンパニオンオブジェクトのFormを参照するためにimportする
import UserController._

/**
  *  画面からの入力を受け取るForm
  *  コントローラーでの処理に強く依存するため、理由がない場合はコントローラークラスのコンパニオンオブジェクト（クラスやトレイトと同じ名前で作成された同名のオブジェクトのこと）に定義するとよい
  *  対応するクラスやトレイトは互いにprivateなメンバにアクセスできる。
  *  共通で使用するメソッドを抽出するのに使ったりする。
  */
object UserController {
  //フォームの値を格納するケースクラス
  case class UserForm(id: Option[Long], name: String, companyId: Option[Int])

  val userForm = Form(
    mapping(
      "id"        -> optional(longNumber),
      "name"      -> nonEmptyText(maxLength = 20),
      "companyId" -> optional(number)
    )(UserForm.apply)(UserForm.unapply)
  )
}


/**
  * DIのため、コンストラクタでInjectアノテーションと2クラスのインスタンスの取得を行う
  * また、インスタンスの取得だけでなく、トレイトをミックスインする（ざっくり書くと機能の一部を使用する）
  */
class UserController @Inject()(val dbConfigProvider: DatabaseConfigProvider,
                               val messagesApi: MessagesApi) extends Controller
  with HasDatabaseConfigProvider[JdbcProfile] with I18nSupport {

  /**
    * 一覧表示
    */
  def list = Action.async { implicit rs =>
    //ID昇順にすべてのユーザーを取得
    db.run(Users.sortBy(t => t.id).result).map { users =>
      //一覧画面表示
      Ok(views.html.user.list(users))
    }
  }

  /**
    * 編集画面表示
    */
  def edit(id: Option[Long]) = Action.async { implicit rs =>

    //リクエストパラメータにIDが存在する場合
    val form = if(id.isDefined) {
      //IDからユーザー情報を1件取得
      db.run(Users.filter(t => t.id === id.get.bind).result.head).map { user =>
        //値をフォームに詰める
        userForm.fill(UserForm(Some(user.id), user.name, user.companyId))
      }
    } else {
      Future { userForm }
    }

    form.flatMap { form =>
      //会社一覧を取得
      db.run(Companies.sortBy(_.id).result).map { companies =>
        Ok(views.html.user.edit(form, companies))
      }
    }
  }

  /**
    * 登録
    */
  def create = TODO

  /**
    * 更新
    */
  def update = TODO

  /**
    * 削除
    */
  def remove(id: Long) = TODO

}