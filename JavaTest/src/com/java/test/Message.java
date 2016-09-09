package com.java.test;

public class Message<T> {

	public String recipant;
	T value;
	public Message(T value)
	
	{
		this.value = value;
	}
	
	public T getValue()
	{
		return value;
	}
	//public abstract final void sendMessage();
	public static void main(String[] args) {
		
		Message<String> msg = new Message<String>("a string");
		Message<Integer> msg1 = new Message<>(123);
		System.out.print(msg.getValue());
		System.out.print(msg1.getValue());
	}

}
