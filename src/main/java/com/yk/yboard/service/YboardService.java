package com.yk.yboard.service;

import java.util.List;
import java.util.Map;

import com.yk.yboard.dto.Yboard;
import com.yk.yboard.dto.YboardSearch;

public interface YboardService {

	/**
	 * 총 리스트 갯수
	 * 
	 * @param yboard
	 * @return
	 */
	public int selectTotalCountYboard(YboardSearch yboardSearch);

	/**
	 * Yboard 리스트 출력
	 * 
	 * @param yboard
	 * @return
	 */
	public List<Yboard> selectYboard(YboardSearch yboardSearch);

	/**
	 * 선택한 Yboard 보기
	 * 
	 * @param map
	 * @return
	 */
	public Yboard viewYboard(Map<String, Object> map);

	/**
	 * Yboard 입력
	 * 
	 * @param yboard
	 * @return
	 */
	public int insertYboard(Yboard yboard);

	/**
	 * Yboard 업데이트
	 * 
	 * @param yboard
	 * @return
	 */
	public int updateYboard(Yboard yboard);

	/**
	 * 선택한 Yboard 삭제
	 * 
	 * @param map
	 * @return
	 */
	public void deleteYboard(List<Map<String, Object>> mapList);
}
