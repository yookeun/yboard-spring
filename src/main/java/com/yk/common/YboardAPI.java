package com.yk.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;

public class YboardAPI {
	
	private String boardTitle;					//제목
	private String boardContent;				//내용
	private String userName;					//작성자명
	private String userGender;					//성별
	private String apiURL;						// API 접속URL
	

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}


	public String getBoardContent() {
		return boardContent;
	}


	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserGender() {
		return userGender;
	}


	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	

	public String getApiURL() {
		return apiURL;
	}

	public void setApiURL(String apiURL) {
		this.apiURL = apiURL;
	}

	/**
	 * 게시판에 내용을 등록한다.
	 * @return
	 */
	public String[] insertBoard() {
		OutputStreamWriter out = null;
		BufferedReader in = null;
		String strReadLine = "";
		String[] result = new String[2];
		
		try {
			// java객체를 json 객체로 변환해준다.
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("boardTitle", boardTitle);
			jsonObject.put("boardContent", boardContent);
			jsonObject.put("userName", userName);		
			jsonObject.put("userGender", userGender);		

			URL url = new URL(apiURL);
			URLConnection connection = url.openConnection();
			HttpURLConnection hurlc = (HttpURLConnection) connection;
			hurlc.setRequestProperty("content-Type", "application/json");
			hurlc.setRequestMethod("POST"); // POST 방식 전송
			hurlc.setDoOutput(true);
			hurlc.setDoInput(true);
			hurlc.setUseCaches(false);
			hurlc.setDefaultUseCaches(false);
			hurlc.connect();
			out = new OutputStreamWriter(hurlc.getOutputStream());
			System.out.println(jsonObject.toString());
			out.write(jsonObject.toString());
			out.flush();
			out.close();
			in = new BufferedReader(new InputStreamReader(hurlc.getInputStream(), "UTF-8"));
			String strInLine = "";
			while ((strInLine = in.readLine()) != null) {
				strReadLine += strInLine;
			}
			in.close();

			// String을 json객체로 변환
			JSONObject jsonObject2 = new JSONObject(strReadLine);
			result[0] = String.valueOf(jsonObject2.get("success"));
			result[1] = "Success";			
		} catch (Exception e) {
			result[0] = "false";
			result[1] = e.toString();
		} finally {
			try {
				if (out != null)
					out.close();
				if (in != null)
					in.close();
			} catch (Exception e) {
			}
		}
		return result;
	}	
}
