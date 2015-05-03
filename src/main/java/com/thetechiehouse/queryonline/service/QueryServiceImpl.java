package com.thetechiehouse.queryonline.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thetechiehouse.queryonline.entity.DBQuery;
import com.thetechiehouse.queryonline.repositories.QueryRepository;
import com.thetechiehouse.queryonline.vo.QueryVO;

@Service("dbQueryService")
public class QueryServiceImpl implements QueryService {

	@Autowired
	private QueryRepository queryRepository;

	public QueryServiceImpl() {

	}

	public QueryServiceImpl(QueryRepository dbQueryRepository) {
		this.queryRepository = dbQueryRepository;
	}

	@Override
	public List<QueryVO> getAllDBQuries() {
		List<QueryVO> queryVOs = new ArrayList<QueryVO>();
		List<DBQuery> dbQuerys = (List<DBQuery>) this.queryRepository.findAll();
		if (dbQuerys != null) {
			for (DBQuery dbQuery : dbQuerys) {
				QueryVO queryVO = new QueryVO();
				BeanUtils.copyProperties(dbQuery, queryVO);
				queryVOs.add(queryVO);
			}
		}

		return queryVOs;
	}

	@Override
	public QueryVO getById(String id) {

		DBQuery dbQuery = this.queryRepository.getById(id);
		QueryVO queryVO = new QueryVO();
		BeanUtils.copyProperties(dbQuery, queryVO);
		return queryVO;
	}

	@Override
	public QueryVO createNewQuery(QueryVO queryVO) {
		DBQuery dbQuery = new DBQuery();
		String id = UUID.randomUUID().toString();
		queryVO.setId((id));
		BeanUtils.copyProperties(queryVO, dbQuery);
		dbQuery = this.queryRepository.create(dbQuery);
		BeanUtils.copyProperties(dbQuery, queryVO);

		return queryVO;
	}

	@Override
	public QueryVO update(QueryVO queryVO) {
		DBQuery dbQuery = new DBQuery();
		BeanUtils.copyProperties(queryVO, dbQuery);
		dbQuery = this.queryRepository.update(dbQuery);
		BeanUtils.copyProperties(dbQuery, queryVO);

		return queryVO;
	}

	@Override
	public void remove(String id) {
		this.queryRepository.remove(id);
	}

	@Override
	public int getNumberOfDBQueries() {
		return this.queryRepository.getNumberOfDBQueries();
	}
}
