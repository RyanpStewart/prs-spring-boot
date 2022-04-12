package com.prs.prsspringboot.data;



import org.springframework.data.repository.CrudRepository;

import com.prs.prsspringboot.business.*;

import java.util.List;

public interface RequestRepository extends CrudRepository<Request, Integer> {

		List<Request> findByUser(User user);
		List<Request> findByStatusAndUserNot(String status, User user);
		
}