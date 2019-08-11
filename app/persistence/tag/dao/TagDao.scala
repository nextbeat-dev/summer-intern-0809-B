/*
 * This file is part of the Nextbeat services.
 *
 * For the full copyright and license information,
 * please view the LICENSE file that was distributed with this source code.
 */
package persistence.reservation.dao

import java.time.LocalDateTime
import java.time.LocalDate

import scala.concurrent.{ExecutionContext, Future}
import slick.jdbc.JdbcProfile
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider

import persistence.facility.model.Facility
import persistence.tag.model.{ Tag => MyTag }


// DAO: 予約情報
//~~~~~~~~~~~~~~~~~~
class TagDAO @javax.inject.Inject()(
  val dbConfigProvider: DatabaseConfigProvider
)  extends HasDatabaseConfigProvider[JdbcProfile] {
  import profile.api._

    // --[ リソース定義 ] --------------------------------------------------------
  lazy val slick = TableQuery[TagTable]

  // --[ データ処理定義 ] ------------------------------------------------------
  /**
   * 予約を取得
   */
  def get(id: MyTag.Id): Future[Option[MyTag]] =
    db.run {
      slick
        .filter(_.id === id)
        .result.headOption
    }
  def findAll: Future[Seq[MyTag]] =
    db.run {
      slick.result
    }

 

  // --[ テーブル定義 ] --------------------------------------------------------
  class TagTable(tag: Tag) extends Table[MyTag](tag, "tag") {


    // Table's columns
    /* @1 */ def id            = column[MyTag.Id] ("id", O.PrimaryKey, O.AutoInc)
    /* @2 */ def name          = column[String]  ("name")   
    /* @3 */ def updatedAt     = column[LocalDateTime]  ("updated_at")
    /* @4 */ def createdAt     = column[LocalDateTime]  ("created_at")

    // The * projection of the table
    def * = (
      id.?, name, updatedAt, createdAt
    ) <> (
      /** The bidirectional mappings : Tuple(table) => Model */
      (MyTag.apply _).tupled,
      /** The bidirectional mappings : Model => Tuple(table) */
      (v: TableElementType) => MyTag.unapply(v).map(_.copy(
        _3 = LocalDateTime.now
      ))
    )
  }
}
