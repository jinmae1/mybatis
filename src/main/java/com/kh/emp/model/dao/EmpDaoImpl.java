package com.kh.emp.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class EmpDaoImpl implements EmpDao {

	@Override
	public List<Map<String, Object>> selectEmpMapList(SqlSession session) {
		return session.selectList("emp.selectEmpMapList");
	}

}
