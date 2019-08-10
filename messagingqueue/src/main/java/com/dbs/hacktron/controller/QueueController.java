package com.dbs.hacktron.controller;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.hacktron.model.Queue;
import com.dbs.hacktron.service.QueueServiceImpl;
import com.dbs.hacktron.service.impl.ProcessQueueImpl;

/**
 * Controller to process all the request
 * @author rbathini
 *
 */
@RestController
public class QueueController { 
	@Autowired
	private QueueServiceImpl queueService;

	@Autowired
	private ProcessQueueImpl processQueue;

	@GetMapping(value = "/queue/all")
	public List<Queue> getAllQueues() {
		return queueService.getAllQueues();
	}

	@GetMapping(value = "/queue/{id}")
	public Queue getQueueById(@PathVariable Long id) {
		return queueService.getQueueById(id);
	}

	@PostMapping(value = "/queue/add")
	@CrossOrigin
	public Queue addNewQueue(@RequestBody Queue queue) {
		System.out.println("In que post::" + queue.getQid());
		return queueService.addNewQueue(queue);
	}

	@PutMapping(value = "/queue/update")
	public Queue updateQueue(@RequestBody Queue queue) {
		return queueService.updateQueue(queue);
	}

	@GetMapping(value = "/queue/delete/{id}")
	public void deleteQueueById(@PathVariable Long queueId) {
		queueService.deleteQueueById(queueId);
	}

	@GetMapping(value = "/queue/deleteAll")
	public void deleteAllQueues() {
		queueService.deleteAllQueues();
	}

	@GetMapping(value = "/consume/{id}")
	public String consume(@PathVariable Long id) {
		return processQueue.consume(id);
	}

	@GetMapping(value = "/remove/{id}")
	public String remove(@PathVariable Long id) {
		return processQueue.remove(id);
	}

	@GetMapping(value = "/produce/{queueId}/{message}/{maxLimit}")
	public String produce(@PathVariable Long queueId, @PathVariable String message, @PathVariable Long maxLimit) {
		return processQueue.add(queueId, message, maxLimit);
	}

	@GetMapping(value = "/browse/{queueId}")
	public ArrayBlockingQueue<String> produce(@PathVariable Long queueId) {
		return processQueue.browse(queueId);
	}

}
