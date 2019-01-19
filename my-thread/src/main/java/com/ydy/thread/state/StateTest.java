package com.ydy.thread.state;
/**
 * 线程状态
 * @author ydy
 * */
public class StateTest {
	
	public static void main(String[] args) {
		Thread t=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		System.out.println("线程状态:"+t.getState());
		t.start();
		while(true) {
			System.out.println("线程状态:"+t.getState());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
