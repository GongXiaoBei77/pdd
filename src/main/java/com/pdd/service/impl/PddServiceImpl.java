package com.pdd.service.impl;

import com.pdd.mapper.PddMapper;
import com.pdd.model.Pdd;
import com.pdd.service.PddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GongXiaoBei
 */
@Service
public class PddServiceImpl implements PddService {
	@Autowired
	private PddMapper pddMapper;
	
	@Override
	public List<Pdd> findAll() {
		return pddMapper.selectByAll();
	}
	
	@Override
	public int removeById(int[] ids) {
		int i = 0;
		for (int id : ids) {
			i+= pddMapper.deleteByPrimaryKey(id);
		}
		return i;
	}
	
	@Override
	public List<Pdd> findByTypeN(String typeN) {
		return pddMapper.selectByTypeN(typeN);
	}
}
