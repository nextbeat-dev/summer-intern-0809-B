-- 施設定義
--------------
CREATE TABLE "facility" (
  "id"           BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
  "name"         VARCHAR(255) NOT NULL,
  "catch_copy"   VARCHAR(255) DEFAULT NULL,
  "description"  TEXT         NOT NULL,
  "address"      VARCHAR(255) NOT NULL,
  "location_id"  VARCHAR(8)   NOT NULL,
  "url"          VARCHAR(255) NOT NULL,
  "cost"         INT          NOT NULL,
  "access"       VARCHAR(255) NOT NULL,
  "capacity"     INT          NOT NULL,
  "map"          VARCHAR(255) NOT NULL,
  "image_paths"  TEXT         NOT NULL,
  "contents"     TEXT         DEFAULT NULL,
  "updated_at"   timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  "created_at"   timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB;

-- 施設情報

