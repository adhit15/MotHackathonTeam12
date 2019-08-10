package com.dbs.hacktron.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.hacktron.model.Queue;
import com.dbs.hacktron.service.ProcessQueue;
import com.dbs.hacktron.service.QueueServiceImpl;

@RestController
public class QueueController {

	@Autowired
	private QueueServiceImpl queueService;

	@Autowired
	private ProcessQueue processQueue;

	@GetMapping(value = "/queue/all")
	public List<Queue> getAllQueues() {
		return queueService.getAllQueues();
	}

	@GetMapping(value = "/queue/{id}")
	public Queue getQueueById(@PathVariable int id) {
		return queueService.getQueueById(id);
	}

	@PostMapping(value = "/queue/add")
	public Queue addNewQueue(@RequestBody Queue queue) {
		System.out.println("In que post::" + queue.getQid());
		return queueService.addNewQueue(queue);
	}

	@PutMapping(value = "/queue/update")
	public Queue updateQueue(@RequestBody Queue queue) {
		return queueService.updateQueue(queue);
	}

	@GetMapping(value = "/queue/delete/{id}")
	public void deleteQueueById(@PathVariable int queueId) {
		queueService.deleteQueueById(queueId);
	}

	@GetMapping(value = "/queue/deleteAll")
	public void deleteAllQueues() {
		queueService.deleteAllQueues();
	}

	@GetMapping(value = "/consume/{id}")
	public void consume(@PathVariable long id) {
		processQueue.consume(id);
	}

	@GetMapping(value = "/produce/{queueId}/{message}/{maxLimit}")
	public void produce(long queueId, String message, long maxLimit) {
		processQueue.produce(queueId, message, maxLimit);
	}
}
