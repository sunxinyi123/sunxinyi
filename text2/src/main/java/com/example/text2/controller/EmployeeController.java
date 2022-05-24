package com.example.text2.controller;

//import com.example.text2.dao.DepartmentDao;
//import com.example.text2.dao.EmployeeDao;
import com.example.text2.dao.UserDao;
//import com.example.text2.pojo.Department;
//import com.example.text2.pojo.Employee;
import com.example.text2.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
//    @Autowired
//    EmployeeDao employeeDao;
//
//
//
//
//    @Autowired
//    DepartmentDao departmentDao;


    @Autowired
    UserDao userDao;
//    @RequestMapping("/emps")
//    public String list(Model model){//model 用于返回前端
//        Collection<Employee> employees=employeeDao.getAll();//获取所有的员工
//        model.addAttribute("emps",employees);
//        return "emp/list";
//    }

    @GetMapping("/userse")
    public  String user(Model model){
        Collection<User> users=userDao.getAll();
        model.addAttribute("userse",users);
        return "emp/user";
    }


//    @GetMapping("/emp")
//    public String toAddpage(Model model){
//        //查出所有部门的信息
//        Collection<Department> departments=departmentDao.getDepartments();
//        model.addAttribute("departments",departments);
//        return "emp/add";
//    }
//    @PostMapping("/emp")
//    public String addEmp(Employee employee){//接受前端传来的员工
//        //增加
//        employeeDao.save(employee);//调用底层业务保存员工信息
//        return "redirect:emps";
//    }
//    //去到员工修改页面
//    public  String toUpdateEmp(){
//        return "emp/update";
//    }
}
