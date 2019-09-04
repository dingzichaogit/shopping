package com.hyxy.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hyxy.entity.User;

public interface LoginService {

User selectuser(Map<String, String> map);

User selectu(String username);

Set<String> getrole(String username);

Set<String> getPermission(String username);

	





	
	

}
