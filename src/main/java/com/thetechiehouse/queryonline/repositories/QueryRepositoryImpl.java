package com.thetechiehouse.queryonline.repositories;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.thetechiehouse.queryonline.entity.DBQuery;

@Repository
public class QueryRepositoryImpl implements QueryRepository {
	@Autowired
	MongoTemplate mongoTemplate;
	static final Logger logger = LoggerFactory
			.getLogger(QueryRepositoryImpl.class);

	public QueryRepositoryImpl() {
	}

	public List<DBQuery> getAll() {
		return mongoTemplate.findAll(DBQuery.class);
	}

	@Override
	public DBQuery create(DBQuery dbQuery) {
		mongoTemplate.insert(dbQuery);
		return dbQuery;
	}

	@Override
	public DBQuery update(DBQuery dbQuery) {
		mongoTemplate.save(dbQuery);
		return this.getById(dbQuery.getId());
	}

	@Override
	public DBQuery getById(String id) {
		Query query5 = new Query();
		query5.addCriteria(Criteria.where("id").gte(id));
		// TODO Auto-generated method stub

		List<DBQuery> users = mongoTemplate.find(query5, DBQuery.class);
		if (users.size() > 0)
			return users.get(0);
		else
			return null;
	}

	@Override
	public void remove(String id) {
		mongoTemplate.findAndRemove(new Query(Criteria.where("id").is(id)),
				DBQuery.class);
	}

	@Override
	public int getNumberOfDBQueries() {
		return this.getAll().size();
	}

	@Override
	public List<DBQuery> getAllDBQuries() {
		return getAll();
	}

	@Override
	public DBQuery createNewQuery(DBQuery user) {
		return create(user);
	}

	@Override
	public Iterable<DBQuery> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<DBQuery> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends DBQuery> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends DBQuery> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DBQuery findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<DBQuery> findAll() {
		List<DBQuery> results = mongoTemplate.findAll(DBQuery.class);
		return results;
	}

	@Override
	public Iterable<DBQuery> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(DBQuery entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends DBQuery> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
