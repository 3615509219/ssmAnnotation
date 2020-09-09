package com.xtkj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xtkj.dao.UserMapper;
import com.xtkj.pojo.User;
import com.xtkj.service.IUserService;
import com.xtkj.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IUserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int addUser(User user) {
        int rows = userMapper.insertSelective(user);
        return rows;
    }

    @Override
    public int deleteUser(int id) {
        int rows = userMapper.deleteByPrimaryKey(id);
        return rows;
    }

    @Override
    public int updateUser(User user) {
        int rows = userMapper.updateByPrimaryKeySelective(user);
        return rows;
    }

    @Override
    public JsonResult<PageInfo<User>> getUsers(Integer offset, Integer limit) {
        PageHelper.offsetPage(offset,limit);
        List<User> users = userMapper.getUsers();
        PageInfo<User> page = new PageInfo<>(users);
        JsonResult<PageInfo<User>> jsonResult = new JsonResult<>();
        jsonResult.setMsg("OK");
        jsonResult.setObj(page);
        jsonResult.setStateCode(200);
        return jsonResult;
    }
}
