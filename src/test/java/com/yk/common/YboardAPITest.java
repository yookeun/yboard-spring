package com.yk.common;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class YboardAPITest {

	

	@Test
	public void useInsertBoardAPI() {
		YboardAPI yboardAPI = new YboardAPI();
		yboardAPI.setBoardTitle("TEST API");
		yboardAPI.setBoardContent("TEST API CONTENTS");
		yboardAPI.setUserName("KIM");
		yboardAPI.setUserGender("M");
		yboardAPI.setApiURL("http://localhost:8080/yboard/insert");
		String[] result = yboardAPI.insertBoard();
		System.out.println("success = " + result[0]);
		System.out.println("msg = " + result[1]);
		
	}

}
