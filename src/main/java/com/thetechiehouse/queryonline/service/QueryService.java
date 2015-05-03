package com.thetechiehouse.queryonline.service;

import java.util.List;

import com.thetechiehouse.queryonline.vo.QueryVO;

public interface QueryService {

	List<QueryVO> getAllDBQuries();

	QueryVO getById(String id);

	QueryVO createNewQuery(QueryVO queryVO);

	QueryVO update(QueryVO queryVO);

	void remove(String id);

	int getNumberOfDBQueries();
}
