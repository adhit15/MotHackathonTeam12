package com.dbs.hacktron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.hacktron.model.QueueModel;
import com.dbs.hacktron.repository.QueueRepository;

@Service
public class QueueService {

	@Autowired
	private QueueRepository queueRepository;

	public void addQueue(QueueModel queue) {
		queueRepository.save(queue);
	}

	public void getQueue(Long id) {
		queueRepository.findById(id);
	}

	public List<QueueModel> findAll() {
		List<QueueModel> queues = (List<QueueModel>) queueRepository.findAll();
		return queues;
	}

	public Optional<QueueModel> findById(long id) {
		// TODO Auto-generated method stub
		return queueRepository.findById(id);
	}

	public void delete(QueueModel queue) {
		// TODO Auto-generated method stub
		queueRepository.delete(queue);

	}

}
