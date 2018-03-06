package com.artificialmatrix.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Test {

	@WebLoggableFunction()
	public void testAop() {
		System.out.println("testAop executed");
	
	}

	@WebLoggableFunction()
	public void testAopStr(String name) {
		System.out.println(name);
		this.testAop();	
	}

	public static void main(String argv[]) {
//		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//		TestB t = (TestB) ctx.getBean("testb");
//		t.testAop();
//		t.test();
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Test t = (Test) ctx.getBean("test");
		t.testAopStr("dfdf");
//		t.test();
	}

}
