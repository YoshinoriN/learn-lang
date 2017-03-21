package controllers

import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.libs.concurrent.Execution.Implicits.defaultContent
import play.api.i18n.{MessagesApi, I18nSupport}
import play.api.db.slick._
import slick.driver.JdbcProfile
import models.Tables._
import javax.inject.Inject
import scala.concurrent.Future
import slick.driver.H2Driver.api._

/**
  * DIのため、コンストラクタでInjectアノテーションと2クラスのインスタンスの取得を行う
  * また、インスタンスの取得だけでなく、トレイトをミックスインする（ざっくり書くと機能の一部を使用する）
  */
class UserController @Inject()(val dbConfigProvider: DatabaseConfigProvider,
                               val messageApi: MessagesApi) extends Controller
    with HasDatabaseConfigProvider[JdbcProfile] with I18nSupport {

  /**
    * 一覧表示
    */
  def list = TODO

  /**
    * 編集画面表示
    */
  def edit(id: Option[Long]) = TODO

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