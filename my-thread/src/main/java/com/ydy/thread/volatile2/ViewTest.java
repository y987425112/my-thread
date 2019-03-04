package com.ydy.thread.volatile2;

/**
 * 内存可见性
 * 
 * @author ydy
 */
public class ViewTest {

	private int a = 0;
	private int b = 0;
	private volatile int c = 0;
	private int d = 0;
	private int e = 0;
private int f=0;
	public void test(int count) {
		a = count + 1;
		b = count + 1;
		
		c = count + 3;
		
//		if(c>count) {
//			f=count;
//		}
		
		d = count + 4;
		e = count + 5;
		
		
	}
}
