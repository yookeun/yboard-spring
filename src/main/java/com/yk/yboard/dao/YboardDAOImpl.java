package com.yk.yboard.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yk.yboard.dto.Yboard;
import com.yk.yboard.dto.YboardSearch;

@Component
public class YboardDAOImpl implements YboardDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int selectTotalCountYboard(YboardSearch yboardSearch) {
		return sqlSession.selectOne("Yboard.selectTotalCountYboard", yboardSearch);
	}

	@Override
	public List<Yboard> selectYboard(YboardSearch yboardSearch) {
		return sqlSession.selectList("Yboard.selectYboard", yboardSearch);
	}

	@Override
	public Yboard viewYboard(Map<String, Object> map) {
		return sqlSession.selectOne("Yboard.viewYboard", map);
	}

	@Override
	public int insertYboard(Yboard yboard) {
		return sqlSession.insert("Yboard.insertYboard", yboard);
	}

	@Override
	public int updateYboard(Yboard yboard) {
		return sqlSession.update("Yboard.updateYboard", yboard);
	}

	@Override
	public void deleteYboard(List<Map<String, Object>> mapList) {		
		for (Map<String, Object> map: mapList) {
			sqlSession.delete("Yboard.deleteYboard", map);
		}		
	}

}
