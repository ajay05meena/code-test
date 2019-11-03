package com.akm.helper;

public class Worker {
	public boolean doWork(){
		System.out.println("Entered to method ");
		try{
			Thread.sleep(1000);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		System.out.println("Exiting from method");
		return true;
	}
}