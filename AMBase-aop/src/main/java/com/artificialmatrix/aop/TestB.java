package com.artificialmatrix.aop;

import org.springframework.stereotype.Component;

@Component(value = "testb")
public class TestB {

	public void test() {
		Test t = new Test();
		t.testAopStr("adfsa");
		t.testAop();
	}

}
