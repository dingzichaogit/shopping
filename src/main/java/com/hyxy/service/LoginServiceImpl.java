package com.hyxy.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyxy.dao.UserMapper;
import com.hyxy.entity.User;

@Service
public class LoginServiceImpl implements LoginService {
	
	
@Autowired
	private UserMapper UserMapper;

@Override
public User selectuser(Map<String, String> map) {
 User user=UserMapper.selectUser(map);
	
	return user;
}

@Override
public User selectu(String username) {
	User user =UserMapper.selectu(username);
	// TODO Auto-generated method stub
	return user;
}

@Override
public Set<String> getrole(String username) {
	// TODO Auto-generated method stub
	return UserMapper.getrole(username);
}

@Override
public Set<String> getPermission(String username) {
	// TODO Auto-generated method stub
	return UserMapper.getPermission(username);
}




	


	

}
