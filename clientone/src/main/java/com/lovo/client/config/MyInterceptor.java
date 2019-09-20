package com.lovo.client.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        boolean bl=false;
        //从session获取用户对象
        Object obj=request.getSession().getAttribute("user");
        //判断用户是否存在
        if(null!=obj){
            bl=true;
        }else {

            PrintWriter pw = response.getWriter();
              pw.println("dddddd");
            pw.flush();
            pw.close();
        }
        return bl;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
