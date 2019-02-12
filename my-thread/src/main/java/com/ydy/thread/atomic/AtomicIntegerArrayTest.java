package com.ydy.thread.atomic;


import java.util.concurrent.atomic.AtomicIntegerArray;
/**
 * 原子数组
 * @author ydy
 * */
public class AtomicIntegerArrayTest {

	private static final AtomicIntegerArray ATOMIC_INTEGER_ARRAY=new AtomicIntegerArray(10);
	
	public static void main(String[] args) throws Exception {
		Thread[] threads=new Thread[100];
		for(int i=0;i<100;i++) {
			final int index=i%10;
			final int threadNum=i;
			threads[i]=new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					int result=ATOMIC_INTEGER_ARRAY.addAndGet(index, index+1);
					System.out.println("线程编号为："+threadNum+",对应的原始值为："+(index+1)+",增加后的结果为："+result);
					
				}
			});
			threads[i].start();
		}
		for(Thread t:threads) {
			t.join();
		}
		System.out.println("--------------------------------------->结果列表");
		for(int i=0;i<ATOMIC_INTEGER_ARRAY.length();i++) {
			System.out.println(ATOMIC_INTEGER_ARRAY.get(i));
		}
	}
	
}
