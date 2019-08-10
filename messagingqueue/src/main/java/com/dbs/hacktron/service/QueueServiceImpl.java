package com.dbs.hacktron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.hacktron.model.Queue;
import com.dbs.hacktron.repository.QueueRepository;

@Service
public class QueueServiceImpl implements QueueService {

	@Autowired
	private QueueRepository dao;

	@Override
	public List<Queue> getAllQueues() {
		return (List<Queue>) dao.findAll();
	}

	@Override
	public Queue getQueueById(long queueId) {
		return dao.findById(queueId).get();
	}

	@Override
	public Queue addNewQueue(Queue queue) {
		return dao.save(queue);
	}

	@Override
	public Queue updateQueue(Queue queue) {
		return dao.save(queue);
	}

	@Override
	public void deleteQueueById(long queueId) {
		dao.deleteById(queueId);
	}

	@Override
	public void deleteAllQueues() {
		dao.deleteAll();
	}
}
