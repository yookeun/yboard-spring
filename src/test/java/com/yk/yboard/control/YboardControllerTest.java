package com.yk.yboard.control;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.yk.yboard.dto.Yboard;
import com.yk.yboard.service.YboardService;


@RunWith(SpringJUnit4ClassRunner.class)

//applicationContext_test.xml는 applicationContext.xml의 복사본이다. src/test/resource에 넣는다.
//복사본을 만든 이유는 sqlSessionFactory에 mybatis-config.xml의 경로설정이 tomcat가동할때가 틀리기 때문이다. 
@ContextConfiguration(locations = {"/applicationContext_test.xml"})

//defaultRollBack=true는 무조건 롤백이 된다. 데이터가 DB에 인서트된것을 확인하고자 하면 false로 해야 한다.
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)		
@Transactional
public class YboardControllerTest {

    @Autowired
    private YboardService yboardService;    
    
    @Test
    public void testInsertYboard() {
	Yboard yboard = new Yboard();
	yboard.setBoardTitle("테스트1");
	yboard.setBoardContent("안녕하세요 테스트입니다.");
	yboard.setUserName("홍길동");
	yboard.setUserGender("M");
	yboard.setPriority(3);
	yboardService.insertYboard(yboard);
    }

}
