package com.hyxy.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyxy.dao.BannerMapper;
import com.hyxy.entity.Picture;

@Service
public class BannerServiceImpl implements BannerService{
@Autowired
private BannerMapper BannerMapper;
	@Override
	public void insert(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
		BannerMapper.insert(map);
	}
	@Override
	public List<Picture> select() {
		// TODO Auto-generated method stub
		List<Picture> list=BannerMapper.select();
		return list;
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		BannerMapper.delete(id);
	}
	@Override
	public List<Picture> selectid(int id) {
		// TODO Auto-generated method stub
		List<Picture> list=BannerMapper.selectid(id);
		return list;
	}
	@Override
	public void update(Map<String, Object> map) {
		// TODO Auto-generated method stub
		BannerMapper.update(map);
	}
	
}




	


	


