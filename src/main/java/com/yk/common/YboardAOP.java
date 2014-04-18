package com.yk.common;


import org.aspectj.lang.ProceedingJoinPoint;


/**
 * Spring AOP 
 * 주로 control에 있는 클래스의 매소드를 AOP로 하고 세션, 로그를 AROUND처리 한다. 
 * @author ykkim
 *
 */
public class YboardAOP extends YboardLogger {
		
	/**
	 * Control에 있는 메소드를 AOP한다.
	 * @param joinPoint
	 * @return
	 */
	public ResultJSON coverAround( ProceedingJoinPoint joinPoint) {
		ResultJSON resultJSON = new ResultJSON();				
		try {
			//해당 메소드 호출 
			resultJSON = (ResultJSON) joinPoint.proceed();			
		} catch (Throwable e) {			
			resultJSON.setSuccess(false);
		    resultJSON.setMsg(e.toString());
			logger.error("["+joinPoint.toString()+"]*"+e);
		}
		return resultJSON;
	}

}
