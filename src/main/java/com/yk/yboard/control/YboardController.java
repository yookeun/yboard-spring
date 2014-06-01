package com.yk.yboard.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yk.common.ResultJSON;
import com.yk.common.YboardLogger;
import com.yk.yboard.dto.Yboard;
import com.yk.yboard.dto.YboardSearch;
import com.yk.yboard.service.YboardService;



@Controller
public class YboardController extends YboardLogger {
    
    @Autowired
    private YboardService yboardService;    
    
    /**
     * jquery용 페이지호출 
     * @param model
     * @return
     */
    @RequestMapping(value="/jquery", method=RequestMethod.GET)
    protected String showJqueryPage(Model model) {		
	model.addAttribute("yboard",new Yboard());  //초기세션처리를 위해 디폴트 처리 
	return "/jquery/yboard_list";
    }
        
    /**
     * angular.js 용 페이지호출 
     * @param model
     * @return
     */
    @RequestMapping(value="/angular", method=RequestMethod.GET)
    protected String showAngularPage(Model model) {		
	model.addAttribute("yboard",new Yboard());  //초기세션처리를 위해 디폴트 처리 
	return "/angular/yboard_list";
    }    
    
    /**
     * yboard리스트: 파라미터를 json형태로 받고 결과를 json형태로 출력 
     * @param yboard
     * @return
     */
    @RequestMapping(value = "/select", method=RequestMethod.POST)
    @ResponseBody 
    public ResultJSON selectYboard(@RequestBody YboardSearch yboardSearch) {
	ResultJSON resultJSON = new ResultJSON();
	int totalCount = yboardService.selectTotalCountYboard(yboardSearch);
	List<Yboard> yboardList = yboardService.selectYboard(yboardSearch);
	resultJSON.setTotal(totalCount);
	resultJSON.setItems(yboardList);
	resultJSON.setSuccess(true);
	return resultJSON;
    }
    
}
