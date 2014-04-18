package com.yk.yboard.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yk.yboard.dto.Yboard;

@Component
public class YboardDAOImpl implements YboardDAO {
    
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int selectTotalCountYboard(Yboard yboard) {	 
	    return sqlSession.selectOne("Yboard.selectTotalCountYboard", yboard);
	}

	@Override
	public List<Yboard> selectYboard(Yboard yboard) {	    
	    return sqlSession.selectList("Yboard.selectYboard", yboard);
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
	public int deleteYboard(Map<String, Object> map) {
	    return sqlSession.delete("Yboard.deleteYboard", map);
	}

}
