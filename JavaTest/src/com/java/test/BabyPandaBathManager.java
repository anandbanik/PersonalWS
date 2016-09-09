package com.java.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class BabyPandaBathManager {

	public static void main(String[] args) {
	
		final CyclicBarrier cb = new CyclicBarrier(3,() -> System.out.println("Clean !"));
		ExecutorService service = Executors.newScheduledThreadPool(2);
		IntStream.iterate(1, i-> 1).limit(12).forEach(i -> service.submit(() -> await(cb)));
		service.shutdown();

	}
	public static void await(CyclicBarrier cb)
	{
		try
		{
			cb.await();
		}
		catch(InterruptedException | BrokenBarrierException e)
		{
			System.out.println("Exception: "+e.toString());
		}
	}
}
