package com.dbs.hacktron.service;

public interface ProcessQueue {

	String consume(long queueId);

	String add(long queueId, String message, long maxLimit);

	String remove(long queueId);

}
