//package com.example.text2.dao;
//
//import com.example.text2.pojo.Department;
//import com.example.text2.pojo.Employee;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//@Repository
//public class EmployeeDao {
//
//    private  static Map<Integer, Employee> employees=null;//模拟
//    @Autowired
//    private  DepartmentDao departmentDao;
//    static {
//        employees=new HashMap<Integer, Employee>();//创建一个部门表
//        employees.put(101,new Employee(101,"孙新益","2278031485@qq.com",1,new Department(101,"后期部")));
//        employees.put(102,new Employee(102,"sx","2278031485@qq.com",1,new Department(102,"后期部")));
//        employees.put(103,new Employee(103,"sx","2278031485@qq.com",1,new Department(102,"后期部")));
//        employees.put(104,new Employee(104,"sx","2278031485@qq.com",1,new Department(102,"后期部")));
//        employees.put(105,new Employee(105,"sx","2278031485@qq.com",1,new Department(102,"后期部")));
//    }
//    // 主键自增
//    private static Integer initId=1006;
//    //增加一个员工
//    public  void save(Employee employee){
//        if(employee.getId()==null){
//            employee.setId(initId++);
//        }
//        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
//        employees.put(employee.getId(),employee);
//
//    }
//    //查询全部员工信息
//    public Collection<Employee> getAll(){
//        return employees.values();
//    }
//    //通过ID查询员工
//    public  Employee getEmployeeById(Integer id){
//        return employees.get(id);
//    }
//    //删除员工
//    public void  delete(Integer initId){
//        employees.remove(initId);
//    }
//
//
//}
