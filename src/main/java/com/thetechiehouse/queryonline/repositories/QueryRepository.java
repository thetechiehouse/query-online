package com.thetechiehouse.queryonline.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.thetechiehouse.queryonline.entity.DBQuery;

public interface QueryRepository extends
		PagingAndSortingRepository<DBQuery, Long> {
	DBQuery create(DBQuery dbQuery);

	DBQuery update(DBQuery dbQuery);

	void remove(String id);

	int getNumberOfDBQueries();

	List<DBQuery> getAllDBQuries();

	DBQuery createNewQuery(DBQuery dbQuery);

	DBQuery getById(String id);
}
