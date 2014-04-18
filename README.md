이 소스는 angular, spring과 mvc로 개발한 테스트용 게시판입니다.

1. 데이터베이스와 테이블 생성
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