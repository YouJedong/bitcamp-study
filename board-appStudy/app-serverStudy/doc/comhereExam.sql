--제동 (위부터 순서대로 넣으면 됨)
--party_file
insert into party_file(pfno, filepath, pno) values(1, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 1);
insert into party_file(pfno, filepath, pno) values(2, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 2);
insert into party_file(pfno, filepath, pno) values(3, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 3);
insert into party_file(pfno, filepath, pno) values(4, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 4);
insert into party_file(pfno, filepath, pno) values(5, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 5);

--party_count
insert into party_count(mno, sno, count) values(1, 1, 1);
insert into party_count(mno, sno, count) values(2, 2, 2);
insert into party_count(mno, sno, count) values(3, 3, 3);
insert into party_count(mno, sno, count) values(4, 4, 4);
insert into party_count(mno, sno, count) values(5, 5, 5);

--party_comment
insert into party_comment(pcno, mno, pno, cont, cdt) values(1, 1, 2, '참여하고싶어요!', '2022-10-06');
insert into party_comment(pcno, mno, pno, cont, cdt) values(2, 2, 3, '같이합시다!!', '2022-10-06');
insert into party_comment(pcno, mno, pno, cont, cdt) values(3, 3, 4, '혹시 고인물들 많나요?!', '2022-10-06');
insert into party_comment(pcno, mno, pno, cont, cdt) values(4, 4, 5, '와 정말 흥미로워요!', '2022-10-06');
insert into party_comment(pcno, mno, pno, cont, cdt) values(5, 5, 1, '지금 당장 신청합니다!', '2022-10-06');

--notice_file
insert into notice_file(nfno, filepath, nno) values(1, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 1);
insert into notice_file(nfno, filepath, nno) values(2, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 2);
insert into notice_file(nfno, filepath, nno) values(3, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 3);
insert into notice_file(nfno, filepath, nno) values(4, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 4);
insert into notice_file(nfno, filepath, nno) values(5, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 5);

-- member_tatlle
insert into member_tatlle(mtno, mnoee, mnoer, trno, tdt, cont, comdt) values(1, 2, 1, 1, '2022-10-06', '신고하신 스노우맨님이 "혐오 발언 및 상징"사유로 인해 블랙처리가 됐습니다.', '2022-10-06 16:13:33');
insert into member_tatlle(mtno, mnoee, mnoer, trno, tdt, cont, comdt) values(2, 3, 2, 2, '2022-10-06', '신고하신 스노우맨님이 "욕설 및 비방"사유로 인해 블랙처리가 됐습니다.', '2022-10-06 16:13:33');
insert into member_tatlle(mtno, mnoee, mnoer, trno, tdt, cont, comdt) values(3, 4, 3, 3, '2022-10-06', '신고하신 스노우맨님이 "나체 이미지 또는 성적행위"사유로 인해 블랙처리가 됐습니다.', '2022-10-06 16:13:33');
insert into member_tatlle(mtno, mnoee, mnoer, trno, tdt, cont, comdt) values(4, 5, 4, 4, '2022-10-06', '신고하신 스노우맨님이 "불법 또는 규제 상품 판매"사유로 인해 블랙처리가 됐습니다.', '2022-10-06 16:13:33');
insert into member_tatlle(mtno, mnoee, mnoer, trno, tdt, cont, comdt) values(5, 1, 5, 5, '2022-10-06', '신고하신 스노우맨님이 "사기 또는 거짓"사유로 인해 블랙처리가 됐습니다.', '2022-10-06 16:13:33');


-- location_review_file
insert into location_review_file(lrfno, filepath, lrno) values(1, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 1);
insert into location_review_file(lrfno, filepath, lrno) values(2, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 2);
insert into location_review_file(lrfno, filepath, lrno) values(3, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 3);
insert into location_review_file(lrfno, filepath, lrno) values(4, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 4);
insert into location_review_file(lrfno, filepath, lrno) values(5, 'http://image.auction.co.kr/itemimage/1a/c2/ec/1ac2ec2fd6.jpg', 5);



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
insert into app_board(bno,title,cont,pwd) values(20, '제목104', '내용104', sha2('',256));
