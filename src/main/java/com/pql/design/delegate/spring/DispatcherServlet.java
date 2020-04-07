package com.pql.design.delegate.spring;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {

    private void doDispatch(HttpServletRequest request, HttpServletResponse response){
        String requestURI = request.getRequestURI();
        if("user/login".equals(requestURI)){
            new UserController().login();
        }else if("user/logout".equals(requestURI)){
            new UserController().logout();
        }else if ("worker/create".equals(requestURI)){
            new WorkerController().create();
        }else if ("worker/delete".equals(requestURI)){
            new WorkerController().delete();
        }else{
            System.out.println("404 not found~");
        }
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response){
        try{
            doDispatch(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
