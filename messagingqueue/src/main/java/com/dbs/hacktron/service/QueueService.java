package com.dbs.hacktron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.hacktron.model.Queue;
import com.dbs.hacktron.repository.QueueRepository;

@Service
public class QueueService {

	@Autowired
	private QueueRepository queueRepository;
	
	public List<Queue> getAllQueues() {
		return queueRepository.getAllQueues();
	}
}
