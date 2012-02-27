package com.phmsistemas.thread.concurrent.blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	private final BlockingQueue<String> queue;

	private final int id;

	public Consumer(BlockingQueue<String> q, int i) {
		queue = q;
		id = i;
	}

	public void run() {
		while (true) {
			try {
				System.out.println(queue.take() + ", Consumer id:" + id);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
