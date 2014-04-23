# 데이터베이스와 테이블 생성
CREATE DATABASE  yboard_db;

use yboard_db;
/**
 * 게시판테이블 (컬럼설명)
 * boardID : 고유키 
 * boardTitle: 제목 
 * boardContent: 내용
 * priority: 우선순위
 * userName: 작성자명
 * userGender: 작성자성별 (M: man, F: female)
 * registDate: 등록일
 */
 
CREATE TABLE yboard
(
	boardID INT NOT NULL AUTO_INCREMENT,
	boardTitle VARCHAR(50) NOT NULL,
	boardContent TEXT NOT NULL,
	priority TINYINT NOT NULL DEFAULT 3,	
	userName VARCHAR(20) NOT NULL,
	userGender CHAR(1) NOT NULL,	
	registDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(boardID) 
);


INSERT INTO yboard(boardTitle, boardContent, priority, userName, userGender) VALUES('테스트1','본문1',1,'이름1', 'M');
INSERT INTO yboard(boardTitle, boardContent, priority, userName, userGender) VALUES('테스트2','본문2',2,'이름2', 'F');
INSERT INTO yboard(boardTitle, boardContent, priority, userName, userGender) VALUES('테스트3','본문3',1,'이름3', 'M');
INSERT INTO yboard(boardTitle, boardContent, priority, userName, userGender) VALUES('테스트4','본문4',1,'이름4', 'M');
INSERT INTO yboard(boardTitle, boardContent, priority, userName, userGender) VALUES('테스트5','본문5',3,'이름5', 'F');
INSERT INTO yboard(boardTitle, boardContent, priority, userName, userGender) VALUES('테스트6','본문6',1,'이름6', 'M');
INSERT INTO yboard(boardTitle, boardContent, priority, userName, userGender) VALUES('테스트7','본문7',2,'이름7', 'M');
INSERT INTO yboard(boardTitle, boardContent, priority, userName, userGender) VALUES('테스트8','본문8',2,'이름8', 'F');
INSERT INTO yboard(boardTitle, boardContent, priority, userName, userGender) VALUES('테스트9','본문9',1,'이름9', 'M');
INSERT INTO yboard(boardTitle, boardContent, priority, userName, userGender) VALUES('테스트10','본문10',2,'이름10', 'M');
INSERT INTO yboard(boardTitle, boardContent, priority, userName, userGender) VALUES('테스트11','본문11',1,'이름11', 'F');
INSERT INTO yboard(boardTitle, boardContent, priority, userName, userGender) VALUES('테스트12','본문12',3,'이름12', 'M');
INSERT INTO yboard(boardTitle, boardContent, priority, userName, userGender) VALUES('테스트13','본문13',1,'이름13', 'F');
INSERT INTO yboard(boardTitle, boardContent, priority, userName, userGender) VALUES('테스트14','본문14',1,'이름14', 'M');
INSERT INTO yboard(boardTitle, boardContent, priority, userName, userGender) VALUES('테스트15','본문15',1,'이름15', 'M');
INSERT INTO yboard(boardTitle, boardContent, priority, userName, userGender) VALUES('테스트16','본문16',1,'이름16', 'F');
INSERT INTO yboard(boardTitle, boardContent, priority, userName, userGender) VALUES('테스트17','본문17',3,'이름17', 'M');
INSERT INTO yboard(boardTitle, boardContent, priority, userName, userGender) VALUES('테스트18','본문18',3,'이름18', 'F');
INSERT INTO yboard(boardTitle, boardContent, priority, userName, userGender) VALUES('테스트19','본문19',3,'이름19', 'M');
INSERT INTO yboard(boardTitle, boardContent, priority, userName, userGender) VALUES('테스트20','본문20',1,'이름20', 'F');
INSERT INTO yboard(boardTitle, boardContent, priority, userName, userGender) VALUES('테스트21','본문21',1,'이름21', 'M');
