package com.dbs.hacktron.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.hacktron.model.QueueModel;
import com.dbs.hacktron.service.QueueService;

@RestController
public class QueueController {
	
	@Autowired
	private QueueService queueService;
	
	@GetMapping(value = "/getQueaus")
	public List<QueueModel> getAllQueues() {
		return queueService.getAllQueues();
	}
}
