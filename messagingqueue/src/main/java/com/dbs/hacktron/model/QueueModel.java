package com.dbs.hacktron.model;

import java.util.Queue;

public class QueueModel {

	long queueId;
	String queueName;
	long maxLimit;
	Queue<String> message;
	String messageStatus="N";

	public QueueModel(long queueId, String queueName, long maxLimit, Queue<String> message) {
		super();
		this.queueId = queueId;
		this.queueName = queueName;
		this.maxLimit = maxLimit;
		this.message = message;
	}

	public long getQueueId() {
		return queueId;
	}

	public void setQueueId(long queueId) {
		this.queueId = queueId;
	}

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public long getMaxLimit() {
		return maxLimit;
	}

	public String getMessageStatus() {
		return messageStatus;
	}

	public void setMessageStatus(String messageStatus) {
		this.messageStatus = messageStatus;
	}

	public void setMaxLimit(long maxLimit) {
		this.maxLimit = maxLimit;
	}

	public Queue<String> getMessage() {
		return message;
	}

	public void setMessage(Queue<String> message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "QueueModel [queueId=" + queueId + ", queueName=" + queueName + ", maxLimit=" + maxLimit + ", message="
				+ message + "]";
	}

}
