-- 予約定義
--------------
CREATE TABLE "reservation" (
  "id"          BIGINT     NOT NULL AUTO_INCREMENT PRIMARY KEY,
  "facility_id" BIGINT     NOT NULL,
  "start_date"  DATE       NOT NULL,
  "end_date"    DATE       NOT NULL,
  "user_id"     BIGINT     NOT NULL,
  "user_type"   INT        NOT NULL DEFAULT 0,
  "updated_at"  timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  "created_at"  timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB;

-- 予約情報
