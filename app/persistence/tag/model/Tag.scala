/*
 * This file is part of the Nextbeat services.
 *
 * For the full copyright and license information,
 * please view the LICENSE file that was distributed with this source code.
 */
package persistence.tag.model

import play.api.data._
import play.api.data.Forms._
import java.time.LocalDateTime
import java.time.LocalDate
import persistence.tag.model.{ Tag => MyTag }


// 予約状況情報
case class Tag(
  id:          Option[MyTag.Id],                // 予約ID
  name:        String,                        // 名前 
  updatedAt:   LocalDateTime = LocalDateTime.now,  // データ更新日
  createdAt:   LocalDateTime = LocalDateTime.now   // データ作成日
)


// 施設検索
case class TagSearch(
  tagIdOpt : Option[MyTag.Id]
)




// コンパニオンオブジェクト
//~~~~~~~~~~~~~~~~~~~~~~~~~~
object Tag {

  // --[ 管理ID ]---------------------------------------------------------------
  type Id = Long

}
