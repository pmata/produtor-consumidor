package com.phmsistemas.thread.concurrent.completionService;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;

public class Producer {

	private CompletionService<String> completionService;

	public Producer(CompletionService<String> completionService) {
		this.completionService = completionService;
	}

	public void addTask(final String value) {
		completionService.submit(new Callable<String>() {
			public String call() throws Exception {
				return value;
			}
		});
	}
}
