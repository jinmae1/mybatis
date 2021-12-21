package com.kh.emp.model.service;

import static com.kh.common.SqlSessionTemplate.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.emp.model.dao.EmpDao;

public class EmpServiceImpl implements EmpService {

	private EmpDao empDao;

	public EmpServiceImpl(EmpDao empDao) {
		this.empDao = empDao;
	}

	@Override
	public List<Map<String, Object>> selectEmpMapList() {
		SqlSession session = getSqlSession();
		List<Map<String, Object>> empMap = empDao.selectEmpMapList(session);
		session.close();
		return empMap;
	}
	
	
}