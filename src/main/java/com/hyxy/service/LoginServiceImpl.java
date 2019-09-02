package com.hyxy.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyxy.dao.UserMapper;
import com.hyxy.entity.User;

@Service
public class LoginServiceImpl implements LoginService {
	
	
@Autowired
	private UserMapper UserMapper;

@Override
public List<User> selectuser(Map<String, String> map) {
  List<User> list=UserMapper.selectUser(map);
	
	return list;
}




	


	

}
