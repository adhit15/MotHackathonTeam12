package com.dbs.hacktron.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dbs.hacktron.model.Queue;

@Repository
public interface QueueRepository extends CrudRepository<Queue, Long> {

}
