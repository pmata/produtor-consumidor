package com.phmsistemas.thread.concurrent;

public class Consumer extends Thread {

	private Queue queue;

	public Consumer(Queue queue, String string) {
		this.queue = queue;
		this.setName(string);
	}

	public void run() {
		while (true) {
			try {
				sleep(random());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (queue.isRemovable())
				queue.remove();
		}
	}

	private long random() {
		Double random = Math.random() * 100;
		return (long) (random.intValue() % 10);
	}
}