comehere table 삭제 순서
1단계

admin
alert
board_file
board_tatlle
comment_tatlle
favorite_region
favorite_sport
location_review
location_review_file
member_tatlle
notice_file
party_comment
party_count
party_file
party_review_file
plan
qna
scrap
tatlle_reason

2단계

board_comment
notice
party_members
party_review
party_status

3단계

board
board_category
location
party

4단계

member
region
secq
sports


-- 관리자 
INSERT INTO `admin` (`adno`, `name`, `email`, `pwd`, `cdt`) VALUES (1, 'admin', 'admin@test.com', '0ffe1abd1a08215353c233d6e009613e95eec4253832a761af28ff37ac5a150c', '2022-10-06 00:00:00');

-- 운동 종목
INSERT INTO `sports` (`sno`, `name`) VALUES (1, '헬스');
INSERT INTO `sports` (`sno`, `name`) VALUES (2, '클라이밍');
INSERT INTO `sports` (`sno`, `name`) VALUES (3, '배드민턴');
INSERT INTO `sports` (`sno`, `name`) VALUES (4, '축구');
INSERT INTO `sports` (`sno`, `name`) VALUES (5, '농구');
INSERT INTO `sports` (`sno`, `name`) VALUES (6, '골프');
INSERT INTO `sports` (`sno`, `name`) VALUES (7, '탁구');
INSERT INTO `sports` (`sno`, `name`) VALUES (8, '야구');
INSERT INTO `sports` (`sno`, `name`) VALUES (9, '러닝');
INSERT INTO `sports` (`sno`, `name`) VALUES (10, '사이클');

-- 보안 질문
INSERT INTO `secq` (`secqno`, `sq`) VALUES (1, '내가 좋아하는 강아지 품종은?');
INSERT INTO `secq` (`secqno`, `sq`) VALUES (2, '내가 다녔던 초등학교 이름은?');
INSERT INTO `secq` (`secqno`, `sq`) VALUES (3, '나의 아버지 이름은?');
INSERT INTO `secq` (`secqno`, `sq`) VALUES (4, '내가 가장 좋아하는 취미는?');
INSERT INTO `secq` (`secqno`, `sq`) VALUES (5, '내가 태어난 곳은?');
INSERT INTO `secq` (`secqno`, `sq`) VALUES (6, '나의 첫 휴대폰 명칭은?');
INSERT INTO `secq` (`secqno`, `sq`) VALUES (7, '부모님의 취미는?');
INSERT INTO `secq` (`secqno`, `sq`) VALUES (8, '3대 중량은?');
INSERT INTO `secq` (`secqno`, `sq`) VALUES (9, '닭가슴살 평균 단백질함량은?');
INSERT INTO `secq` (`secqno`, `sq`) VALUES (10, '가장 좋아하는 선수는?');

-- 지역
INSERT INTO `region` (`rno`, `sido`, `sigu`) VALUES (1, '서울시', '종로구');
INSERT INTO `region` (`rno`, `sido`, `sigu`) VALUES (2, '서울시', '중구');
INSERT INTO `region` (`rno`, `sido`, `sigu`) VALUES (3, '서울시', '용산구');
INSERT INTO `region` (`rno`, `sido`, `sigu`) VALUES (4, '서울시', '성동구');
INSERT INTO `region` (`rno`, `sido`, `sigu`) VALUES (5, '서울시', '광진구');
INSERT INTO `region` (`rno`, `sido`, `sigu`) VALUES (6, '서울시', '동대문구');
INSERT INTO `region` (`rno`, `sido`, `sigu`) VALUES (7, '서울시', '중랑구');
INSERT INTO `region` (`rno`, `sido`, `sigu`) VALUES (8, '서울시', '성북구');
INSERT INTO `region` (`rno`, `sido`, `sigu`) VALUES (9, '서울시', '강북구');
INSERT INTO `region` (`rno`, `sido`, `sigu`) VALUES (10, '서울시', '도봉구');
INSERT INTO `region` (`rno`, `sido`, `sigu`) VALUES (11, '서울시', '노원구');
INSERT INTO `region` (`rno`, `sido`, `sigu`) VALUES (12, '서울시', '은평구');
INSERT INTO `region` (`rno`, `sido`, `sigu`) VALUES (13, '서울시', '서대문구');
INSERT INTO `region` (`rno`, `sido`, `sigu`) VALUES (14, '서울시', '마포구');
INSERT INTO `region` (`rno`, `sido`, `sigu`) VALUES (15, '서울시', '양천구');
INSERT INTO `region` (`rno`, `sido`, `sigu`) VALUES (16, '서울시', '강서구');
INSERT INTO `region` (`rno`, `sido`, `sigu`) VALUES (17, '서울시', '구로구');
INSERT INTO `region` (`rno`, `sido`, `sigu`) VALUES (18, '서울시', '금천구');
INSERT INTO `region` (`rno`, `sido`, `sigu`) VALUES (19, '서울시', '영등포구');
INSERT INTO `region` (`rno`, `sido`, `sigu`) VALUES (20, '서울시', '동작구');
INSERT INTO `region` (`rno`, `sido`, `sigu`) VALUES (21, '서울시', '관악구');
INSERT INTO `region` (`rno`, `sido`, `sigu`) VALUES (22, '서울시', '서초구');
INSERT INTO `region` (`rno`, `sido`, `sigu`) VALUES (23, '서울시', '강남구');
INSERT INTO `region` (`rno`, `sido`, `sigu`) VALUES (24, '서울시', '송파구');
INSERT INTO `region` (`rno`, `sido`, `sigu`) VALUES (25, '서울시', '강동구');

-- 회원
INSERT INTO `member` (`mno`, `name`, `email`, `pwd`, `nick`, `tel`, `bday`, `sex`, `filepath`, `cdt`, `act`, `black`, `secqno`, `sa`) VALUES (1, '이헌식', 'sik@test.com', '0ffe1abd1a08215353c233d6e009613e95eec4253832a761af28ff37ac5a150c', '흔시기', 1011112222, '1990-02-06', 0, '26920e00-03fa-400d-a287-00460213ce49', '2022-10-06 00:00:00', 0, 0, 1, '셸티');
INSERT INTO `member` (`mno`, `name`, `email`, `pwd`, `nick`, `tel`, `bday`, `sex`, `filepath`, `cdt`, `act`, `black`, `secqno`, `sa`) VALUES (2, '박병민', 'min@test.com', '0ffe1abd1a08215353c233d6e009613e95eec4253832a761af28ff37ac5a150c', '병미니', 1033334444, '1994-02-06', 0, 'e4797a10-bb17-473e-b8f1-1379804ce6c5', '2022-10-06 00:00:00', 0, 0, 1, '불독');
INSERT INTO `member` (`mno`, `name`, `email`, `pwd`, `nick`, `tel`, `bday`, `sex`, `filepath`, `cdt`, `act`, `black`, `secqno`, `sa`) VALUES (3, '임은지', 'gi@test.com', '0ffe1abd1a08215353c233d6e009613e95eec4253832a761af28ff37ac5a150c', '이문지', 1055556666, '1994-02-06', 0, '73a5722e-7dae-4b35-adc8-56640d7fde35', '2022-10-06 00:00:00', 0, 0, 1, '웰시코기');
INSERT INTO `member` (`mno`, `name`, `email`, `pwd`, `nick`, `tel`, `bday`, `sex`, `filepath`, `cdt`, `act`, `black`, `secqno`, `sa`) VALUES (4, '유제동', 'dongdong@test.com', '0ffe1abd1a08215353c233d6e009613e95eec4253832a761af28ff37ac5a150c', '동동이', 1077778888, '1995-02-06', 0, '9bed1978-2b0d-4356-8227-9ae05274a488', '2022-10-06 00:00:00', 0, 0, 1, '말티즈');
INSERT INTO `member` (`mno`, `name`, `email`, `pwd`, `nick`, `tel`, `bday`, `sex`, `filepath`, `cdt`, `act`, `black`, `secqno`, `sa`) VALUES (5, '최종찬', 'chan@test.com', '0ffe1abd1a08215353c233d6e009613e95eec4253832a761af28ff37ac5a150c', '종차니', 1099991121, '1991-02-06', 0, '4a245719-e75f-4344-8ce4-d92215260da8', '2022-10-06 00:00:00', 0, 0, 1, '치와와');
INSERT INTO `member` (`mno`, `name`, `email`, `pwd`, `nick`, `tel`, `bday`, `sex`, `filepath`, `cdt`, `act`, `black`, `secqno`, `sa`) VALUES (6, '안치운', 'an@test.com', '0ffe1abd1a08215353c233d6e009613e95eec4253832a761af28ff37ac5a150c', '치우니', 1091991121, '1997-03-06', 0, '4a245719-e75f-4344-8ce4-d92215260da8', '2022-10-06 00:00:00', 0, 0, 1, '도베르만');
INSERT INTO `member` (`mno`, `name`, `email`, `pwd`, `nick`, `tel`, `bday`, `sex`, `filepath`, `cdt`, `act`, `black`, `secqno`, `sa`) VALUES (7, '황의찬', 'eeeechan@test.com', '0ffe1abd1a08215353c233d6e009613e95eec4253832a761af28ff37ac5a150c', '의차니', 1033391121, '1997-02-11', 0, '4a245719-e75f-4344-8ce4-d92215260da8', '2022-10-06 00:00:00', 0, 0, 1, '진돗개');
INSERT INTO `member` (`mno`, `name`, `email`, `pwd`, `nick`, `tel`, `bday`, `sex`, `filepath`, `cdt`, `act`, `black`, `secqno`, `sa`) VALUES (8, '주 영', ' joo@test.com', '0ffe1abd1a08215353c233d6e009613e95eec4253832a761af28ff37ac5a150c', '영이', 1098891121, '1991-02-06', 0, '4a245719-e75f-4344-8ce4-d92215260da8', '2022-10-06 00:00:00', 0, 0, 1, '슈바우쳐');
INSERT INTO `member` (`mno`, `name`, `email`, `pwd`, `nick`, `tel`, `bday`, `sex`, `filepath`, `cdt`, `act`, `black`, `secqno`, `sa`) VALUES (9, '임동현', 'lim@test.com', '0ffe1abd1a08215353c233d6e009613e95eec4253832a761af28ff37ac5a150c', '림동', 1022991121, '1990-03-06', 0, '4a245719-e75f-4344-8ce4-d92215260da8', '2022-10-06 00:00:00', 0, 0, 1, '푸들');
INSERT INTO `member` (`mno`, `name`, `email`, `pwd`, `nick`, `tel`, `bday`, `sex`, `filepath`, `cdt`, `act`, `black`, `secqno`, `sa`) VALUES (10, '장슬기', 'sulgi@test.com', '0ffe1abd1a08215353c233d6e009613e95eec4253832a761af28ff37ac5a150c', '스기', 1099891121, '1990-06-06', 0, '4a245719-e75f-4344-8ce4-d92215260da8', '2022-10-06 00:00:00', 0, 0, 1, '포메');

-- 장소
INSERT INTO `location` (`lno`, `rno`, `sno`) VALUES (1, 1, 1);
INSERT INTO `location` (`lno`, `rno`, `sno`) VALUES (2, 2, 2);
INSERT INTO `location` (`lno`, `rno`, `sno`) VALUES (3, 3, 3);
INSERT INTO `location` (`lno`, `rno`, `sno`) VALUES (4, 4, 4);
INSERT INTO `location` (`lno`, `rno`, `sno`) VALUES (5, 5, 5);
INSERT INTO `location` (`lno`, `rno`, `sno`) VALUES (6, 6, 6);
INSERT INTO `location` (`lno`, `rno`, `sno`) VALUES (7, 7, 7);
INSERT INTO `location` (`lno`, `rno`, `sno`) VALUES (8, 8, 8);
INSERT INTO `location` (`lno`, `rno`, `sno`) VALUES (9, 9, 9);
INSERT INTO `location` (`lno`, `rno`, `sno`) VALUES (10, 10, 10);

-- 모임
INSERT INTO `party` (`pno`, `sno`, `lno`, `title`, `act`, `cont`, `cdt`, `headcnt`, `ptime`, `pdate`) VALUES (1, 1, 1, '파티원모집함', 1, '3대측정할 파티원모집함', '2022-10-06 00:00:00', 5, '17:00:00', '2022-10-06');
INSERT INTO `party` (`pno`, `sno`, `lno`, `title`, `act`, `cont`, `cdt`, `headcnt`, `ptime`, `pdate`) VALUES (2, 2, 2, '클라이밍가실분', 1, '망포 동동이클라이밍장 좋아요 커몬요!', '2022-10-06 00:00:00', 5, '10:00:00', '2022-10-06');
INSERT INTO `party` (`pno`, `sno`, `lno`, `title`, `act`, `cont`, `cdt`, `headcnt`, `ptime`, `pdate`) VALUES (3, 3, 3, '배드민턴 치실분?', 1, '동탄호수공원에서 쳐요!', '2022-10-06 00:00:00', 5, '18:00:00', '2022-10-06');
INSERT INTO `party` (`pno`, `sno`, `lno`, `title`, `act`, `cont`, `cdt`, `headcnt`, `ptime`, `pdate`) VALUES (4, 4, 4, '축구하십시더! ', 1, '24명 구해봐요!', '2022-10-06 00:00:00', 5, '17:00:00', '2022-10-06');
INSERT INTO `party` (`pno`, `sno`, `lno`, `title`, `act`, `cont`, `cdt`, `headcnt`, `ptime`, `pdate`) VALUES (5, 5, 5, '농구 고고', 1, '신나게 달려보시져 ', '2022-10-06 00:00:00', 5, '17:00:00', '2022-10-06');

-- 게시판 카테고리
INSERT INTO `board_category` (`bcno`, `name`) VALUES (1, '자유게시판');
INSERT INTO `board_category` (`bcno`, `name`) VALUES (2, '식단');
INSERT INTO `board_category` (`bcno`, `name`) VALUES (3, '챌린지');
INSERT INTO `board_category` (`bcno`, `name`) VALUES (4, 'Q&A');
INSERT INTO `board_category` (`bcno`, `name`) VALUES (5, '핫딜게시판');

-- 게시글
INSERT INTO `board` (`bno`, `bcno`, `mno`, `title`, `act`, `private`, `cont`, `cdt`, `vw_cnt`) VALUES (1, 1, 4, '유제동', 1, 1, '두두제동', '2022-10-11 18:12:39', 0);
INSERT INTO `board` (`bno`, `bcno`, `mno`, `title`, `act`, `private`, `cont`, `cdt`, `vw_cnt`) VALUES (2, 2, 5, '너무 싫어', 1, 1, '닭가슴살 토나와', '2022-10-11 18:12:39', 0);
INSERT INTO `board` (`bno`, `bcno`, `mno`, `title`, `act`, `private`, `cont`, `cdt`, `vw_cnt`) VALUES (3, 3, 2, '집에 가고싶다', 1, 1, '스쿼트 400개 할때 까지 집 안 감;', '2022-10-11 18:12:39', 0);
INSERT INTO `board` (`bno`, `bcno`, `mno`, `title`, `act`, `private`, `cont`, `cdt`, `vw_cnt`) VALUES (4, 4, 3, '나는 쌔삥', 1, 1, '모든 게 다 쌔삥 다음에 가사 뭐임?', '2022-10-11 18:12:39', 0);
INSERT INTO `board` (`bno`, `bcno`, `mno`, `title`, `act`, `private`, `cont`, `cdt`, `vw_cnt`) VALUES (5, 5, 1, '프로틴 쉐이크 특가', 1, 1, '프로틴 쉐이크 특가 중', '2022-10-11 18:12:39', 0);
INSERT INTO `board` (`bno`, `bcno`, `mno`, `title`, `act`, `private`, `cont`, `cdt`, `vw_cnt`) VALUES (6, 1, 4, '우리집 고양이 봐봐라', 1, 1, '미쳤다 엄청 귀엽다', '2022-10-11 18:34:34', 0);
INSERT INTO `board` (`bno`, `bcno`, `mno`, `title`, `act`, `private`, `cont`, `cdt`, `vw_cnt`) VALUES (7, 2, 5, '저염식 먹으라고 하는 이유', 1, 1, '염분이 지방을 잡고 안 놔주기 때문', '2022-10-11 18:34:34', 0);
INSERT INTO `board` (`bno`, `bcno`, `mno`, `title`, `act`, `private`, `cont`, `cdt`, `vw_cnt`) VALUES (8, 3, 1, '70일차 몸 상태 변화', 1, 1, '제곧내', '2022-10-11 18:34:34', 0);
INSERT INTO `board` (`bno`, `bcno`, `mno`, `title`, `act`, `private`, `cont`, `cdt`, `vw_cnt`) VALUES (9, 4, 2, '쌈장먹을 때', 1, 1, '쌈장 왜 찍어먹지 말래?', '2022-10-11 18:34:34', 0);
INSERT INTO `board` (`bno`, `bcno`, `mno`, `title`, `act`, `private`, `cont`, `cdt`, `vw_cnt`) VALUES (10, 5, 3, '테니스 라켓 할인', 1, 1, '삼성카드 특별 할인', '2022-10-11 18:34:35', 0);

-- 알림
INSERT INTO `alert` (`alno`, `mno`, `cont`, `aldt`, `alcheck`) VALUES (1, 1, '모임장으로 부터 댓글이 달렸어요!', '2022-10-06 00:00:00', 1);
INSERT INTO `alert` (`alno`, `mno`, `cont`, `aldt`, `alcheck`) VALUES (2, 2, '클라이밍 모임이 승인이 완료되었습니다.', '2022-10-06 00:00:00', 1);
INSERT INTO `alert` (`alno`, `mno`, `cont`, `aldt`, `alcheck`) VALUES (3, 3, '다른 사용자가 다음 댓글에 댓글을 달았습니다.', '2022-10-06 00:00:00', 1);
INSERT INTO `alert` (`alno`, `mno`, `cont`, `aldt`, `alcheck`) VALUES (4, 4, '3대 무게 .... 답글이 달렸습니다.', '2022-10-06 00:00:00', 1);
INSERT INTO `alert` (`alno`, `mno`, `cont`, `aldt`, `alcheck`) VALUES (5, 5, '농구모임이 거절 되었습니다.\n', '2022-10-06 00:00:00', 1);
INSERT INTO `alert` (`alno`, `mno`, `cont`, `aldt`, `alcheck`) VALUES (6, 6, '배고파요...답글이 달렸습니다.', '2022-10-06 00:00:00', 1);
INSERT INTO `alert` (`alno`, `mno`, `cont`, `aldt`, `alcheck`) VALUES (7, 7, '관리자 댓글이 달렸어요.', '2022-10-06 00:00:00', 1);
INSERT INTO `alert` (`alno`, `mno`, `cont`, `aldt`, `alcheck`) VALUES (8, 8, '추천식단은....댓글이 달렸습니다.', '2022-10-06 00:00:00', 1);
INSERT INTO `alert` (`alno`, `mno`, `cont`, `aldt`, `alcheck`) VALUES (9, 9, '배고파요...답글이 달렸습니다.', '2022-10-06 00:00:00', 1);
INSERT INTO `alert` (`alno`, `mno`, `cont`, `aldt`, `alcheck`) VALUES (10, 10, '농구모임이 거절 되었습니다.', '2022-10-06 00:00:00', 1);

-- 게시글 첨부파일
INSERT INTO `board_file` (`bfno`, `filepath`, `bno`) VALUES (1, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 1);
INSERT INTO `board_file` (`bfno`, `filepath`, `bno`) VALUES (2, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 2);
INSERT INTO `board_file` (`bfno`, `filepath`, `bno`) VALUES (3, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 3);
INSERT INTO `board_file` (`bfno`, `filepath`, `bno`) VALUES (4, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 4);
INSERT INTO `board_file` (`bfno`, `filepath`, `bno`) VALUES (5, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 5);


-- 게시글 댓글
INSERT INTO `board_comment` (`bcno`, `bno`, `mno`, `cont`, `act`, `cdt`) VALUES (1, 1, 5, '내공냠냠 11', 0, '2022-10-11 18:12:39');
INSERT INTO `board_comment` (`bcno`, `bno`, `mno`, `cont`, `act`, `cdt`) VALUES (2, 2, 2, '나는 좋아용 ', 0, '2022-10-11 18:12:39');
INSERT INTO `board_comment` (`bcno`, `bno`, `mno`, `cont`, `act`, `cdt`) VALUES (3, 3, 3, '운동하고 싶당 ', 0, '2022-10-11 18:12:39');
INSERT INTO `board_comment` (`bcno`, `bno`, `mno`, `cont`, `act`, `cdt`) VALUES (4, 3, 4, '400개 어캐 다함 ㄷㄷ ', 0, '2022-10-11 18:12:39');
INSERT INTO `board_comment` (`bcno`, `bno`, `mno`, `cont`, `act`, `cdt`) VALUES (5, 1, 3, '두두두두제동', 0, '2022-10-11 18:12:39');
INSERT INTO `board_comment` (`bcno`, `bno`, `mno`, `cont`, `act`, `cdt`) VALUES (6, 5, 4, '근데 댓글 이렇게 하는 거 맞아요?', 0, '2022-10-11 18:12:39');
INSERT INTO `board_comment` (`bcno`, `bno`, `mno`, `cont`, `act`, `cdt`) VALUES (7, 4, 2, '댓글 내가 처음이다', 0, '2022-10-11 18:12:39');
INSERT INTO `board_comment` (`bcno`, `bno`, `mno`, `cont`, `act`, `cdt`) VALUES (8, 4, 1, '내가 두 번째!!!!', 0, '2022-10-11 18:12:39');
INSERT INTO `board_comment` (`bcno`, `bno`, `mno`, `cont`, `act`, `cdt`) VALUES (9, 3, 2, '광고 문의 카톡:eomcs', 0, '2022-10-11 18:12:39');
INSERT INTO `board_comment` (`bcno`, `bno`, `mno`, `cont`, `act`, `cdt`) VALUES (10, 4, 3, '게시글 내용 더 없어요? ', 0, '2022-10-11 18:12:39');
INSERT INTO `board_comment` (`bcno`, `bno`, `mno`, `cont`, `act`, `cdt`) VALUES (11, 6, 2, '고양이 사진 10장 채우셔야 합니다.', 0, '2022-10-11 18:20:43');
INSERT INTO `board_comment` (`bcno`, `bno`, `mno`, `cont`, `act`, `cdt`) VALUES (12, 8, 1, '피드백 환영입니다 ^^', 0, '2022-10-11 18:21:01');
INSERT INTO `board_comment` (`bcno`, `bno`, `mno`, `cont`, `act`, `cdt`) VALUES (13, 8, 2, '멋지네요 ^_^ b', 0, '2022-10-11 18:21:58');
INSERT INTO `board_comment` (`bcno`, `bno`, `mno`, `cont`, `act`, `cdt`) VALUES (14, 8, 5, '빡시게 하시는 듯 ㄷㄷㄷㄷㄷ 어떻게 운동 하셨어요?', 0, '2022-10-11 18:25:54');
INSERT INTO `board_comment` (`bcno`, `bno`, `mno`, `cont`, `act`, `cdt`) VALUES (15, 8, 1, '헬스장 + 홈트 계속 했어요!', 0, '2022-10-11 18:28:34');
INSERT INTO `board_comment` (`bcno`, `bno`, `mno`, `cont`, `act`, `cdt`) VALUES (16, 9, 3, '누가 쌈장 찍어 먹지 말라함? 맛알못이네', 0, '2022-10-11 18:29:01');
INSERT INTO `board_comment` (`bcno`, `bno`, `mno`, `cont`, `act`, `cdt`) VALUES (17, 9, 2, '어머니께서 쌈장 찍어먹으면 살찐다고 먹지 말라던데', 0, '2022-10-11 18:29:54');
INSERT INTO `board_comment` (`bcno`, `bno`, `mno`, `cont`, `act`, `cdt`) VALUES (18, 9, 3, '맛... 있는걸 알고 계시고 못하는게 없으신듯 ^^', 0, '2022-10-11 18:35:47');
INSERT INTO `board_comment` (`bcno`, `bno`, `mno`, `cont`, `act`, `cdt`) VALUES (19, 10, 4, '광고아님?', 0, '2022-10-11 18:37:22');

-- 관심지역
INSERT INTO `favorite_region` (`rno`, `mno`) VALUES (4, 2);
INSERT INTO `favorite_region` (`rno`, `mno`) VALUES (5, 4);
INSERT INTO `favorite_region` (`rno`, `mno`) VALUES (6, 2);
INSERT INTO `favorite_region` (`rno`, `mno`) VALUES (7, 5);
INSERT INTO `favorite_region` (`rno`, `mno`) VALUES (12, 1);
INSERT INTO `favorite_region` (`rno`, `mno`) VALUES (13, 3);
INSERT INTO `favorite_region` (`rno`, `mno`) VALUES (20, 4);
INSERT INTO `favorite_region` (`rno`, `mno`) VALUES (21, 5);
INSERT INTO `favorite_region` (`rno`, `mno`) VALUES (25, 1);
INSERT INTO `favorite_region` (`rno`, `mno`) VALUES (25, 3);

-- 관심운동
INSERT INTO `favorite_sport` (`sno`, `mno`) VALUES (1, 3);
INSERT INTO `favorite_sport` (`sno`, `mno`) VALUES (1, 5);
INSERT INTO `favorite_sport` (`sno`, `mno`) VALUES (2, 1);
INSERT INTO `favorite_sport` (`sno`, `mno`) VALUES (2, 4);
INSERT INTO `favorite_sport` (`sno`, `mno`) VALUES (3, 2);
INSERT INTO `favorite_sport` (`sno`, `mno`) VALUES (3, 4);
INSERT INTO `favorite_sport` (`sno`, `mno`) VALUES (4, 2);
INSERT INTO `favorite_sport` (`sno`, `mno`) VALUES (4, 3);
INSERT INTO `favorite_sport` (`sno`, `mno`) VALUES (5, 1);
INSERT INTO `favorite_sport` (`sno`, `mno`) VALUES (5, 5);

-- 모임
INSERT INTO `party` (`pno`, `sno`, `lno`, `title`, `act`, `cont`, `cdt`, `headcnt`, `ptime`, `pdate`) VALUES (1, 1, 1, '파티원모집함', 1, '3대측정할 파티원모집함', '2022-10-06 00:00:00', 5, '17:00:00', '2022-10-06');
INSERT INTO `party` (`pno`, `sno`, `lno`, `title`, `act`, `cont`, `cdt`, `headcnt`, `ptime`, `pdate`) VALUES (2, 2, 2, '클라이밍가실분', 1, '망포 동동이클라이밍장 좋아요 커몬요!', '2022-10-06 00:00:00', 5, '10:00:00', '2022-10-06');
INSERT INTO `party` (`pno`, `sno`, `lno`, `title`, `act`, `cont`, `cdt`, `headcnt`, `ptime`, `pdate`) VALUES (3, 3, 3, '배드민턴 치실분?', 1, '동탄호수공원에서 쳐요!', '2022-10-06 00:00:00', 5, '18:00:00', '2022-10-06');
INSERT INTO `party` (`pno`, `sno`, `lno`, `title`, `act`, `cont`, `cdt`, `headcnt`, `ptime`, `pdate`) VALUES (4, 4, 4, '축구하십시더! ', 1, '24명 구해봐요!', '2022-10-06 00:00:00', 5, '17:00:00', '2022-10-06');
INSERT INTO `party` (`pno`, `sno`, `lno`, `title`, `act`, `cont`, `cdt`, `headcnt`, `ptime`, `pdate`) VALUES (5, 5, 5, '농구 고고', 1, '신나게 달려보시져 ', '2022-10-06 00:00:00', 5, '17:00:00', '2022-10-06');


-- 모임 참여 상태
INSERT INTO `party_status` (`psno`, `status`) VALUES (1, '대기');
INSERT INTO `party_status` (`psno`, `status`) VALUES (2, '승인');
INSERT INTO `party_status` (`psno`, `status`) VALUES (3, '거절');
INSERT INTO `party_status` (`psno`, `status`) VALUES (4, '탈퇴');


-- 모임 댓글
INSERT INTO `party_comment` (`pcno`, `mno`, `pno`, `cont`, `cdt`) VALUES (1, 1, 2, '참여하고싶어요!', '2022-10-06 00:00:00');
INSERT INTO `party_comment` (`pcno`, `mno`, `pno`, `cont`, `cdt`) VALUES (2, 2, 3, '같이합시다!!', '2022-10-06 00:00:00');
INSERT INTO `party_comment` (`pcno`, `mno`, `pno`, `cont`, `cdt`) VALUES (3, 3, 4, '혹시 고인물들 많나요?!', '2022-10-06 00:00:00');
INSERT INTO `party_comment` (`pcno`, `mno`, `pno`, `cont`, `cdt`) VALUES (4, 4, 5, '와 정말 흥미로워요!', '2022-10-06 00:00:00');
INSERT INTO `party_comment` (`pcno`, `mno`, `pno`, `cont`, `cdt`) VALUES (5, 5, 1, '지금 당장 신청합니다!', '2022-10-06 00:00:00');
INSERT INTO `party_comment` (`pcno`, `mno`, `pno`, `cont`, `cdt`) VALUES (6, 1, 3, '와 참여해야겠네요', '2022-10-06 00:00:00');
INSERT INTO `party_comment` (`pcno`, `mno`, `pno`, `cont`, `cdt`) VALUES (7, 1, 4, '아 고민이 되내요 지역은 가까운데', '2022-10-06 00:00:00');
INSERT INTO `party_comment` (`pcno`, `mno`, `pno`, `cont`, `cdt`) VALUES (8, 3, 5, '시간이 안맞네요 ㅜㅜ 시간 맞을때 신청할게요', '2022-10-06 00:00:00');
INSERT INTO `party_comment` (`pcno`, `mno`, `pno`, `cont`, `cdt`) VALUES (9, 4, 1, '초보도 가능한가요', '2022-10-06 00:00:00');
INSERT INTO `party_comment` (`pcno`, `mno`, `pno`, `cont`, `cdt`) VALUES (10, 5, 1, '처음해보는데 신청가능한가요', '2022-10-06 00:00:00');

-- 모임 첨부파일
INSERT INTO `party_file` (`pfno`, `filepath`, `pno`) VALUES (1, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 1);
INSERT INTO `party_file` (`pfno`, `filepath`, `pno`) VALUES (2, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 1);
INSERT INTO `party_file` (`pfno`, `filepath`, `pno`) VALUES (3, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 3);
INSERT INTO `party_file` (`pfno`, `filepath`, `pno`) VALUES (4, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 4);
INSERT INTO `party_file` (`pfno`, `filepath`, `pno`) VALUES (5, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 5);
INSERT INTO `party_file` (`pfno`, `filepath`, `pno`) VALUES (6, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 1);
INSERT INTO `party_file` (`pfno`, `filepath`, `pno`) VALUES (7, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 4);
INSERT INTO `party_file` (`pfno`, `filepath`, `pno`) VALUES (8, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 3);
INSERT INTO `party_file` (`pfno`, `filepath`, `pno`) VALUES (9, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 5);
INSERT INTO `party_file` (`pfno`, `filepath`, `pno`) VALUES (10, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 5);

-- 모임 참여 명단
INSERT INTO `party_members` (`mno`, `pno`, `psno`, `auth`) VALUES (1, 1, 2, 0);
INSERT INTO `party_members` (`mno`, `pno`, `psno`, `auth`) VALUES (1, 2, 3, 1);
INSERT INTO `party_members` (`mno`, `pno`, `psno`, `auth`) VALUES (2, 2, 2, 0);
INSERT INTO `party_members` (`mno`, `pno`, `psno`, `auth`) VALUES (2, 3, 1, 1);
INSERT INTO `party_members` (`mno`, `pno`, `psno`, `auth`) VALUES (3, 3, 2, 0);
INSERT INTO `party_members` (`mno`, `pno`, `psno`, `auth`) VALUES (3, 4, 4, 0);
INSERT INTO `party_members` (`mno`, `pno`, `psno`, `auth`) VALUES (4, 4, 2, 0);
INSERT INTO `party_members` (`mno`, `pno`, `psno`, `auth`) VALUES (4, 5, 3, 1);
INSERT INTO `party_members` (`mno`, `pno`, `psno`, `auth`) VALUES (5, 1, 2, 1);
INSERT INTO `party_members` (`mno`, `pno`, `psno`, `auth`) VALUES (5, 5, 2, 0);

-- 모임 후기
INSERT INTO `party_review` (`prno`, `mno`, `pno`, `star`, `title`, `cont`, `cdt`) VALUES (1, 1, 1, 5.00, '3대 치고 왔습니다', '벤치 100 스쿼트 120 대드 140 했습니다 얼른 3대 400 찍고싶네요', '2022-10-11 18:12:39');
INSERT INTO `party_review` (`prno`, `mno`, `pno`, `star`, `title`, `cont`, `cdt`) VALUES (2, 2, 2, 4.00, '병미파티 망포 클라이밍 장 다녀왔습니다', '안전 장치도 잘 되어 있고 좋네요', '2022-10-11 18:12:39');
INSERT INTO `party_review` (`prno`, `mno`, `pno`, `star`, `title`, `cont`, `cdt`) VALUES (3, 3, 3, 5.00, '전직 국대와 경기하니 좋네요', '모임장님이 전 국대셔서 라켓 잡는 법까지 세세하게 알려주셔서 좋았습니다', '2022-10-11 18:12:39');
INSERT INTO `party_review` (`prno`, `mno`, `pno`, `star`, `title`, `cont`, `cdt`) VALUES (4, 4, 4, 3.00, '조기축구 결성', '여러번 해봤는데 마음이 잘 맞아서 매주 조기축구 하기로 했습니다 ^^', '2022-10-11 18:12:39');
INSERT INTO `party_review` (`prno`, `mno`, `pno`, `star`, `title`, `cont`, `cdt`) VALUES (5, 5, 5, 2.00, '좋습니다', '좋아요', '2022-10-11 18:12:39');
INSERT INTO `party_review` (`prno`, `mno`, `pno`, `star`, `title`, `cont`, `cdt`) VALUES (6, 1, 2, 5.00, '보디빌더 모임 굿', '보디빌더 준비 중인데 같은 마음으로 모인 분들이여서 좋은 꿀팁 많이 얻고 갑니다', '2022-10-11 18:48:33');
INSERT INTO `party_review` (`prno`, `mno`, `pno`, `star`, `title`, `cont`, `cdt`) VALUES (7, 2, 3, 1.00, '저는 개인적으로 별로네요', '안전 장치가 허술한 것 같아 하마터면 다칠뻔 했어요', '2022-10-11 18:48:33');
INSERT INTO `party_review` (`prno`, `mno`, `pno`, `star`, `title`, `cont`, `cdt`) VALUES (8, 3, 4, 5.00, '한강에서 함께 즐기는 배드민턴', '저는 야광 콕이 있는지 처음 알았네요 좋은 정보 얻어갑니다', '2022-10-11 18:48:33');
INSERT INTO `party_review` (`prno`, `mno`, `pno`, `star`, `title`, `cont`, `cdt`) VALUES (9, 4, 5, 5.00, '아이들과 함께 할 수 있어서 좋아요', '또래 아이들과 흙 묻히며 노는 기회가 흔하지 않은데 정말 좋았습니다', '2022-10-11 18:48:33');
INSERT INTO `party_review` (`prno`, `mno`, `pno`, `star`, `title`, `cont`, `cdt`) VALUES (10, 5, 1, 1.00, '별로네요', '처음부터 끝까지 전부 다 별로라서 1점도 아깝네요', '2022-10-11 18:48:33');

-- 모임 리뷰 첨부파일
INSERT INTO `party_review_file` (`prfno`, `filepath`, `prno`) VALUES (1, '/Users/parkbyeongmin/git/teamproject-comehere/comehere-app/comehere-server/doc/comehere_party_review_file 1.jpeg', 1);
INSERT INTO `party_review_file` (`prfno`, `filepath`, `prno`) VALUES (2, '/Users/parkbyeongmin/git/teamproject-comehere/comehere-app/comehere-server/doc/comehere_party_review_file 2.jpeg', 3);
INSERT INTO `party_review_file` (`prfno`, `filepath`, `prno`) VALUES (3, '/Users/parkbyeongmin/git/teamproject-comehere/comehere-app/comehere-server/doc/comehere_party_review_file 3.jpeg', 3);
INSERT INTO `party_review_file` (`prfno`, `filepath`, `prno`) VALUES (4, '/Users/parkbyeongmin/git/teamproject-comehere/comehere-app/comehere-server/doc/comehere_party_review_file 4.jpeg', 4);
INSERT INTO `party_review_file` (`prfno`, `filepath`, `prno`) VALUES (5, '/Users/parkbyeongmin/git/teamproject-comehere/comehere-app/comehere-server/doc/comehere_party_review_file 5.jpeg', 5);
INSERT INTO `party_review_file` (`prfno`, `filepath`, `prno`) VALUES (6, '/Users/parkbyeongmin/git/teamproject-comehere/comehere-app/comehere-server/doc/comehere_party_review_file 6.jpeg', 4);

-- 목표
INSERT INTO `plan` (`plno`, `mno`, `title`, `act`, `dday`, `chl`) VALUES (1, 1, '근성장', 1, '2022-10-26', 40.50);
INSERT INTO `plan` (`plno`, `mno`, `title`, `act`, `dday`, `chl`) VALUES (2, 2, '살크업', 0, '2021-01-21', 71.00);
INSERT INTO `plan` (`plno`, `mno`, `title`, `act`, `dday`, `chl`) VALUES (3, 3, '다이어트', 0, '2022-12-31', 49.90);
INSERT INTO `plan` (`plno`, `mno`, `title`, `act`, `dday`, `chl`) VALUES (4, 2, '득근하기', 0, '2023-01-01', 25.76);
INSERT INTO `plan` (`plno`, `mno`, `title`, `act`, `dday`, `chl`) VALUES (5, 5, '체중조절', 0, '2022-11-28', 73.50);
INSERT INTO `plan` (`plno`, `mno`, `title`, `act`, `dday`, `chl`) VALUES (6, 1, '근성장(2차)', 0, '2022-12-22', 45.00);

-- 1:1 문의하기
INSERT INTO `qna` (`qno`, `mno`, `title`, `act`, `cont`, `cdt`, `acont`, `adt`) VALUES (1, 1, '이용 문의 드려요', 0, '모임 설정하는데 지역 설정을 하나만 할 수 있나요?', '2022-10-11 18:12:39', NULL, NULL);
INSERT INTO `qna` (`qno`, `mno`, `title`, `act`, `cont`, `cdt`, `acont`, `adt`) VALUES (2, 3, '탈퇴하면 정보 다 사라지나요?', 1, '탈퇴하려 하는데 탈퇴하면 제가 쓴 글이나 정보 다 사라지나요? 아니면 남아있나요? ', '2022-10-11 18:12:39', '안녕하세요? 여기모여 관리자입니다.\n\n탈퇴 시 회원정보는 삭제되지만 활동내용(게시글, 댓글) 등은 삭제처리가 되지 않습니다.\n\n삭제가 필요한 경우 회원탈퇴 전 개별적으로 삭제 후 회원탈퇴를 진행하시길 바랍니다.\n\n감사합니다.', '2022-10-11 19:10:22');
INSERT INTO `qna` (`qno`, `mno`, `title`, `act`, `cont`, `cdt`, `acont`, `adt`) VALUES (3, 3, '고객센터 번호 알려주세요', 0, '고객센터 번호랑 이용시간 좀 알려주세요 직접 전화해서 물어보게', '2022-10-11 18:12:39', NULL, NULL);
INSERT INTO `qna` (`qno`, `mno`, `title`, `act`, `cont`, `cdt`, `acont`, `adt`) VALUES (4, 4, '이용 문의 드립니다', 1, '게시글 스크랩 어디로 가야 볼 수 있나요?', '2022-10-11 18:12:39', '안녕하세요? 여기모여 관리자입니다.\n\n문의하신 스크랩 내용 보기는 \'마이페이지\'-\'작성글/스크랩\'을 보시면 확인 가능합니다.\n\n감사합니다.', '2022-10-11 19:01:33');
INSERT INTO `qna` (`qno`, `mno`, `title`, `act`, `cont`, `cdt`, `acont`, `adt`) VALUES (5, 5, '저기요', 0, '이거 직접 관리자가 답변해줘요? 아님 컴퓨터 자동 답변이에요?', '2022-10-11 18:12:39', NULL, NULL);
INSERT INTO `qna` (`qno`, `mno`, `title`, `act`, `cont`, `cdt`, `acont`, `adt`) VALUES (6, 3, '탈퇴시 정보가 남아있다는데', 0, '그러면 문의넣으면 제가 하나하나 안 지워도 대신 지워주실 수 있나요?', '2022-10-11 19:00:23', NULL, NULL);
INSERT INTO `qna` (`qno`, `mno`, `title`, `act`, `cont`, `cdt`, `acont`, `adt`) VALUES (7, 5, '바로 답장 안 오는데 그럼 사람이 하는거에요?', 0, '아니면 컴퓨터가 답장하는데 시간이 걸리는거에요?', '2022-10-11 19:16:23', NULL, NULL);

-- 스크랩
INSERT INTO `scrap` (`mno`, `bno`) VALUES (1, 1);
INSERT INTO `scrap` (`mno`, `bno`) VALUES (3, 2);
INSERT INTO `scrap` (`mno`, `bno`) VALUES (3, 3);
INSERT INTO `scrap` (`mno`, `bno`) VALUES (3, 5);
INSERT INTO `scrap` (`mno`, `bno`) VALUES (3, 6);
INSERT INTO `scrap` (`mno`, `bno`) VALUES (3, 7);
INSERT INTO `scrap` (`mno`, `bno`) VALUES (3, 8);
INSERT INTO `scrap` (`mno`, `bno`) VALUES (4, 5);
INSERT INTO `scrap` (`mno`, `bno`) VALUES (4, 8);
INSERT INTO `scrap` (`mno`, `bno`) VALUES (5, 1);
INSERT INTO `scrap` (`mno`, `bno`) VALUES (5, 2);
INSERT INTO `scrap` (`mno`, `bno`) VALUES (5, 4);

-- 신고 사유
INSERT INTO `tatlle_reason` (`trno`, `reason`) VALUES (1, '불건전한 내용');
INSERT INTO `tatlle_reason` (`trno`, `reason`) VALUES (2, '스팸 및 부적절한 홍보');
INSERT INTO `tatlle_reason` (`trno`, `reason`) VALUES (3, '명예회손 및 비방');
INSERT INTO `tatlle_reason` (`trno`, `reason`) VALUES (4, '초상권 및 저작권 침해');
INSERT INTO `tatlle_reason` (`trno`, `reason`) VALUES (5, '개인정보 도용');
INSERT INTO `tatlle_reason` (`trno`, `reason`) VALUES (6, '기타 사이트 목적에 맞지 않는 행위');

-- 게시글 신고
INSERT INTO `board_tatlle` (`btno`, `mno`, `decbno`, `trno`, `tdt`, `cont`, `comdt`) VALUES (1, 3, 1, 1, '2022-10-07 00:00:00', '블랙처리 됐습니다', '2022-10-07 19:09:04');
INSERT INTO `board_tatlle` (`btno`, `mno`, `decbno`, `trno`, `tdt`, `cont`, `comdt`) VALUES (2, 4, 2, 2, '2022-10-07 00:00:00', '블랙처리 됐습니다', '2022-10-07 19:09:04');
INSERT INTO `board_tatlle` (`btno`, `mno`, `decbno`, `trno`, `tdt`, `cont`, `comdt`) VALUES (3, 2, 3, 3, '2022-10-07 00:00:00', '블랙처리 됐습니다', '2022-10-07 19:09:04');
INSERT INTO `board_tatlle` (`btno`, `mno`, `decbno`, `trno`, `tdt`, `cont`, `comdt`) VALUES (4, 5, 4, 4, '2022-10-07 00:00:00', '블랙처리 됐습니다', '2022-10-07 19:09:04');
INSERT INTO `board_tatlle` (`btno`, `mno`, `decbno`, `trno`, `tdt`, `cont`, `comdt`) VALUES (5, 1, 5, 5, '2022-10-07 00:00:00', '블랙처리 됐습니다', '2022-10-07 19:09:04');
INSERT INTO `board_tatlle` (`btno`, `mno`, `decbno`, `trno`, `tdt`, `cont`, `comdt`) VALUES (6, 1, 2, 1, '2022-10-07 19:09:04', '', NULL);
INSERT INTO `board_tatlle` (`btno`, `mno`, `decbno`, `trno`, `tdt`, `cont`, `comdt`) VALUES (7, 2, 3, 2, '2022-10-07 19:09:04', '', NULL);
INSERT INTO `board_tatlle` (`btno`, `mno`, `decbno`, `trno`, `tdt`, `cont`, `comdt`) VALUES (8, 3, 4, 3, '2022-10-07 19:09:04', '승인되지 않았습니다.', '2022-10-07 19:09:04');
INSERT INTO `board_tatlle` (`btno`, `mno`, `decbno`, `trno`, `tdt`, `cont`, `comdt`) VALUES (9, 4, 5, 4, '2022-10-07 19:09:04', '승인되지 않았습니다.', '2022-10-07 19:09:04');


-- 댓글 신고
INSERT INTO `comment_tatlle` (`ctno`, `mno`, `bcno`, `trno`, `tdt`, `cont`, `comdt`) VALUES (1, 1, 1, 1, '2022-10-06 19:01:04', '블랙처리 됐습니다', '2022-10-07 19:09:04');
INSERT INTO `comment_tatlle` (`ctno`, `mno`, `bcno`, `trno`, `tdt`, `cont`, `comdt`) VALUES (2, 2, 2, 2, '2022-10-06 19:01:04', '블랙처리 됐습니다', '2022-10-07 19:09:04');
INSERT INTO `comment_tatlle` (`ctno`, `mno`, `bcno`, `trno`, `tdt`, `cont`, `comdt`) VALUES (3, 3, 3, 3, '2022-10-06 19:01:04', '블랙처리 됐습니다', '2022-10-07 19:09:04');
INSERT INTO `comment_tatlle` (`ctno`, `mno`, `bcno`, `trno`, `tdt`, `cont`, `comdt`) VALUES (4, 4, 4, 4, '2022-10-06 19:01:04', '블랙처리 됐습니다', '2022-10-07 19:09:04');
INSERT INTO `comment_tatlle` (`ctno`, `mno`, `bcno`, `trno`, `tdt`, `cont`, `comdt`) VALUES (5, 5, 5, 5, '2022-10-06 19:01:04', '블랙처리 됐습니다', '2022-10-07 19:09:04');
INSERT INTO `comment_tatlle` (`ctno`, `mno`, `bcno`, `trno`, `tdt`, `cont`, `comdt`) VALUES (6, 1, 2, 1, '2022-10-07 19:09:04', '', NULL);
INSERT INTO `comment_tatlle` (`ctno`, `mno`, `bcno`, `trno`, `tdt`, `cont`, `comdt`) VALUES (7, 2, 3, 2, '2022-10-07 19:09:04', '', NULL);
INSERT INTO `comment_tatlle` (`ctno`, `mno`, `bcno`, `trno`, `tdt`, `cont`, `comdt`) VALUES (8, 3, 4, 3, '2022-10-07 19:09:04', '승인되지 않았습니다.', '2022-10-07 19:09:04');
INSERT INTO `comment_tatlle` (`ctno`, `mno`, `bcno`, `trno`, `tdt`, `cont`, `comdt`) VALUES (9, 4, 5, 4, '2022-10-07 19:09:04', '승인되지 않았습니다.', '2022-10-07 19:09:04');



-- 장소 후기
INSERT INTO `location_review` (`lrno`, `mno`, `pno`, `title`, `cont`, `star`, `cdt`) VALUES (1, 1, 1, '기구많네요', '기구 진짜 좋아요 강추\n', 4.50, '2022-10-07 19:09:04');
INSERT INTO `location_review` (`lrno`, `mno`, `pno`, `title`, `cont`, `star`, `cdt`) VALUES (2, 2, 2, '클라이밍하면여기', '클라이밍하기좋음 good', 2.10, '2022-10-07 19:09:04');
INSERT INTO `location_review` (`lrno`, `mno`, `pno`, `title`, `cont`, `star`, `cdt`) VALUES (3, 3, 3, '난바람이될거야', '뛰기좋다 nice', 3.00, '2022-10-07 19:09:04');
INSERT INTO `location_review` (`lrno`, `mno`, `pno`, `title`, `cont`, `star`, `cdt`) VALUES (4, 4, 4, '체육실은 영어로', 'GYM', 5.00, '2022-10-07 19:09:04');
INSERT INTO `location_review` (`lrno`, `mno`, `pno`, `title`, `cont`, `star`, `cdt`) VALUES (5, 5, 5, '생각보다 별로네요', '담에 안올랍니다 그닥별로 haha', 1.10, '2022-10-07 19:09:04');
INSERT INTO `location_review` (`lrno`, `mno`, `pno`, `title`, `cont`, `star`, `cdt`) VALUES (6, 1, 2, '요기어디게6', '한방능이백숙마씨따', 3.40, '2022-10-07 19:09:04');
INSERT INTO `location_review` (`lrno`, `mno`, `pno`, `title`, `cont`, `star`, `cdt`) VALUES (7, 2, 3, '요기어디게7', '클라이밍하기좋음 good', 5.00, '2022-10-07 19:09:04');
INSERT INTO `location_review` (`lrno`, `mno`, `pno`, `title`, `cont`, `star`, `cdt`) VALUES (8, 3, 4, '요기어디게8', '뛰기좋다 nice', 1.40, '2022-10-07 19:09:04');
INSERT INTO `location_review` (`lrno`, `mno`, `pno`, `title`, `cont`, `star`, `cdt`) VALUES (9, 4, 5, '요기어디게9', '실내가 좋네 holy', 1.00, '2022-10-07 19:09:04');
INSERT INTO `location_review` (`lrno`, `mno`, `pno`, `title`, `cont`, `star`, `cdt`) VALUES (10, 5, 1, '요기어디게10', '그닥별로 haha', 4.20, '2022-10-07 19:09:04');


-- 장소 후기 첨부파일
INSERT INTO `location_review_file` (`lrfno`, `filepath`, `lrno`) VALUES (1, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 1);
INSERT INTO `location_review_file` (`lrfno`, `filepath`, `lrno`) VALUES (2, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 2);
INSERT INTO `location_review_file` (`lrfno`, `filepath`, `lrno`) VALUES (3, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 3);
INSERT INTO `location_review_file` (`lrfno`, `filepath`, `lrno`) VALUES (4, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 4);
INSERT INTO `location_review_file` (`lrfno`, `filepath`, `lrno`) VALUES (5, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 5);



-- 회원 신고
INSERT INTO `member_tatlle` (`mtno`, `mnoee`, `mnoer`, `trno`, `tdt`, `cont`, `comdt`) VALUES (1, 2, 1, 1, '2022-10-06 00:00:00', '승인되지 않았습니다.', '2022-10-06 16:13:33');
INSERT INTO `member_tatlle` (`mtno`, `mnoee`, `mnoer`, `trno`, `tdt`, `cont`, `comdt`) VALUES (2, 3, 2, 2, '2022-10-06 00:00:00', '', NULL);
INSERT INTO `member_tatlle` (`mtno`, `mnoee`, `mnoer`, `trno`, `tdt`, `cont`, `comdt`) VALUES (3, 4, 3, 3, '2022-10-06 00:00:00', '승인되지 않았습니다.', '2022-10-06 16:13:33');
INSERT INTO `member_tatlle` (`mtno`, `mnoee`, `mnoer`, `trno`, `tdt`, `cont`, `comdt`) VALUES (4, 5, 4, 4, '2022-10-06 00:00:00', '', '2022-10-06 16:13:33');
INSERT INTO `member_tatlle` (`mtno`, `mnoee`, `mnoer`, `trno`, `tdt`, `cont`, `comdt`) VALUES (5, 1, 5, 5, '2022-10-06 00:00:00', '블랙처리 됐습니다.', '2022-10-11 16:13:33');
INSERT INTO `member_tatlle` (`mtno`, `mnoee`, `mnoer`, `trno`, `tdt`, `cont`, `comdt`) VALUES (6, 2, 4, 1, '2022-10-06 00:00:00', '승인되지 않았습니다.', '2022-10-06 16:13:33');
INSERT INTO `member_tatlle` (`mtno`, `mnoee`, `mnoer`, `trno`, `tdt`, `cont`, `comdt`) VALUES (7, 3, 1, 2, '2022-10-06 00:00:00', '', NULL);
INSERT INTO `member_tatlle` (`mtno`, `mnoee`, `mnoer`, `trno`, `tdt`, `cont`, `comdt`) VALUES (8, 5, 1, 3, '2022-10-06 00:00:00', '', NULL);
INSERT INTO `member_tatlle` (`mtno`, `mnoee`, `mnoer`, `trno`, `tdt`, `cont`, `comdt`) VALUES (9, 2, 3, 4, '2022-10-06 00:00:00', '승인되지 않았습니다.', '2022-10-06 16:13:33');
INSERT INTO `member_tatlle` (`mtno`, `mnoee`, `mnoer`, `trno`, `tdt`, `cont`, `comdt`) VALUES (10, 1, 2, 5, '2022-10-06 00:00:00', '승인되지 않았습니다.', '2022-10-06 16:13:33');


-- 공지사항
INSERT INTO `notice` (`nno`, `title`, `cont`, `cdt`, `vw_cnt`) VALUES (1, '여기어때 이용 가이드', '여기어때 이용시 안내 사항 말씀드립니다', '2022-10-11 18:12:39', 0);
INSERT INTO `notice` (`nno`, `title`, `cont`, `cdt`, `vw_cnt`) VALUES (2, '신고 대상자 안내', '신고 대상자 안내드립니다.', '2022-10-11 18:12:39', 0);
INSERT INTO `notice` (`nno`, `title`, `cont`, `cdt`, `vw_cnt`) VALUES (3, '일반 회원을 가장한 사업자의 판매 및 홍보 행위 금지 안내', '일반 회원으로 가장하여 판매 및 홍보를 유도하는 글은 경고 없이 삭제 조치 됩니다.', '2022-10-11 18:12:39', 0);
INSERT INTO `notice` (`nno`, `title`, `cont`, `cdt`, `vw_cnt`) VALUES (4, '문의사항 안내', '문의사항은 공지사항 밑 1:1 문의만을 통해 이루어집니다.', '2022-10-11 18:12:39', 0);
INSERT INTO `notice` (`nno`, `title`, `cont`, `cdt`, `vw_cnt`) VALUES (5, '커뮤니티 게시판 안내', '핫딜 게시판은 양식을 지켜 업로드 바랍니다', '2022-10-11 18:12:39', 0);

-- 공지사항 첨부파일
INSERT INTO `notice_file` (`nfno`, `filepath`, `nno`) VALUES (1, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 1);
INSERT INTO `notice_file` (`nfno`, `filepath`, `nno`) VALUES (2, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 2);
INSERT INTO `notice_file` (`nfno`, `filepath`, `nno`) VALUES (3, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 3);
INSERT INTO `notice_file` (`nfno`, `filepath`, `nno`) VALUES (4, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 4);
INSERT INTO `notice_file` (`nfno`, `filepath`, `nno`) VALUES (5, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 5);
INSERT INTO `notice_file` (`nfno`, `filepath`, `nno`) VALUES (6, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 1);
INSERT INTO `notice_file` (`nfno`, `filepath`, `nno`) VALUES (7, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 1);
INSERT INTO `notice_file` (`nfno`, `filepath`, `nno`) VALUES (8, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 3);
INSERT INTO `notice_file` (`nfno`, `filepath`, `nno`) VALUES (9, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 3);
INSERT INTO `notice_file` (`nfno`, `filepath`, `nno`) VALUES (10, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 4);
