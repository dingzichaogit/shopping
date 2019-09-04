package com.hyxy.dao;

import com.hyxy.entity.User;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);



	User selectUser(Map<String, String> map);



	User selectu(String username);

	Set<String> getrole(String username);

	Set<String> getPermission(String username);

	

	
}