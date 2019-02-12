package com.ydy.thread.atomic;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger 测试 来自 java特种兵
 * @author ydy
 * */
public class AtomicIntegerTest {
	public final static AtomicInteger TEST_INTEGER=new AtomicInteger(1);
	
	private static int index=1;
	
	public static void main(String[] args) throws Exception {
		final CountDownLatch countDownLatch=new CountDownLatch(1);
		final Thread[] threads=new Thread[10];
		for(int i=0;i<10;i++) {
			threads[i]=new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						countDownLatch.await();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					for(int j=0;j<100;j++) {
						index++;
						TEST_INTEGER.incrementAndGet();
//						TEST_INTEGER.lazySet(newValue);
					}
					
				}
			});
			threads[i].start();
		}
		Thread.sleep(1000);
		countDownLatch.countDown();
		for(Thread t:threads) {
			t.join();
		}
		System.out.println("Atomic最终运行结果:"+TEST_INTEGER.get());
		System.out.println("valatile最终运行结果："+index);
 	}
	

}
