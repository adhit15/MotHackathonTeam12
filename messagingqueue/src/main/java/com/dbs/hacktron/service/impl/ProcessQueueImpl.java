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
	public String consume(long queueId) throws Exception{
		String message = "";
		Queue<String> messages = messagesMap.get(queueId);
		
		if(messages.size()==0){
			throw new Exception("Queue is empty");
		}

		message=messages.remove();
		messagesMap.put(queueId, messages);
		return message;
	}

	@Override
	public void produce(long queueId, String message, long maxLimit) throws Exception {
	
		Queue<String> messages = messagesMap.get(queueId);
		
		if(messages.size()==maxLimit){
			throw new Exception("Queue is full");
		}

		messages.add(message);
		messagesMap.put(queueId, messages);
	}
	


	@Override
	public String consumeAll(long queueId) {
		// TODO Auto-generated method stub
		return null;
	}

}
