package com.dcits.aops;

import com.dcits.apps.Demo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.rmi.runtime.Log;

/**
 * Created by kongxiangwen on 11/7/18 w:45.
 */
@Aspect
public class DemoAspect {
	private final static Logger LOGGER = LoggerFactory.getLogger(DemoAspect.class);

	//@Pointcut("execution(public * com.oumyye.service..*.add(..))")
	@Before(value = "execution(public * com.dcits.beans.AopDemo.*(..))")
	public void beforeSendCommand(JoinPoint jp) {
		LOGGER.info("before");

	}

	@After(value = "execution(public * com.dcits.beans.AopDemo.*(..))")
	public void afterReadProtocolWithCheckingBroken() {
		LOGGER.info("after");
	}

	@Around(value = "execution(public * com.dcits2.beans.AopDemo.*.*(..))")
	public Object beforeGetAll(ProceedingJoinPoint jp) {

		LOGGER.info("around");
		try {
			return jp.proceed();
		}
		catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		return null;
	}
}
