package com.artificialmatrix.aop;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WebLoggableFunctionAspect {

	
	@Around("@annotation(com.artificialmatrix.aop.WebLoggableFunction)")
	public Object logFunctionInfo(ProceedingJoinPoint joinPoint) throws Throwable {
		Thread joinPointThread = Thread.currentThread();
		String functionName = joinPoint.getSignature().getName();
		
		// String className = joinPoint.getSignature().getDeclaringTypeName();
		// Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
		// Thread[] threadArray = threadSet.toArray(new Thread[threadSet.size()]);
		// for (Thread t : threadArray) {
		// StackTraceElement[] elements = t.getStackTrace();
		// for (StackTraceElement ele : elements) {
		// if (StringUtils.contains(ele.getClassName(), className)
		// && StringUtils.equals(ele.getMethodName(), functionName)) {
		// joinPointThread = t;
		// }
		// }
		// }

		if (null != joinPointThread) {
			StackTraceElement[] elements = joinPointThread.getStackTrace();
			// for (StackTraceElement ele : elements) {
			// System.out.println("class name is " + ele.getClassName() + "; ---------
			// function name is : "
			// + ele.getMethodName());
			// }
			List<StackTraceElement> list = Arrays.asList(elements);
			Collections.reverse(list);
			for (StackTraceElement ele : list) {
				System.out.println("class name is " + ele.getClassName() + "; --------- function name is : "
						+ ele.getMethodName());
				if (StringUtils.equals(ele.getMethodName(), functionName)) {
					break;
				}
			}
		}
		Object[] args = joinPoint.getArgs();
		if (args.length > 0) {
			System.out.println("Parameter is: ");
			int tmpi = 0;
			for (Object arg : args) {
				System.out.println("    arg " + tmpi + " value: " + arg.toString());
				tmpi++;
			}
		}
		Object returnObj = joinPoint.proceed();
		return returnObj;
	}

}
