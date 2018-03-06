package com.artificialmatrix.aop;

public @interface WebLoggableFunction {

	FrameworkName frameworkName() default FrameworkName.JSF;
	
}
