/*
 * This file is part of the MARIAGE services.
 *
 * For the full copyright and license information,
 * please view the LICENSE file that was distributed with this source code.
 */

package model.site.facility

import model.component.util.ViewValuePageLayout
import persistence.geo.model.Location
import persistence.facility.model.Facility
import persistence.geo.model.Location.Region
import persistence.tag.model.Tag
// 表示: 施設一覧
//~~~~~~~~~~~~~~~~~~~~~
case class SiteViewValueFacilityList(
  layout:   ViewValuePageLayout,
  regions:    Seq[Region],
  capacities: Seq[Int],
  tags      : Seq[Tag],
  facilities: Seq[Facility]
)
