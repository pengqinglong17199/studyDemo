package com.pql.design.proxy;

public class SignlogService implements ISignlogService {

    private SignlogDao signlogDao;

    public SignlogService(){
        // 假装注入
        signlogDao = new SignlogDao();
    }

    @Override
    public int createOrder(Signlog signlog) {
        System.out.println("service 调用dao保存考勤记录'");
        return signlogDao.insert(signlog);
    }
}
