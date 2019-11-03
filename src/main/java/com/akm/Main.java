package com.akm;

import com.akm.test.FlatMapExample1;

import java.time.Instant;
import java.util.concurrent.ExecutionException;

public class Main{
	public static void main(String [] args) throws ExecutionException, InterruptedException {
		FlatMapExample1 flatMapExample = new FlatMapExample1();
		Instant start = Instant.now();
		flatMapExample.runUsingSubscribe();
		Instant end = Instant.now();
		System.out.println("Time taken is (subscribe)" + (end.getEpochSecond() - start.getEpochSecond()));

		start = Instant.now();
		flatMapExample.runUsingMap();
		end = Instant.now();
		System.out.println("Time taken is (map)" + (end.getEpochSecond() - start.getEpochSecond()));

		start = Instant.now();
		flatMapExample.runUsingMapOnDifferentThread();
		end = Instant.now();
		System.out.println("Time taken is (map different thread)" + (end.getEpochSecond() - start.getEpochSecond()));

		start = Instant.now();
		flatMapExample.runUsingFlatMap();
		end = Instant.now();
		System.out.println("Time taken is (flat map)" + (end.getEpochSecond() - start.getEpochSecond()));
	}

}