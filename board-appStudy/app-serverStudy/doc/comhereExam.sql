-- 보안질문 데이터 입력
insert into secq(secqno,sq) values(1,'내가 좋아하는 강아지 품종은?');
insert into secq(secqno,sq) values(2,'내가 다녔던 초등학교 이름은?');
insert into secq(secqno,sq) values(3,'나의 아버지 이름은?');
insert into secq(secqno,sq) values(4,'내가 가장 좋아하는 취미는?');
insert into secq(secqno,sq) values(5,'내가 태어난 곳은?'); -- , 빠짐

-- 운동 지역 데이터 입력 
insert into region(rno,sido,sigu) values(1,'서울시', '종로구'); 
insert into region(rno,sido,sigu) values(2,'서울시', '중구');
insert into region(rno,sido,sigu) values(3,'서울시', '용산구');
insert into region(rno,sido,sigu) values(4,'서울시', '성동구');
insert into region(rno,sido,sigu) values(5,'서울시', '광진구');
insert into region(rno,sido,sigu) values(6,'서울시', '동대문구');
insert into region(rno,sido,sigu) values(7,'서울시', '중랑구');
insert into region(rno,sido,sigu) values(8,'서울시', '성북구');
insert into region(rno,sido,sigu) values(9,'서울시', '강북구');
insert into region(rno,sido,sigu) values(10,'서울시', '도봉구');
insert into region(rno,sido,sigu) values(11,'서울시', '노원구');
insert into region(rno,sido,sigu) values(12,'서울시', '은평구');
insert into region(rno,sido,sigu) values(13,'서울시', '서대문구');
insert into region(rno,sido,sigu) values(14,'서울시', '마포구');
insert into region(rno,sido,sigu) values(15,'서울시', '양천구');
insert into region(rno,sido,sigu) values(16,'서울시', '강서구');
insert into region(rno,sido,sigu) values(17,'서울시', '구로구');
insert into region(rno,sido,sigu) values(18,'서울시', '금천구');
insert into region(rno,sido,sigu) values(19,'서울시', '영등포구');
insert into region(rno,sido,sigu) values(20,'서울시', '동작구');
insert into region(rno,sido,sigu) values(21,'서울시', '관악구');
insert into region(rno,sido,sigu) values(22,'서울시', '서초구');
insert into region(rno,sido,sigu) values(23,'서울시', '강남구');
insert into region(rno,sido,sigu) values(24,'서울시', '송파구');
insert into region(rno,sido,sigu) values(25,'서울시', '강동구');

-- 회원 데이터 입력 // 암호 sha2()
insert into member(mno,name,email,pwd,nick,tel,bday,sex,filepath,cdt,act,black,secqno,sa)
values(1, '이헌식','sik@test.com',
'1111','흔시기','01011112222',
'9002061','0','26920e00-03fa-400d-a287-00460213ce49',
'2022-10-06','0','0','1','셸티');

insert into member(mno,name,email,pwd,nick,tel,bday,sex,filepath,cdt,act,black,secqno,sa)
values(2, '박병민','min@test.com',
'1111','병미니','01033334444',
'9402061','0','e4797a10-bb17-473e-b8f1-1379804ce6c5',
'2022-10-06','0','0','1','불독');

insert into member(mno,name,email,pwd,nick,tel,bday,sex,filepath,cdt,act,black,secqno,sa)
values(3, '임은지','gi@test.com',
'1111','이문지','01055556666',
'9402061','0','73a5722e-7dae-4b35-adc8-56640d7fde35',
'2022-10-06','0','0','1','웰시코기');

insert into member(mno,name,email,pwd,nick,tel,bday,sex,filepath,cdt,act,black,secqno,sa)
values(4, '유제동','dongdong@test.com',
'1111','동동이','01077778888',
'9502061','0','9bed1978-2b0d-4356-8227-9ae05274a488',
'2022-10-06','0','0','1','말티즈');

insert into member(mno,name,email,pwd,nick,tel,bday,sex,filepath,cdt,act,black,secqno,sa)
values(5, '최종찬','chan@test.com',
'1111','종차니','01099991121',
'9102061','0','4a245719-e75f-4344-8ce4-d92215260da8',
'2022-10-06','0','0','1','치와와');



-- 회원 입력 (name, email, pwd, nickname, pnumber, bdate, gender, filepath, cdt, act, blist, sa, scqno) 
insert into member(name, email, pwd, nickname, pnumber, bdate, gender, filepath, cdt, act, blist, scqno, sa) values('유제동', 'user1@test@com', sha2('1111',256), 'snowman', 01041559626, 1995-08-30, 1, ' ', '2022-10-06 16:13:33', '1', '0', 1, '골든리트리버');

--party_file
insert into party_file(filepath, pno) values('http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 1);
insert into party_file(filepath, pno) values('http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 2);
insert into party_file(filepath, pno) values('http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 3);
insert into party_file(filepath, pno) values('http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 4);
insert into party_file(filepath, pno) values('http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 5);

--party_count
insert into party_count(mno, sno, count) values(1, 1, 1);
insert into party_count(mno, sno, count) values(2, 2, 2);
insert into party_count(mno, sno, count) values(3, 3, 3);
insert into party_count(mno, sno, count) values(4, 4, 4);
insert into party_count(mno, sno, count) values(4, 4, 4);


--party_comment
insert into party_comment(mno, pno, cont) values(1, 1, '참여하고싶어요!');
insert into party_comment(mno, pno, cont) values(2, 2, '같이합시다!!');
insert into party_comment(mno, pno, cont) values(3, 3, '혹시 고인물들 많나요?!');
insert into party_comment(mno, pno, cont) values(4, 4, '와 정말 흥미로워요!');
insert into party_comment(mno, pno, cont) values(5, 5, '지금 당장 신청합니다!');

--notice_file
insert into notice_file(mno, cont) values(1, '스노우맨 회원이 모임에 신청했습니다.');
insert into notice_file(mno, cont) values(2, '클라이밍함께즐겨요 모임신청이 거부됐습니다.');
insert into notice_file(mno, cont) values(3, '1:1문의에 답변이 달렸습니다.');
insert into notice_file(mno, cont) values(4, '스노우맨님의 게시글에 댓글이 달렸습니다.');
insert into notice_file(mno, cont) values(5, '테니스함께즐겨요 모임신청이 승인됐습니다.');

-- member_tatlle
insert into member_tatlle(mnoee, mnoer, trno, cont, comdt) values(1, 2, 1, '신고하신 스노우맨님이 "혐오 발언 및 상징"사유로 인해 블랙처리가 됐습니다.', '2022-10-06 16:13:33');
insert into member_tatlle(mnoee, mnoer, trno, cont, comdt) values(2, 3, 2, '신고하신 스노우맨님이 "욕설 및 비방"사유로 인해 블랙처리가 됐습니다.', '2022-10-06 16:13:33');
insert into member_tatlle(mnoee, mnoer, trno, cont, comdt) values(3, 4, 3, '신고하신 스노우맨님이 "나체 이미지 또는 성적행위"사유로 인해 블랙처리가 됐습니다.', '2022-10-06 16:13:33');
insert into member_tatlle(mnoee, mnoer, trno, cont, comdt) values(4, 5, 4, '신고하신 스노우맨님이 "불법 또는 규제 상품 판매"사유로 인해 블랙처리가 됐습니다.', '2022-10-06 16:13:33');
insert into member_tatlle(mnoee, mnoer, trno, cont, comdt) values(5, 1, 5, '신고하신 스노우맨님이 "사기 또는 거짓"사유로 인해 블랙처리가 됐습니다.', '2022-10-06 16:13:33');

-- location_review_file
insert into location_review_file(filepath, lrno) values('http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 1);
insert into location_review_file(filepath, lrno) values('http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 2);
insert into location_review_file(filepath, lrno) values('http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 3);
insert into location_review_file(filepath, lrno) values('http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 4);
insert into location_review_file(filepath, lrno) values('http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 5);



------------------------------------------------------------------------------------------------


-- 회원 게시글 입력
insert into app_board(bno,title,cont,mno) values(11, '제목1', '내용1', 1);
insert into app_board(bno,title,cont,mno) values(12, '제목2', '내용2', 1);
insert into app_board(bno,title,cont,mno) values(13, '제목3', '내용3', 1);
insert into app_board(bno,title,cont,mno) values(14, '제목4', '내용4', 2);
insert into app_board(bno,title,cont,mno) values(15, '제목5', '내용5', 2);
insert into app_board(bno,title,cont,mno) values(16, '제목6', '내용6', 4);

-- 비회원 게시글 입력
insert into app_board(bno,title,cont,pwd) values(17, '제목101', '내용101', sha2('1111',256));
insert into app_board(bno,title,cont,pwd) values(18, '제목102', '내용102', sha2('1111',256));
insert into app_board(bno,title,cont,pwd) values(19, '제목103', '내용103', sha2('',256));
insert into app_board(bno,title,cont,pwd) values(20, '제목104', '내용104', sha2('',256));
