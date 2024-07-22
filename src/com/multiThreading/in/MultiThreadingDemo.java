package com.multiThreading.in;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadingDemo {
	
	 private static final int THREAD_POOL_SIZE = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//// Create a fixed-size thread pool
		 ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
		 
		 for (int i = 0; i < 10; i++) {
	            Runnable task = new Worker(i);
	            threadPool.submit(task);
	        }

		 threadPool.shutdown();
	}
}

class Worker implements Runnable {
    private final int taskId;

    public Worker(int taskId) {
        this.taskId = taskId;
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		 System.out.println("Task ID: " + this.taskId + " performed by "
	                + Thread.currentThread().getName());
		 
		 try {
	            Thread.sleep(2000);
	        } catch (InterruptedException e) {
	            System.err.println("Task ID: " + this.taskId + " was interrupted.");
	            Thread.currentThread().interrupt();
	        }
	        System.out.println("Task ID: " + this.taskId + " completed by "
	                + Thread.currentThread().getName());
	    }
}







