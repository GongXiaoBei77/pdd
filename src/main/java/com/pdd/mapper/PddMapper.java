package com.pdd.mapper;

import com.pdd.model.Pdd;

import java.util.List;

public interface PddMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Pdd record);

    int insertSelective(Pdd record);

    Pdd selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Pdd record);

    int updateByPrimaryKey(Pdd record);
	
	List<Pdd> selectByAll();
    
    List<Pdd> selectByTypeN(String typeN);
}