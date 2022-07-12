package com.bootjpa.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootjpa.test.mapper.TestMapper;
import com.bootjpa.test.vo.TestVo;

@Service
public class TestService {
	
	@Autowired
	public TestMapper mapper;
	
	public List<TestVo> selectTest(){
		return mapper.selectTest();
	}
}
