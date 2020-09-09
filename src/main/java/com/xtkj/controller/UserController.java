package com.xtkj.controller;

import com.github.pagehelper.PageInfo;
import com.xtkj.pojo.User;
import com.xtkj.service.IUserService;
import com.xtkj.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/index")
    @ResponseBody
    public JsonResult<PageInfo<User>> main(@RequestParam(value = "pageNumber") Integer offset, @RequestParam(value = "pageSize") Integer limit) {
        JsonResult<PageInfo<User>> users = userService.getUsers(offset, limit);
        return users;
    }

    @RequestMapping("/add")
    @ResponseBody
    public ModelAndView addUser(User user){
        ModelAndView m = new ModelAndView();

        int rows = userService.addUser(user);
        if (rows>0){
            m.setViewName("index");
        }
        return m;
    }
    @RequestMapping("/delete")
    @ResponseBody
    public ModelAndView delete(int tbUserid){
        ModelAndView m = new ModelAndView();
        int rows = userService.deleteUser(tbUserid);
        if (rows>0){
            m.setViewName("index");
        }
        return m;
    }
    @RequestMapping("/update")
    @ResponseBody
    public ModelAndView update(User user){
        ModelAndView m = new ModelAndView();
        int rows = userService.updateUser(user);
        if (rows>0){
            m.setViewName("index");
        }
        return m;
    }
}
