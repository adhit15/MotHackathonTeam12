package com.dbs.hacktron.service.impl;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

import com.dbs.hacktron.service.ProcessQueue;

public class ProcessQueueImpl implements ProcessQueue {
	
	private Map<Long, Queue<String>> messagesMap = new ConcurrentHashMap<Long, Queue<String>>();
	
	public void initial(){
		this.messagesMap.put(1L, new ArrayBlockingQueue(3));
	}

	@Override
	public synchronized String consume(long queueId) {
		String message = "";
		Queue<String> messages = messagesMap.get(queueId);
		
		while(messages.size()==0){
			try {
				//TODO:print queue is empty
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		message=messages.remove();
		messagesMap.put(queueId, messages);
		notifyAll();
		System.out.println(Thread.currentThread().getName() + " consumed " + message);
		return message;
	}

	@Override
	public synchronized void produce(long queueId, String message, long maxLimit) {
	
		Queue<String> messages = messagesMap.get(queueId);
		
		while(messages.size()==maxLimit){
			try {
				//TODO:print queue is full
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		messages.add(message);
		messagesMap.put(queueId, messages);
		notifyAll();
		
		System.out.println(Thread.currentThread().getName() + " produced " + message); 
	}
	


	@Override
	public String consumeAll(long queueId) {
		// TODO Auto-generated method stub
		return null;
	}

}
