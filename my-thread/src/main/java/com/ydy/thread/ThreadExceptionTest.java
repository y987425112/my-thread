package com.ydy.thread;

import java.lang.Thread.UncaughtExceptionHandler;

import org.apache.commons.lang3.exception.ExceptionUtils;
/**
 * 线程异常处理
 * @author ydy
 * */
public class ThreadExceptionTest {
	public static void main(String[] args) {
		Runnable runnable=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int i=1/0;
				
			}
		};
		Thread thread=new Thread(runnable);
		thread.setUncaughtExceptionHandler(new UncaughtExceptionHandlerDefault());
		thread.start();
		
	}

}

class UncaughtExceptionHandlerDefault implements UncaughtExceptionHandler{

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		// TODO Auto-generated method stub
		System.out.println("异常线程名称:"+t.getName());
		System.out.println("异常信息:"+ExceptionUtils.getStackTrace(e));
		
	}
	
}
