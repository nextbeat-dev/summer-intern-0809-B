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
INSERT INTO "facility_tag" ("id", "facility_id", "tag_id") VALUES
(1,  1, 1),
(2,  1, 2),
(3,  1, 3),
(4,  2, 2),
(5,  2, 3),
(6,  2, 4),
(7,  4, 3),
(8,  4, 4),
(9,  4, 5),
(10, 5, 1),

(11, 6,  1),
(12, 6,  2),
(13, 7,  1),
(14, 8,  2),
(15, 9,  3),
(16, 10, 4),
(17, 11, 5),
(18, 12, 2),
(19, 13, 3),
(20, 14, 3),


(21, 15,  1),
(22, 15,  2),
(23, 15,  3),
(24, 15,  4),
(25, 15,  5),
(26, 16,  4),
(27, 17,  5),
(28, 18,  2),
(29, 18,  3),
(30, 18,  1)
;

