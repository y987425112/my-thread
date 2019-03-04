package com.ydy.thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest2 {
	
	public static void main(String[] args) throws Exception {
		final Task task=new Task();
		Thread[] threads=new Thread[10];
		for(int i=0;i<10;i++) {
			Thread thread=new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					task.test();
				}
			});
			threads[i]=thread;
		}
		for(Thread t:threads) {
			t.start();
		}
		for(Thread t:threads) {
			t.join();
		}
		System.err.println("结果count:"+task.getCount());
		System.err.println("结果count2:"+task.getCount2());
	}
	
	public static class Task {

		private volatile int count=0;
		private AtomicInteger count2=new AtomicInteger(0);//cas
		public  void test() {
			// TODO Auto-generated method stub
			for(int i=0;i<10000;i++) {
				count++;
				count2.incrementAndGet();
			}
		}
		
		public int getCount() {
			return  count;
		}
		
		public int getCount2() {
			int i = count2.get();
			return i;
		}
		
	}

}
