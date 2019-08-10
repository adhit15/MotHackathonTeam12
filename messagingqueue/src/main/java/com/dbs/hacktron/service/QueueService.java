package com.dbs.hacktron.service;

import java.util.List;

import com.dbs.hacktron.model.Queue;

public interface QueueService {

	/**
	 * Fetch all the queue details
	 * @return - all the queue details
	 */
	List<Queue> getAllQueues();

	/**
	 * Fetch the queue details based on Id
	 * @param queueId - the queue Id 
	 * @return - the queue details
	 */
	Queue getQueueById(long queueId);

	/**
	 * Add a new queue
	 * @param queue - queue details to be added
	 * @return - the added queue
	 */
	Queue addNewQueue(Queue queue);

	/**
	 * Update the queue attributes
	 * @param queue - updated queue details
	 * @return - the updated queue
	 */
	Queue updateQueue(Queue queue);

	/**
	 * Delete a particular queue based on Id
	 * @param queueId - the queue Id 
	 */
	void deleteQueueById(long queueId);

	/**
	 * Delete all the queues
	 */
	void deleteAllQueues();

}
