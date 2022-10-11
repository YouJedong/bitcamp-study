-- comehere 시험 데이

-- 4단계(가장 높은 부모 테이블) 


-- 운동 분류 // 혼시기
insert into sports(sno,name) values(1,'헬스');
insert into sports(sno,name) values(2,'클라이밍');
insert into sports(sno,name) values(3,'배드민턴');
insert into sports(sno,name) values(4,'축구');
insert into sports(sno,name) values(5,'농구');

-- 운동 지역 데이터 입력// 혼시기
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

-- 보안질문 데이터 입력// 혼시기
insert into secq(secqno,sq) values(1,'내가 좋아하는 강아지 품종은?');
insert into secq(secqno,sq) values(2,'내가 다녔던 초등학교 이름은?');
insert into secq(secqno,sq) values(3,'나의 아버지 이름은?');
insert into secq(secqno,sq) values(4,'내가 가장 좋아하는 취미는?');
insert into secq(secqno,sq) values(5,'내가 태어난 곳은?');

-- 회원 데이터 입력// 혼시기
insert into member(mno,name,email,pwd,nick,tel,bday,sex,filepath,cdt,act,black,secqno,sa)
values(1, '이헌식','sik@test.com',
sha2('1111',256),'흔시기','01011112222',
'9002061','0','26920e00-03fa-400d-a287-00460213ce49',
'2022-10-06','0','0','1','셸티');

insert into member(mno,name,email,pwd,nick,tel,bday,sex,filepath,cdt,act,black,secqno,sa)
values(2, '박병민','min@test.com',
sha2('1111',256),'병미니','01033334444',
'9402061','0','e4797a10-bb17-473e-b8f1-1379804ce6c5',
'2022-10-06','0','0','1','불독');

insert into member(mno,name,email,pwd,nick,tel,bday,sex,filepath,cdt,act,black,secqno,sa)
values(3, '임은지','gi@test.com',
sha2('1111',256),'이문지','01055556666',
'9402061','0','73a5722e-7dae-4b35-adc8-56640d7fde35',
'2022-10-06','0','0','1','웰시코기');

insert into member(mno,name,email,pwd,nick,tel,bday,sex,filepath,cdt,act,black,secqno,sa)
values(4, '유제동','dongdong@test.com',
sha2('1111',256),'동동이','01077778888',
'9502061','0','9bed1978-2b0d-4356-8227-9ae05274a488',
'2022-10-06','0','0','1','말티즈');

insert into member(mno,name,email,pwd,nick,tel,bday,sex,filepath,cdt,act,black,secqno,sa)
values(5, '최종찬','chan@test.com',
sha2('1111',256),'종차니','01099991121',
'9102061','0','4a245719-e75f-4344-8ce4-d92215260da8',
'2022-10-06','0','0','1','치와와');



--3단계 

-- board category // 이문디
insert into board_category(bcno,name) values (1,'자유게시판');
insert into board_category(bcno,name) values (2,'식단');
insert into board_category(bcno,name) values (3,'챌린지');
insert into board_category(bcno,name) values (4,'Q&A');
insert into board_category(bcno,name) values (5,'핫딜게시판');

-- board // 이문디
insert into board(bno,bcno,mno,title,private,cont) values (1,1,4,'유제동',0,'두두제동');
insert into board(bno,bcno,mno,title,private,cont) values (2,2,5,'너무 싫어',0,'닭가슴살 토나와');
insert into board(bno,bcno,mno,title,private,cont) values (3,3,2,'집에 가고싶다',0,'스쿼트 400개 할때 까지 집 안 감;');
insert into board(bno,bcno,mno,title,private,cont) values (4,4,3,'나는 쌔삥',0,'모든 게 다 쌔삥 다음에 가사 뭐임?');
insert into board(bno,bcno,mno,title,private,cont) values (5,5,1,'프로틴 쉐이크 특가',0,'프로틴 쉐이크 특가 중');


-- 장소 location // 혼시기
insert into location(lno,rno,sno) values(1,1,1);
insert into location(lno,rno,sno) values(2,2,2);
insert into location(lno,rno,sno) values(3,3,3);
insert into location(lno,rno,sno) values(4,4,4);
insert into location(lno,rno,sno) values(5,5,5);

-- 모임 party // 혼시기
insert into party(pno,sno,lno,title,act,cont,cdt,headcnt,ptime,pdate)
values(1,1,1,
'파티원모집함','1','3대측정할 파티원모집함',
'2022-10-06','5','17:00',
'2022-10-06');
insert into party(pno,sno,lno,title,act,cont,cdt,headcnt,ptime,pdate)
values(2,2,2,
'클라이밍가실분','1','망포 동동이클라이밍장 좋아요 커몬요!',
'2022-10-06','5','10:00',
'2022-10-06');
insert into party(pno,sno,lno,title,act,cont,cdt,headcnt,ptime,pdate)
values(3,3,3,
'배드민턴 치실분?','1','동탄호수공원에서 쳐요!',
'2022-10-06','5','18:00',
'2022-10-06');
insert into party(pno,sno,lno,title,act,cont,cdt,headcnt,ptime,pdate)
values(4,4,4,
'축구하십시더! ','1','24명 구해봐요!',
'2022-10-06','5','17:00',
'2022-10-06');
insert into party(pno,sno,lno,title,act,cont,cdt,headcnt,ptime,pdate)
values(5,5,5,
'농구 고고','1','신나게 달려보시져 ',
'2022-10-06','5','17:00',
'2022-10-06');


-- 2단계 

-- party_status // 이문디
insert into party_status(psno,status) values (1,'대기');
insert into party_status(psno,status) values (2,'승인');
insert into party_status(psno,status) values (3,'거절');
insert into party_status(psno,status) values (4,'탈퇴');

-- 댓글 데이터 입력 // 병민 
insert into board_comment(bcno, bno, mno, cont) values(1, 1, 5, '내공냠냠 11');
insert into board_comment(bcno, bno, mno, cont) values(2, 2, 2, '좋아용 ');
insert into board_comment(bcno, bno, mno, cont) values(3, 3, 3, '운동하고 싶당 ');
insert into board_comment(bcno, bno, mno, cont) values(4, 3, 4, '재밌어용 ');
insert into board_comment(bcno, bno, mno, cont) values(5, 1, 3, '궁금해요');
insert into board_comment(bcno, bno, mno, cont) values(6, 5, 4, '근데 댓글 이렇게 하는 거 맞아요?');
insert into board_comment(bcno, bno, mno, cont) values(7, 5, 2, '댓글 내가 처음이다');
insert into board_comment(bcno, bno, mno, cont) values(8, 4, 1, '내가 두 번째!!!!');
insert into board_comment(bcno, bno, mno, cont) values(9, 3, 2, '광고 문의 카톡:eomcs');
insert into board_comment(bcno, bno, mno, cont) values(10, 4, 3, '게시글 내용 더 없어요? ');

-- Notice // 이문디
insert into notice(nno,title,cont) values (1,'여기어때 이용 가이드','여기어때 이용시 안내 사항 말씀드립니다');
insert into notice(nno,title,cont) values (2,'신고 대상자 안내','신고 대상자 안내드립니다.');
insert into notice(nno,title,cont) values (3,'일반 회원을 가장한 사업자의 판매 및 홍보 행위 금지 안내','일반 회원으로 가장하여 판매 및 홍보를 유도하는 글은 경고 없이 삭제 조치 됩니다.');
insert into notice(nno,title,cont) values (4,'문의사항 안내','문의사항은 공지사항 밑 1:1 문의만을 통해 이루어집니다.');
insert into notice(nno,title,cont) values (5,'커뮤니티 게시판 안내','핫딜 게시판은 양식을 지켜 업로드 바랍니다');


-- party_members // 이문디
insert into party_members(mno,pno,psno,auth) values (1,1,2,0);
insert into party_members(mno,pno,psno,auth) values (2,2,2,0);
insert into party_members(mno,pno,psno,auth) values (3,3,2,0);
insert into party_members(mno,pno,psno,auth) values (4,4,2,0);
insert into party_members(mno,pno,psno,auth) values (5,5,2,0);

-- party_review // 이문디
insert into party_review(prno,mno,pno,title,cont,star) values (1,1,1,'3대 치고 왔습니다','벤치 100 스쿼트 120 대드 140 했습니다 얼른 3대 400 찍고싶네요',5);
insert into party_review(prno,mno,pno,title,cont,star) values (2,2,2,'병미파티 망포 클라이밍 장 다녀왔습니다','안전 장치도 잘 되어 있고 좋네요',4);
insert into party_review(prno,mno,pno,title,cont,star) values (3,3,3,'전직 국대와 경기하니 좋네요','모임장님이 전 국대셔서 라켓 잡는 법까지 세세하게 알려주셔서 좋았습니다',5);
insert into party_review(prno,mno,pno,title,cont,star) values (4,4,4,'조기축구 결성','여러번 해봤는데 마음이 잘 맞아서 매주 조기축구 하기로 했습니다 ^^',3);
insert into party_review(prno,mno,pno,title,cont,star) values (5,5,5,'좋습니다','좋아요',2);


-- 1단계(제일 낮은 자식 테이블)

-- 신고사유 카테고리 데이터 입력 // 병민 
insert into tatlle_reason(trno, reason) values(1, '불건전한 내용');
insert into tatlle_reason(trno, reason) values(2, '스팸 및 부적절한 홍보');
insert into tatlle_reason(trno, reason) values(3, '명예회손 및 비방');
insert into tatlle_reason(trno, reason) values(4, '초상권 및 저작권 침해');
insert into tatlle_reason(trno, reason) values(5, '개인정보 도용');
insert into tatlle_reason(trno, reason) values(6, '기타 사이트 목적에 맞지 않는 행위');

-- 스크랩 데이터 입력  // 병민 
insert into scrap(mno, bno) values(1, 1);
insert into scrap(mno, bno) values(2, 3);
insert into scrap(mno, bno) values(3, 3);
insert into scrap(mno, bno) values(3, 2);
insert into scrap(mno, bno) values(4, 5);
insert into scrap(mno, bno) values(5, 4);

-- 1:1문의 데이터 입력  // 병민 
insert into qna(qno, mno, title, cont) values(1, 1, '이용 문의 드려요', '모임 설정하는데 지역 설정을 하나만 할 수 있나요?');
insert into qna(qno, mno, title, cont) values(2, 3, '탈퇴하면 정보 다 사라지나요?', '탈퇴하려 하는데 탈퇴하면 제가 쓴 글이나 정보 다 사라지나요? 아니면 남아있나요? ');
insert into qna(qno, mno, title, cont) values(3, 2, '고객센터 번호 알려주세요', '고객센터 번호랑 이용시간 좀 알려주세요 직접 전화해서 물어보게');
insert into qna(qno, mno, title, cont) values(4, 4, '이용 문의 드립니다', '게시글 스크랩 어디로 가야 볼 수 있나요?');
insert into qna(qno, mno, title, cont) values(5, 5, '저기요', '이거 직접 관리자가 답변해줘요? 아님 컴퓨터 자동 답변이에요?');

-- 1:1문의 데이터 입력  // 병민 
insert into plan(plno, mno, title, dday, chl) values(1, 1, '근성장', '2022-12-21', 40.5);
insert into plan(plno, mno, title, dday, chl) values(2, 2, '살크업', '2021-01-21', 71.0);
insert into plan(plno, mno, title, dday, chl) values(3, 3, '다이어트', '2022-12-31', 49.9);
insert into plan(plno, mno, title, dday, chl) values(4, 4, '득근하기', '2023-01-01', 25.76);
insert into plan(plno, mno, title, dday, chl) values(5, 5, '체중조절', '2022-11-28', 73.5);

-- 모임후기 첨부파일 데이터 입력  // 병민 
insert into party_review_file(prfno, filepath, prno) values(1, '/Users/parkbyeongmin/git/teamproject-comehere/comehere-app/comehere-server/doc/comehere_party_review_file 1.jpeg', 1);
insert into party_review_file(prfno, filepath, prno) values(2, '/Users/parkbyeongmin/git/teamproject-comehere/comehere-app/comehere-server/doc/comehere_party_review_file 2.jpeg', 2);
insert into party_review_file(prfno, filepath, prno) values(3, '/Users/parkbyeongmin/git/teamproject-comehere/comehere-app/comehere-server/doc/comehere_party_review_file 3.jpeg', 3);
insert into party_review_file(prfno, filepath, prno) values(4, '/Users/parkbyeongmin/git/teamproject-comehere/comehere-app/comehere-server/doc/comehere_party_review_file 4.jpeg', 4);
insert into party_review_file(prfno, filepath, prno) values(5, '/Users/parkbyeongmin/git/teamproject-comehere/comehere-app/comehere-server/doc/comehere_party_review_file 5.jpeg', 5);
insert into party_review_file(prfno, filepath, prno) values(6, '/Users/parkbyeongmin/git/teamproject-comehere/comehere-app/comehere-server/doc/comehere_party_review_file 6.jpeg', 4);

-- 관리자 // 혼시기
insert into admin(adno,name,email,pwd,cdt) 
values(1,'admin','admin@test.com',sha2('1111',256),'2022-10-06');

--알림 // 혼시기
insert into alert(alno,mno,cont,aldt,alcheck) 
values(1,1,'댓글이 달렸어요!','2022-10-06','1');
insert into alert(alno,mno,cont,aldt,alcheck) 
values(2,2,'댓글이 달렸어요2!','2022-10-06','1');
insert into alert(alno,mno,cont,aldt,alcheck) 
values(3,3,'댓글이 달렸어요3!','2022-10-06','1');
insert into alert(alno,mno,cont,aldt,alcheck) 
values(4,4,'댓글이 달렸어요4!','2022-10-06','1');
insert into alert(alno,mno,cont,aldt,alcheck) 
values(5,5,'댓글이 달렸어요5!','2022-10-06','1');


--party_file // 제동
insert into party_file(pfno, filepath, pno) values(1, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 1);
insert into party_file(pfno, filepath, pno) values(2, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 1);
insert into party_file(pfno, filepath, pno) values(3, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 3);
insert into party_file(pfno, filepath, pno) values(4, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 4);
insert into party_file(pfno, filepath, pno) values(5, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 5);
insert into party_file(pfno, filepath, pno) values(6, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 1);
insert into party_file(pfno, filepath, pno) values(7, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 4);
insert into party_file(pfno, filepath, pno) values(8, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 3);
insert into party_file(pfno, filepath, pno) values(9, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 5);
insert into party_file(pfno, filepath, pno) values(10, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 5);

--party_count // 제동
insert into party_count(mno, sno, count) values(1, 1, 1);
insert into party_count(mno, sno, count) values(5, 3, 1);
insert into party_count(mno, sno, count) values(3, 3, 3);
insert into party_count(mno, sno, count) values(4, 4, 4);
insert into party_count(mno, sno, count) values(5, 5, 5);
insert into party_count(mno, sno, count) values(1, 2, 5);
insert into party_count(mno, sno, count) values(3, 2, 5);
insert into party_count(mno, sno, count) values(4, 3, 8);
insert into party_count(mno, sno, count) values(5, 1, 9);
insert into party_count(mno, sno, count) values(5, 2, 10);

--party_comment // 제동
insert into party_comment(pcno, mno, pno, cont, cdt) values(1, 1, 2, '참여하고싶어요!', '2022-10-06');
insert into party_comment(pcno, mno, pno, cont, cdt) values(2, 2, 3, '같이합시다!!', '2022-10-06');
insert into party_comment(pcno, mno, pno, cont, cdt) values(3, 3, 4, '혹시 고인물들 많나요?!', '2022-10-06');
insert into party_comment(pcno, mno, pno, cont, cdt) values(4, 4, 5, '와 정말 흥미로워요!', '2022-10-06');
insert into party_comment(pcno, mno, pno, cont, cdt) values(5, 5, 6, '지금 당장 신청합니다!', '2022-10-06');
insert into party_comment(pcno, mno, pno, cont, cdt) values(6, 1, 3, '참여하고싶어요!', '2022-10-06');
insert into party_comment(pcno, mno, pno, cont, cdt) values(7, 1, 4, '같이합시다!!', '2022-10-06');
insert into party_comment(pcno, mno, pno, cont, cdt) values(8, 3, 4, '혹시 고인물들 많나요?!', '2022-10-06');
insert into party_comment(pcno, mno, pno, cont, cdt) values(9, 4, 5, '와 정말 흥미로워요!', '2022-10-06');
insert into party_comment(pcno, mno, pno, cont, cdt) values(10, 5, 1, '지금 당장 신청합니다!', '2022-10-06');

--notice_file // 제동
insert into notice_file(nfno, filepath, nno) values(1, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 1);
insert into notice_file(nfno, filepath, nno) values(2, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 2);
insert into notice_file(nfno, filepath, nno) values(3, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 3);
insert into notice_file(nfno, filepath, nno) values(4, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 4);
insert into notice_file(nfno, filepath, nno) values(5, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 5);
insert into notice_file(nfno, filepath, nno) values(6, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 1);
insert into notice_file(nfno, filepath, nno) values(7, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 1);
insert into notice_file(nfno, filepath, nno) values(8, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 3);
insert into notice_file(nfno, filepath, nno) values(9, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 3);
insert into notice_file(nfno, filepath, nno) values(10, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 4);

-- member_tatlle // 제동
insert into member_tatlle(mtno, mnoee, mnoer, trno, tdt, cont, comdt) values(1, 2, 1, 1, '2022-10-06', '신고하신 ㅇㅇㅇ님이 "혐오 발언 및 상징"사유로 인해 블랙처리가 됐습니다.', '2022-10-06 16:13:33');
insert into member_tatlle(mtno, mnoee, mnoer, trno, tdt, cont, comdt) values(2, 3, 2, 2, '2022-10-06', '신고하신 ㅇㅇㅇ님이 "욕설 및 비방"사유로 인해 블랙처리가 됐습니다.', '2022-10-06 16:13:33');
insert into member_tatlle(mtno, mnoee, mnoer, trno, tdt, cont, comdt) values(3, 4, 3, 3, '2022-10-06', '신고하신 ㅇㅇㅇ님이 "나체 이미지 또는 성적행위"사유로 인해 블랙처리가 됐습니다.', '2022-10-06 16:13:33');
insert into member_tatlle(mtno, mnoee, mnoer, trno, tdt, cont, comdt) values(4, 5, 4, 4, '2022-10-06', '신고하신 ㅇㅇㅇ님이 "불법 또는 규제 상품 판매"사유로 인해 블랙처리가 됐습니다.', '2022-10-06 16:13:33');
insert into member_tatlle(mtno, mnoee, mnoer, trno, tdt, cont, comdt) values(5, 2, 3, 5, '2022-10-06', '신고하신 ㅇㅇㅇ님이 "사기 또는 거짓"사유로 인해 블랙처리가 됐습니다.', '2022-10-06 16:13:33');
insert into member_tatlle(mtno, mnoee, mnoer, trno, tdt, cont, comdt) values(6, 2, 4, 1, '2022-10-06', '신고하신 ㅇㅇㅇ님이 "혐오 발언 및 상징"사유로 인해 블랙처리가 됐습니다.', '2022-10-06 16:13:33');
insert into member_tatlle(mtno, mnoee, mnoer, trno, tdt, cont, comdt) values(7, 3, 1, 2, '2022-10-06', '신고하신 ㅇㅇㅇ님이 "욕설 및 비방"사유로 인해 블랙처리가 됐습니다.', '2022-10-06 16:13:33');
insert into member_tatlle(mtno, mnoee, mnoer, trno, tdt, cont, comdt) values(8, 5, 1, 3, '2022-10-06', '신고하신 ㅇㅇㅇ님이 "나체 이미지 또는 성적행위"사유로 인해 블랙처리가 됐습니다.', '2022-10-06 16:13:33');
insert into member_tatlle(mtno, mnoee, mnoer, trno, tdt, cont, comdt) values(9, 2, 3, 4, '2022-10-06', '신고하신 ㅇㅇㅇ님이 "불법 또는 규제 상품 판매"사유로 인해 블랙처리가 됐습니다.', '2022-10-06 16:13:33');
insert into member_tatlle(mtno, mnoee, mnoer, trno, tdt, cont, comdt) values(10, 1, 2, 5, '2022-10-06', '신고하신 ㅇㅇㅇ님이 "사기 또는 거짓"사유로 인해 블랙처리가 됐습니다.', '2022-10-06 16:13:33');

-- location_review // 종찬
insert into location_review(lrno, mno, pno, title, cont, star, cdt) values(1,1,1, '요기어디게1', '한방능이백숙마씨따', 4.5, '2022-10-07 19:09:04');
insert into location_review(lrno, mno, pno, title, cont, star, cdt) values(2,2,2, '요기어디게2', '클라이밍하기좋음 good', 2.1, '2022-10-07 19:09:04');
insert into location_review(lrno, mno, pno, title, cont, star, cdt) values(3,3,3, '요기어디게3', '뛰기좋다 nice', 3, '2022-10-07 19:09:04');
insert into location_review(lrno, mno, pno, title, cont, star, cdt) values(4,4,4, '요기어디게4', '실내가 좋네 holy', 5, '2022-10-07 19:09:04');
insert into location_review(lrno, mno, pno, title, cont, star, cdt) values(5,5,5, '요기어디게5', '그닥별로 haha', 1.1, '2022-10-07 19:09:04');



-- location_review_file // 제동
insert into location_review_file(lrfno, filepath, lrno) values(1, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 1);
insert into location_review_file(lrfno, filepath, lrno) values(2, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 2);
insert into location_review_file(lrfno, filepath, lrno) values(3, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 3);
insert into location_review_file(lrfno, filepath, lrno) values(4, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 4);
insert into location_review_file(lrfno, filepath, lrno) values(5, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 5);

-- board_file // 종찬
insert into board_file(bfno, filepath, bno) values(1, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 1);
insert into board_file(bfno, filepath, bno) values(2, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 2);
insert into board_file(bfno, filepath, bno) values(3, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 3);
insert into board_file(bfno, filepath, bno) values(4, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 4);
insert into board_file(bfno, filepath, bno) values(5, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 5);

-- board_tatlle // 종찬
insert into board_tatlle(btno, mno, decbno, trno, tdt, cont, comdt) values(1, 3, 1, 1, '2022-10-07', '신고하신 게시물은 "~!!ㅁㄴㅇ이유"로 신고처리 됐습니다.', '2022-10-07 19:09:04');
insert into board_tatlle(btno, mno, decbno, trno, tdt, cont, comdt) values(2, 4, 2, 2, '2022-10-07', '신고하신 게시물은 "~!!ㅁㄴㅇ이유"로 신고처리 됐습니다.', '2022-10-07 19:09:04');
insert into board_tatlle(btno, mno, decbno, trno, tdt, cont, comdt) values(3, 2, 3, 3, '2022-10-07', '신고하신 게시물은 "~!!ㅁㄴㅇ이유"로 신고처리 됐습니다.', '2022-10-07 19:09:04');
insert into board_tatlle(btno, mno, decbno, trno, tdt, cont, comdt) values(4, 5, 4, 4, '2022-10-07', '신고하신 게시물은 "~!!ㅁㄴㅇ이유"로 신고처리 됐습니다.', '2022-10-07 19:09:04');
insert into board_tatlle(btno, mno, decbno, trno, tdt, cont, comdt) values(5, 1, 5, 5, '2022-10-07', '신고하신 게시물은 "~!!ㅁㄴㅇ이유"로 신고처리 됐습니다.', '2022-10-07 19:09:04');


-- favorite_region // 종찬
insert into favorite_region(rno, mno) values(25, 1);
insert into favorite_region(rno, mno) values(6, 2);
insert into favorite_region(rno, mno) values(13, 3);
insert into favorite_region(rno, mno) values(20, 4);
insert into favorite_region(rno, mno) values(7, 5);


-- favorite_sport // 종찬
insert into favorite_sport(sno,mno) values(5, 1);
insert into favorite_sport(sno,mno) values(4, 3);
insert into favorite_sport(sno,mno) values(3, 2);
insert into favorite_sport(sno,mno) values(2, 4);
insert into favorite_sport(sno,mno) values(1, 5);

-- comment_tatlle // 종찬
insert into comment_tatlle(ctno, mno, bcno, trno, tdt, cont, comdt) values(1, 1, 1, 1, '2022-10-06 19:01:04', '처리됐습니다', '2022-10-07 19:09:04');
insert into comment_tatlle(ctno, mno, bcno, trno, tdt, cont, comdt) values(2, 2, 2, 2, '2022-10-06 19:01:04', '처리됐습니다', '2022-10-07 19:09:04');
insert into comment_tatlle(ctno, mno, bcno, trno, tdt, cont, comdt) values(3, 3, 3, 3, '2022-10-06 19:01:04', '처리됐습니다', '2022-10-07 19:09:04');
insert into comment_tatlle(ctno, mno, bcno, trno, tdt, cont, comdt) values(4, 4, 4, 4, '2022-10-06 19:01:04', '처리됐습니다', '2022-10-07 19:09:04');
insert into comment_tatlle(ctno, mno, bcno, trno, tdt, cont, comdt) values(5, 5, 5, 5, '2022-10-06 19:01:04', '처리됐습니다', '2022-10-07 19:09:04');
