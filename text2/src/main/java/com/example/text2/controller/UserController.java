package com.example.text2.controller;

import com.example.text2.dao.UserDao;
import com.example.text2.pojo.User;
import com.example.text2.service.UserService;
import com.example.text2.util.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//
@RestController
//@Controller
public class UserController {
    @Autowired

    private UserService userService;



    @GetMapping("/users")
    //全部改成success方便前端判断统一规则
    public  GeneralResponse users() {

        GeneralResponse response=new GeneralResponse();
        response.setSuccess(true);
        response.setData(userService.getAllUsers());
        return response;

    }


    @PostMapping("/user/add")
    public  GeneralResponse add(@RequestParam String name, @RequestParam int password, @RequestParam String classNo, int sex) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setClassNo(classNo);
        user.setSex(sex);

        GeneralResponse response=new GeneralResponse();
        response.setSuccess(true);
        response.setData( userService.add(user));

        return response;
    }

    @PutMapping("/user/update")
    public  GeneralResponse update(@RequestParam String name, @RequestParam int password, @RequestParam String classNo, int sex,@RequestParam int id) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        user.setClassNo(classNo);
        user.setSex(sex);
        GeneralResponse response=new GeneralResponse();
        response.setSuccess(true);
        response.setData(userService.update(user));
        return response;

    }

    @PostMapping("/user/delete")//根据ID号删除
    public  GeneralResponse delete(@RequestParam int id) {

        GeneralResponse response=new GeneralResponse();
        response.setSuccess(true);
        response.setData(userService.deleteById(id));
        return response;
    }
    @GetMapping("/user")//根据ID更新
    public GeneralResponse userById(@RequestParam int id) {

        GeneralResponse response=new GeneralResponse();
        response.setSuccess(true);
        List<User> result=new ArrayList<>();
        result.add(userService.getById(id));
        response.setData(result);
        return response;
    }

}
