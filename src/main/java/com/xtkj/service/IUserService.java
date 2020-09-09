package com.xtkj.service;

import com.github.pagehelper.PageInfo;
import com.xtkj.pojo.User;
import com.xtkj.utils.JsonResult;

public interface IUserService {

    int addUser(User user);
    int deleteUser(int id);
    int updateUser(User user);
    JsonResult<PageInfo<User>> getUsers(Integer offset,Integer limit);
}
