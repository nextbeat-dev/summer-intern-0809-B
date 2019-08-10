-- タグ定義
--------------
CREATE TABLE "tag" (
  "id"          BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
  "name"        VARCHAR(255) NOT NULL,
  "updated_at"  timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  "created_at"  timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB;

-- タグ情報
