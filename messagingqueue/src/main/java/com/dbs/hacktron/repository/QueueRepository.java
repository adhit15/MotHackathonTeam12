package com.dbs.hacktron.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dbs.hacktron.model.Queue;


@Repository
public class QueueRepository {
	List<Queue> queueList = new ArrayList<Queue>();
	
	public List<Queue> getAllQueues() {
		return queueList;
	}
}
