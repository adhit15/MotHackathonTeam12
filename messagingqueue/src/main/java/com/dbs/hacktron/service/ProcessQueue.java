package com.dbs.hacktron.service;

import java.util.Queue;

public interface ProcessQueue {

	/**
	 * Method to read message from the queue without deleting it
	 * @param queueId - the queue from which message is to read
	 * @return - the read message
	 */
	String consume(long queueId);

	/**
	 * Add message to the queue
	 * @param queueId - the queue from which message is to read
	 * @param message - the message to be added
	 * @param maxLimit - maximum capacity of the queue
	 * @return - the added message
	 */
	String add(long queueId, String message, long maxLimit);

	/**
	 * Remove message from the queue head
	 * @param queueId - the queue from which message is to read
	 * @return - the removed message
	 */
	String remove(long queueId);

	/**
	 * Browse all the messages of a queue
	 * @param queueId
	 * @return
	 */
	Queue<String> browse(long queueId);

}
