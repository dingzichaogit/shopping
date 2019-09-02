package com.hyxy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.hyxy.entity.Picture;
@Mapper
public interface BannerMapper {

	void insert(Map<String, Object> map);

	List<Picture> select();

	void delete(int id);

	List<Picture> selectid(int id);

	void update(Map<String, Object> map);


    

	

	
}