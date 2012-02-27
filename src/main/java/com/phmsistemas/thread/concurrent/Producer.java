package com.phmsistemas.thread.concurrent;

public class Producer extends Thread {

	private Queue queue;

	public Producer(Queue queue, String string) {
		this.queue = queue;
		this.setName(string);
	}

	public void run() {
		while (true) {
			try {
				sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			queue.add();
		}
	}
}