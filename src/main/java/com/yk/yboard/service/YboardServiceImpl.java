package com.yk.yboard.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yk.yboard.dao.YboardDAO;
import com.yk.yboard.dto.Yboard;

@Component
public class YboardServiceImpl implements YboardService {
    
    @Autowired 
    private YboardDAO yboardDAO;
    

    @Override
    public int selectTotalCountYboard(Yboard yboard) {	
	return yboardDAO.selectTotalCountYboard(yboard);
    }

    @Override
    public List<Yboard> selectYboard(Yboard yboard) {	
	return yboardDAO.selectYboard(yboard);
    }

    @Override
    public Yboard viewYboard(Map<String, Object> map) {	
	return yboardDAO.viewYboard(map);
    }

    @Override
    public int insertYboard(Yboard yboard) {	
	return yboardDAO.insertYboard(yboard);
    }

    @Override
    public int updateYboard(Yboard yboard) {	
	return yboardDAO.updateYboard(yboard);
    }

    @Override
    public int deleteYboard(Map<String, Object> map) {	
	return yboardDAO.deleteYboard(map);
    }

}
