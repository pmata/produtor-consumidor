package com.phmsistemas.thread.concurrent;

public class ProducerConsumer {

	private static final int MAX_PRODUCER = 2;
	private static final int MAX_CONSUMER = 6;

	public static void main(String args[]) {
		Queue queue = new Queue();
		// Producers
		Producer producer = null;
		for (int i = 0; i < MAX_PRODUCER; i++) {
			producer = new Producer(queue, "Producer " + i);
			producer.start();
		}
		Consumer consumer = null;
		// Consumers
		for (int i = 0; i < MAX_CONSUMER; i++) {
			consumer = new Consumer(queue, "Consumer " + i);
			consumer.start();
		}
	}
}