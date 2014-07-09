package com.yk.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Spring AOP 주로 control에 있는 클래스의 매소드를 AOP로 하고 세션, 로그를 AROUND처리 한다.
 * 
 * @author ykkim
 * 
 */
@Component
@Aspect
public class YboardAOP extends YboardLogger {

	/**
	 * Control에 있는 메소드를 AOP한다.
	 * 
	 * @param joinPoint
	 * @return
	 */	 
	// * 만약 com.yk안에 여러개의 패키지가 있을 경우 || 으로 처리한다. (com.yk.*.*.*.*)
	// @Around("execution(public * com.yk.*.*.*Controller.*(..)) || execution(public * com.yk.*.*.*.*Controller.*(..))")
	@Around("execution(public ResultJSON com.yk.yboard.control.*Controller.*(..))")
	public ResultJSON coverAround(ProceedingJoinPoint joinPoint) {
		ResultJSON resultJSON = new ResultJSON();
		try {
			// 해당 메소드 호출
			resultJSON = (ResultJSON) joinPoint.proceed();
		} catch (Throwable e) {
			resultJSON.setSuccess(false);
			resultJSON.setMsg(e.toString());
			logger.error("[" + joinPoint.toString() + "]*" + e);
		}
		return resultJSON;
	}

}
