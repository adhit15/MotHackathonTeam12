package com.dbs.hacktron.service.impl;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import com.dbs.hacktron.model.QueueModel;
import com.dbs.hacktron.service.ProcessQueue;

public class TestServices {

	public static void main(String[] args) {
		QueueModel model = new QueueModel(1, "My Queue", 3, null);
		Queue<String> queue = new ArrayBlockingQueue<String>(3);
		model.setMessage(queue);
		
		ProcessQueue pQueue = new ProcessQueueImpl();
		CallProcessQueue consume = new CallProcessQueue(pQueue, false);
		CallProcessQueue produce = new CallProcessQueue(pQueue, true);
		
		Thread t1 = new Thread(consume);
		Thread t2 = new Thread(produce);
		t1.start();
		t2.start();
	}
}

class CallProcessQueue implements Runnable{
	ProcessQueue pQueue = null;
	boolean operation = false;
	
	public CallProcessQueue(ProcessQueue pQueue, boolean operation){
		this.pQueue = pQueue;
		this.operation = operation;
	}
	
	@Override
	public void run() {
		pQueue.initial();
		for(int i=1; i<=3; i++){
			if(this.operation){
				pQueue.produce(1, "Hi" + i, 3);
			}else{
				pQueue.consume(1);
			}
		}
	}
	
}

