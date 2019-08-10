package com.dbs.hacktron.service;

public interface ProcessQueue {

	String consume(long queueId);

	void produce(long queueId, String message, long maxLimit);

}
