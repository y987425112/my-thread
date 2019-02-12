package com.ydy.thread.atomic;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 原子引用
 * 
 * @author ydy
 */
public class AtomicReferenceTest {

	public final static AtomicReference<String> ATOMIC_REFERENCE = new AtomicReference<String>("abc");
	private static final Random RANDOM = new Random();

	public static void main(String[] args) throws Exception {
		final CountDownLatch countDownLatch = new CountDownLatch(1);
		Thread[] threads = new Thread[20];
		for (int i = 0; i < 20; i++) {
			final int num = i;
			threads[i] = new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					String oldValue = ATOMIC_REFERENCE.get();
					try {
						countDownLatch.await();
						Thread.sleep(RANDOM.nextInt() & 1000);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					if (ATOMIC_REFERENCE.compareAndSet(oldValue, oldValue + num)) {
						System.out.println("oldValue:"+oldValue);
						System.out.println("线程：" + num + ",进行了对象修改");
					}
				}
			});
			threads[i].start();

		}
		Thread.sleep(200);
		countDownLatch.countDown();
		for(Thread thread:threads) {
			thread.join();
		}
		System.out.println("最终结果为："+ATOMIC_REFERENCE.get());

	}
}
