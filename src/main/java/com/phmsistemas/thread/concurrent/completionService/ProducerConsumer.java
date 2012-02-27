package com.phmsistemas.thread.concurrent.completionService;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumer {

	private static AtomicInteger count = new AtomicInteger(0);

	public static void main(String args[]) throws InterruptedException,
			ExecutionException {

		CompletionService<String> completionService = new ExecutorCompletionService<String>(Executors.newFixedThreadPool(10));

		Producer producer = new Producer(completionService);
		Consumer consumer = new Consumer(completionService);

		while (true) {
			producer.addTask("Valor [" + safeIncrement() + "]");
			System.out.println(consumer.getResult().get());
		}
	}

	private static int safeIncrement() {
		if (count.equals(Integer.MAX_VALUE)) {
			return 0;
		} else {
			return count.addAndGet(1);
		}
	}
}