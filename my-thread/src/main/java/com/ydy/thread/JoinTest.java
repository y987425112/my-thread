package com.ydy.thread;

import java.util.concurrent.atomic.AtomicInteger;

class Add implements Runnable{

	private AtomicInteger count=new AtomicInteger(0);
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100000000;i++) {
			count.incrementAndGet();
		}
		
	}
	public AtomicInteger getCount() {
		return count;
	}
	
	
}

public class JoinTest {
	public static void main(String[] args) throws Exception {
		Add add=new Add();
		Thread t1=new Thread(add);
		Thread t2=new Thread(add);
		t1.start();
		t2.start();
		t1.join();//阻塞main线程,一直到t1线程运行完毕
		System.out.println("t1.join()");
		t2.join();
		System.out.println("t2.join()");
		
		System.out.println("countAll"+add.getCount());
	}

}
