package com.example.text2.controller;

import com.example.text2.pojo.Course;
import com.example.text2.pojo.User;
import com.example.text2.service.CourseService;
import com.example.text2.util.GeneralResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

        private CourseService courseService;
    @GetMapping("/courses")
    //全部改成success方便前端判断统一规则
    public GeneralResponse courses() {

        GeneralResponse response=new GeneralResponse();
        response.setSuccess(true);
        response.setData(courseService.getAllCourses());
        return response;

    }
    @PostMapping("/course/add")
    public  GeneralResponse add(@RequestParam String courseName,@RequestParam String  teacherName) {
        Course course=new Course();
       course.setCourseName(courseName);
       course.setTeacherName(teacherName);

        GeneralResponse response=new GeneralResponse();
        response.setSuccess(true);
        response.setData( courseService.add(course));

        return response;
    }
}
