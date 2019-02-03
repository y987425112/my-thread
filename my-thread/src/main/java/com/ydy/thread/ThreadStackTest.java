package com.ydy.thread;



/**
 * 线程栈和线程异常处理 
 * @author ydy
 * */
public class ThreadStackTest {
	public static void main(String[] args) {
		testStack();
		
	}
	/**
	 * 测试线程栈
	 * */
	private static void testStack() {
		Thread currentThread = Thread.currentThread();
		StackTraceElement[] stackTrace = currentThread.getStackTrace();//获取线程栈中元素
		for(StackTraceElement element:stackTrace) {
			String fileName = element.getFileName();
			String methodName = element.getMethodName();
			System.out.println("fileName:"+fileName);
			System.out.println("methodName:"+methodName);
			
		}
	}

}


