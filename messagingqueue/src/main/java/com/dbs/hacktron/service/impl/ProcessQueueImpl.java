package com.dbs.hacktron.service.impl;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.dbs.hacktron.service.ProcessQueue;

@Component
public class ProcessQueueImpl implements ProcessQueue {

	private static final Map<Long, Queue<String>> messagesMap = new ConcurrentHashMap<Long, Queue<String>>();

	static {
		messagesMap.put(1L, new ArrayBlockingQueue(30));
		messagesMap.put(2L, new ArrayBlockingQueue(30));
		messagesMap.put(3L, new ArrayBlockingQueue(30));
		messagesMap.put(4L, new ArrayBlockingQueue(30));
		messagesMap.put(5L, new ArrayBlockingQueue(30));
	}

	@Override
	public String consume(long queueId) {// reading
		String message = "";
		Queue<String> messages = messagesMap.get(queueId);

		if (messages.size() == 0) {
			System.out.println("Queue is empty");
			return "";
		}

		message = messages.peek();// It retriuves but does not delete
		messagesMap.put(queueId, messages);
		return message;
	}

	@Override
	public String remove(long queueId) {// reading
		String message = "";
		Queue<String> messages = messagesMap.get(queueId);

		if (messages.size() == 0) {
			System.out.println("Queue is empty");
			return "";
		}

		message = messages.poll();
		messagesMap.put(queueId, messages);
		return message;
	}

	@Override
	public String add(long queueId, String message, long maxLimit) {

		Queue<String> messages = messagesMap.get(queueId);

		if (messages.size() == maxLimit) {
			System.out.println("Queue is full");
			return "Queue is full";
		}
		messages.add(message);
		messagesMap.put(queueId, messages);
		return messages+" added to queue.";
	}

}
