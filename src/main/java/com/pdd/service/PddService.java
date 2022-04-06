package com.pdd.service;

import com.pdd.model.Pdd;

import java.util.List;

/**
 * @author GongXiaoBei
 */
public interface PddService {
	List<Pdd> findAll();
	
	int removeById(int[] ids);
	
	List<Pdd> findByTypeN(String typeN);
}
