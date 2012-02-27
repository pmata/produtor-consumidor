package com.phmsistemas.thread.concurrent;

public class Queue {

	private static final Integer MAX_ITENS = 5000;
	private Integer itens = new Integer(0);
	private boolean firstThousand = false;

	private synchronized boolean isFull() {
		if (this.itens >= MAX_ITENS) {
			if (!this.firstThousand)
				this.firstThousand = true;
			return true;
		} else {
			return false;
		}
	}

	private synchronized boolean isEmpty() {
		if (this.itens <= 0) {
			return true;
		} else {
			return false;
		}
	}

	public synchronized void add() {
		while (isFull()) {
			try {
				synchronized (this) {
					wait();
					System.out.println(Thread.currentThread().getName()
							+ " waiting");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		itens++;
		System.out.println(Thread.currentThread().getName()
				+ " produziu um valor. Total [" + this.itens + "] ");
		synchronized (this) {
			notifyAll();
		}
	}

	public synchronized void remove() {
		while (isEmpty()) {
			try {
				synchronized (this) {
					wait();
					System.out.println(Thread.currentThread().getName()
							+ " waiting");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		itens--;
		System.out.println(Thread.currentThread().getName()
				+ " consumiu um valor. Total [" + this.itens + "]");
		synchronized (this) {
			notifyAll();
		}
	}

	public synchronized boolean isRemovable() {
		return this.firstThousand;
	}
}