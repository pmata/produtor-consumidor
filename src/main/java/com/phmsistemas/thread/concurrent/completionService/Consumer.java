package com.phmsistemas.thread.concurrent.completionService;

import java.util.concurrent.CompletionService;
import java.util.concurrent.Future;

public class Consumer {

	private CompletionService<String> completionService;

	public Consumer(CompletionService<String> completionService) {
		this.completionService = completionService;
	}

	public Future<String> getResult() throws InterruptedException {
		return completionService.take();
	}
}