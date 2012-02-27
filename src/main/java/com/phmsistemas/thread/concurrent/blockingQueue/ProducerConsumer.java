package com.phmsistemas.thread.concurrent.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumer {

	public static void main(String... args) throws Exception {
		BlockingQueue<String> q = new ArrayBlockingQueue<String>(10);
		ExecutorService executor = Executors.newCachedThreadPool();

		// produtores
		executor.execute(new Producer(q, 1));
		executor.execute(new Producer(q, 2));
		executor.execute(new Producer(q, 3));
		executor.execute(new Producer(q, 4));
		executor.execute(new Producer(q, 5));
		executor.execute(new Producer(q, 6));
		executor.execute(new Producer(q, 7));
		executor.execute(new Producer(q, 8));
		executor.execute(new Producer(q, 9));
		executor.execute(new Producer(q, 10));
		executor.execute(new Producer(q, 11));
		executor.execute(new Producer(q, 12));

		// consumidores
		executor.execute(new Consumer(q, 1));
		executor.execute(new Consumer(q, 2));
		executor.execute(new Consumer(q, 3));
		executor.execute(new Consumer(q, 4));
		executor.execute(new Consumer(q, 5));
		executor.execute(new Consumer(q, 6));
		executor.execute(new Consumer(q, 7));
		executor.execute(new Consumer(q, 8));
		executor.execute(new Consumer(q, 9));
		executor.execute(new Consumer(q, 10));
		executor.execute(new Consumer(q, 11));
		executor.execute(new Consumer(q, 12));
	}
}