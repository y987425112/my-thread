package com.ydy.thread.volatile2;

import com.ydy.thread.treadlocal.TreadLocalTest;

public class VolatileTest {
	public static void main(String[] args) throws Exception {
		Task task=new Task();
		task.start();
		Thread.sleep(2000);
		
		task.updateFlag();
		System.out.println("task.updateFlag()已经执行");
		
	}
	

	private static class Task extends Thread{
		private volatile   boolean  flag=true;
		private int num=0;

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(flag) {
				num	++;
			}
			System.out.println("num"+num);
		}
		
		
		public void updateFlag() {
			flag=false;
		}
		
	}
}

