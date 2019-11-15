package com.dcits.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Service;

/**
 * Created by kongxiangwen on 12/4/18 w:49.
 */
@Service
public class AfterContextBean implements ApplicationListener<ContextRefreshedEvent>,  ApplicationContextAware {
	private ApplicationContext context;
	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		System.out.println("after event.......:"+context.getBeanDefinitionCount());
		String [] names = context.getBeanDefinitionNames();
		for(int i = 0; i < names.length; i ++){

			System.out.println(names[i]);
		}
	}


	/*@Override
	public void onApplicationEvent(ContextStartedEvent contextRefreshedEvent) {
		System.out.println("after event.......:"+context.getBeanDefinitionCount());
		String [] names = context.getBeanDefinitionNames();
		for(int i = 0; i < names.length; i ++){

			System.out.println(names[i]);
		}
	}*/

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("setting context.......");
		this.context = applicationContext;

	}
}
