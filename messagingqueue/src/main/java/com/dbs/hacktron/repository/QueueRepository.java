package com.dbs.hacktron.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import org.springframework.stereotype.Repository;

import com.dbs.hacktron.model.QueueModel;


@Repository
public class QueueRepository {
	List<QueueModel> queueList = new ArrayList<QueueModel>();
	
	public List<QueueModel> getAllQueues() {
		return queueList;
	}
}
