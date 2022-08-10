package com.drxgb.javafxutils.concurrency;

import javafx.concurrent.Task;

public abstract class FXThread
{
	public static synchronized void delay(long millis, Runnable continuation)
	{
		Task<Void> sleeper = new Task<Void>() {
			@Override
			protected Void call() throws Exception
			{
				Thread.sleep(millis);
				return null;
			}			
		};
		sleeper.setOnSucceeded(ev -> continuation.run());
		new Thread(sleeper).start();
	}
}
