package com.hello.mavenproject.dao;

import com.hello.mavenproject.api.UserInfoDTO;

public interface UserProfileDao {
   public UserInfoDTO loadProfie(String name);
}
