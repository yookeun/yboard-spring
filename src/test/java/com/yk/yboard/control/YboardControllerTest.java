package com.yk.yboard.control;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.yk.yboard.dto.Yboard;
import com.yk.yboard.dto.YboardSearch;
import com.yk.yboard.service.YboardService;

@RunWith(SpringJUnit4ClassRunner.class)
// applicationContext_test.xml는 applicationContext.xml의 복사본이다.
// src/test/resource에 넣는다.
// 복사본을 만든 이유는 sqlSessionFactory에 mybatis-config.xml의 경로설정이 tomcat가동할때가 틀리기
// 때문이다.
@ContextConfiguration(locations = { "/applicationContext_test.xml" })
// defaultRollBack=true는 무조건 롤백이 된다. 데이터가 DB에 인서트된것을 확인하고자 하면 false로 해야 한다.
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class YboardControllerTest {

	@Autowired
	private YboardService yboardService;

	@Ignore
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

	@Ignore
	@Test
	public void testUpdateYboard() {
		Yboard yboard = new Yboard();
		yboard.setBoardID(1);
		yboard.setBoardTitle("테스트2");
		yboard.setBoardContent("안녕하세요 테스트입니다.2");
		yboard.setUserName("홍길동2");
		yboard.setUserGender("M");
		yboard.setPriority(1);
		yboardService.updateYboard(yboard);
	}

	@Ignore
	@Test
	public void testViewYboard() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boardID", 1);
		Yboard yboard = yboardService.viewYboard(map);
		assertEquals(yboard.getBoardID(), 1);
	}

	@Ignore
	@Test
	public void testTotalCountYboard() {
		YboardSearch yboard = new YboardSearch();
		yboard.setSearchColumn("boardTitle");
		yboard.setSearchText("테스트2");
		int total = yboardService.selectTotalCountYboard(yboard);
		assertEquals(total, 1);
	}

	@Ignore
	@Test
	public void testSelectYboard() {
		YboardSearch yboard = new YboardSearch();
		yboard.setSearchColumn("boardTitle");
		yboard.setSearchText("테스트2");
		yboard.setStart(0);
		yboard.setLimit(100);
		List<Yboard> list = yboardService.selectYboard(yboard);
		assertEquals(list.size(), 1);
	}

	@Ignore
	@Test
	public void deleteYboard() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boardID", 1);
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		mapList.add(map);
		yboardService.deleteYboard(mapList);
	}

}
