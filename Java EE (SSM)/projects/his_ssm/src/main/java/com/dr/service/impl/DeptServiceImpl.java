package com.dr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dr.mapper.DeptMapper;
import com.dr.pojo.Dept;
import com.dr.service.DeptService;
@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	DeptMapper deptMapper;

	public List<Dept> findDeptList() {
		return deptMapper.findDeptList();
	}

}
