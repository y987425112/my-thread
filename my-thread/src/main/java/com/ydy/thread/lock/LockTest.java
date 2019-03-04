package com.ydy.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * lock测试
 * 
 * @author ydy
 */
public class LockTest {
	public static void main(String[] args) throws Exception {
		Task2 target=new Task2();
		for(int i=0;i<100000;i++) {
			Thread thread=new Thread(target);
			thread.start();
		}
		Thread.sleep(3000);
		System.out.println(target.getResult());

	}
}

class Task implements Runnable {

	private volatile int i = 100000;
	private Lock lock = new ReentrantLock();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		lock.lock();
		i--;
		lock.unlock();

	}

	public int getResult() {
		return i;
	}

}

class Task2 implements Runnable{
	private volatile int i=100000;
	ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		WriteLock writeLock = lock.writeLock();
		writeLock.lock();
		i--;
		writeLock.unlock();
		
		
	}
	
	public int getResult() {
		ReadLock readLock = lock.readLock();
		readLock.lock();
		int result=i;
		readLock.unlock();
		return result;
		
	}
	
}
