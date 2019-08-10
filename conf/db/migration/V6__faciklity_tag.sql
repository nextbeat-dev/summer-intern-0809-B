-- 施設タグの関係テーブル定義
--------------
CREATE TABLE "facility_tag" (
  "id"          BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
  "facility_id" BIGINT       NOT NULL,
  "tag_id"      BIGINT       NOT NULL,
  "updated_at"  timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  "created_at"  timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB;

-- 施設タグ情報
