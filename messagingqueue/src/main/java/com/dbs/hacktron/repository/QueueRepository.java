package com.dbs.hacktron.repository;

import org.springframework.stereotype.Repository;

import com.dbs.hacktron.model.QueueModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueueRepository extends CrudRepository<QueueModel,Long> {

}

