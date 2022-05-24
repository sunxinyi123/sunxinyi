package com.example.text2.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录成功之后有,用户的的session

        Object loginUser=request.getSession().getAttribute("loginUser");//


        if(loginUser==null){//没有登录
            request.setAttribute("msg","没有权限，请先登录");
            request.getRequestDispatcher("/index.html").forward(request,response);//转发request和response

            return false;
        }else {
            return  true;
        }

        //该方法在请求处理之前被调用，若在一个应用中或者一个请求中存在多个Interceptor，
        // 每个Interceptor的调用会根据他的声明顺序依次执行；方法返回Boolean类型，当返回false时，
        // 表示请求结束，后续的Interceptor和Controller将不会再执行，当返回true时，
        // 会据需调用下一个Interceptor的preHandle方法，执行到最后一个Interceptor，就会调用当前请求的控制器方法。

    }


}
