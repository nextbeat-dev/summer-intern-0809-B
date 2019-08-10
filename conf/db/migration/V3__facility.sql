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
  "map"          TEXT         NOT NULL,
  "image_paths"  TEXT         NOT NULL,
  "contents"     TEXT         DEFAULT NULL,
  "updated_at"   timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  "created_at"   timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB;

-- 施設情報

INSERT INTO "facility" ("id", "name", "catch_copy", "description", "address", "location_id", "url", "cost", "access", "capacity", "map", "image_paths", "contents")
VALUES(1, 'THE HOUSE on the beach', 'ここにしかない時間が流れる至極のひととき。',
'窓の向こうに広がる太平洋。そして、よく晴れた日には富士山を望むことができます。五感を研ぎ澄ませ、自然と戯れる。ここMonterey House Point Pinosには、ホテルや旅館で味わえない特別な時間が流れています。',
'〒294-0314 千葉県 館山市波左間1000-2',
'13000',
'https://www.ikyu.com/vacation/00050002/',
100000,
'東京から1時間',
30,
'<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3258.0697868883894!2d139.60278281527692!3d35.254519580295934!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x60184755dd586c5f%3A0xc70b1b1c88103c5b!2z44CSMjQwLTAxMDcg56We5aWI5bed55yM5qiq6aCI6LOA5biC5rmY5Y2X5Zu96Zqb5p2R77yR5LiB55uu77yS4oiS77yW!5e0!3m2!1sja!2sjp!4v1565414870367!5m2!1sja!2sjp" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>',
'https://www.img-ikyu.com/contents/dg/guide/acc0/00001290/img/a_sr_01.jpg,https://www.img-ikyu.com/contents/dg/guide/acc0/00001290/img/a_sr_02.jpg,https://www.img-ikyu.com/contents/dg/guide/acc0/00001290/img/a_sr_03.jpg,https://www.img-ikyu.com/contents/dg/guide/acc0/00001290/img/a_sr_05.jpg',
'<h2>宿紹介</h2><iframe width="1024" height="315" src="https://www.youtube.com/embed/_E3IdfCTPkw" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>'
);
