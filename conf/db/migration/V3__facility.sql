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

INSERT INTO "facility"
(
  "id", "name", "catch_copy",
  "description", "address", "location_id", "url", "cost",
  "access", "capacity", "map", "image_paths", "contents"
)
VALUES(
 1,
 'THE HOUSE on the beach',
 'ここにしかない時間が流れる至極のひととき。',
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
),
(
  2,
  'MAOIQ',
  'コンセプトは「日常の、圏外へ。」',
  'MAOIQは、北海道の長沼町にあるバケーションハウスです。
  ここには、いつもの見慣れた景色はありません。朝日の色、木や土の香り、眩しいくらいの月の光、ふと聴こえる森の声。
  季節ごとに移り変わる、ここにしかない贅沢を、MAOIQで見つけてください。
  朝、ウッドデッキでコーヒーを飲んでいると、木々がさざめく音、鳥のさえずりが聞こえてきます。
  昼、ソファに体を沈めながら、外の景色に目を向けてみてください。
  風が凪いで、溢れんばかりの陽の光が降りそそぎます。夜、遮るもののない無限の夜空が広がります。
  一瞬一瞬移り変わる光景が、MAOIQでのひとときを特別なものにしてくれます。',
  '〒069-1316 北海道 夕張郡長沼町加賀団体',
  '01100',
  'https://maoiq.jp/,50000',
  50000,
  '新千歳空港から車で35分 札幌から車で1時間15分',
  10,
  '<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d11675.494852870524!2d141.72383879254727!3d42.98093381476325!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x5f74cfdccb55a779%3A0x6a4393dd3138dad4!2z44CSMDY5LTEzMTY!5e0!3m2!1sja!2sjp!4v1565486550736!5m2!1sja!2sjp" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>',
  'https://maoiq.jp/assets/images/maoiq/maoiq_img.jpg,https://maoiq.jp/assets/images/maoiq/feature_img1.jpg',
  null
),
(
  3,
  '平泉倶楽部～FARM&RESORT～',
  '世界遺産のまち平泉町　美しい田園風景と緩やかなひとときを',
  '「平泉倶楽部～FARM&RESORT〜」は、岩手県平泉町にある1日1組様限定の一棟貸しの宿泊施設です。築150年の日本家屋を趣を残しながらも快適に過ごせるようリノベーションいたしました。
  平泉町の束稲山(たばしねやま)のふもとに広がる美しい田園風景と　緩やかな時間の移ろいのなかで心静まるひとときをお楽しみください。',
  '〒029-4101 岩手県 西磐井郡平泉町長島字前林78-1',
  '03201',
  'https://hiraizumi-club.jp/',
  100000,
  '東北自動車道「平泉前沢I.C」より県道237号線経由で10分',
  20,
  '<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3100.0927589565913!2d141.1406208161652!3d39.01319747955294!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x5f88cc27bcc042ff%3A0xcd250fd4388a0521!2z44CSMDI5LTQxMDEg5bKp5omL55yM6KW_56OQ5LqV6YOh5bmz5rOJ55S66ZW35bO25YmN5p6X77yX77yY4oiS77yR!5e0!3m2!1sja!2sjp!4v1565487495709!5m2!1sja!2sjp" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>',
  'https://hiraizumi-club.jp/wp/wp-content/uploads/2018/07/top_facility_sub01.png,https://hiraizumi-club.jp/wp/wp-content/uploads/2018/07/f_11.png',
  null
);
