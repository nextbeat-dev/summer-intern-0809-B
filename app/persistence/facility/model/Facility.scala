/*
 * This file is part of the Nextbeat services.
 *
 * For the full copyright and license information,
 * please view the LICENSE file that was distributed with this source code.
 */

package persistence.facility.model

import play.api.data._
import play.api.data.Forms._
import java.time.LocalDateTime
import persistence.geo.model.Location

// 施設情報 (sample)
//~~~~~~~~~~~~~
case class Facility(
  id:          Option[Facility.Id],                // 施設ID
  name:        String,                             // 施設名
  catchCopy:   Option[String],                     // キャッチコピー
  description: String,                             // 施設説明
  address:     String,                             // 住所(詳細) 
  locationId:  Location.Id,                        // 地域ID
  url:         String,                             // 公式サイトのURL
  cost:        Int,                                // 一人当たりの金額
  access:      String,                             //　~からN時間とか
  capacity:    Int,                                // 最大収容人数
  map:         String,                             // googleマップの埋め込み要素
  imagePaths:  String,                             // 施設画像、","で分割して利用/今はMax4枚
  contents:    Option[String],                     // 追加のコンテンツ(HTML)
  updatedAt:   LocalDateTime = LocalDateTime.now,  // データ更新日
  createdAt:   LocalDateTime = LocalDateTime.now   // データ作成日
)

// 施設検索
case class FacilitySearch(
  regionIdOpt: Option[Short],
  capacityOpt: Option[Int],
  tagOpt: Option[Short]
)

// コンパニオンオブジェクト
//~~~~~~~~~~~~~~~~~~~~~~~~~~
object Facility {

  // --[ 管理ID ]---------------------------------------------------------------
  type Id = Long

  // --[ フォーム定義 ]---------------------------------------------------------
  val formForFacilitySearch = Form(
    mapping(
      "regionCode" -> optional(shortNumber)
        .verifying("regionCode is invalid.", value => if (value.isDefined) (value.get >= 1 && value.get <= 8 ) else true),
      "capacities" -> optional(number)
        .verifying("capacity is invalid.", value=> if (value.isDefined) (value.get >= 1 && value.get <= 100) else true),
      "tagCode" -> optional(shortNumber),
    )(FacilitySearch.apply)(FacilitySearch.unapply)
  )
}

