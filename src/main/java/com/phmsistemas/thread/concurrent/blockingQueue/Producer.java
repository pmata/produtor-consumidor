package com.phmsistemas.thread.concurrent.blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	private final BlockingQueue<String> queue;

	private final int id;

	public Producer(BlockingQueue<String> q, int i) {
		queue = q;
		id = i;
	}

	public void run() {
		while (true) {
			try {
				queue.put("Producer id:" + id);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
