package com.pql.design.strategy.spring;

import lombok.Getter;
import lombok.Setter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class DispatcherServlet extends HttpServlet {

    private List<Handler> handlerMapping = new ArrayList<>();

    public void init(){
        try{
            // 假装通过扫描得出controller 以及注解上的url和方法
            Class<UserController> userControllerClass = UserController.class;
            handlerMapping.add(new Handler()
                    .setController(userControllerClass.newInstance())
                    .setMethod(userControllerClass.getMethod("login")).setUrl("user/login"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doDispatch(HttpServletRequest request, HttpServletResponse response){
        // 获取用户请求的url
        String requestURI = request.getRequestURI();

        // servlet拿到url后要做权衡
        // 通过用户请求的url 找到对应的controller以及方法

        // 通过获取的url去做handlerMapping (假装他是策略常量)
        Handler handler = null;
        for (Handler temp : handlerMapping) {
            if(requestURI.equals(temp.getUrl())){
                handler = temp;
                break;
            }
        }

        // 将具体的任务分发给method 通过反射
        Object object = null;
        try{
            object = handler.getMethod().invoke(handler.getController(), request.getParameterMap());
        }catch (Exception e){
            e.printStackTrace();
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

    class Handler{
        private Object controller;
        private Method method;
        private String url;

        public Object getController() {
            return controller;
        }

        public Handler setController(Object controller) {
            this.controller = controller;
            return this;
        }

        public Method getMethod() {
            return method;
        }

        public Handler setMethod(Method method) {
            this.method = method;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Handler setUrl(String url) {
            this.url = url;
            return this;
        }
    }

}
