package com.enjoy.mapper;

import com.enjoy.entity.Users;

import java.util.List;

public interface UserMapper {
    List<Users> selectAll();
    Users selectByName(String username);
}
