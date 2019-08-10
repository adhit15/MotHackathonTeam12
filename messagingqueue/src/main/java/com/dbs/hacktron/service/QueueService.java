package com.dbs.hacktron.service;

import java.util.List;

import com.dbs.hacktron.model.Queue;

public interface QueueService {

	List<Queue> getAllQueues();

	Queue getQueueById(long queueId);

	Queue addNewQueue(Queue queue);

	Queue updateQueue(Queue queue);

	void deleteQueueById(long queueId);

	void deleteAllQueues();

}
