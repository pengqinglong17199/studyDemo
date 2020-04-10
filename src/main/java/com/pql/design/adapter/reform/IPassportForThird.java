package com.pql.design.adapter.reform;

/**
 * 第三方登录兼容接口
 * */
public interface IPassportForThird {

    ResultMsg loginForQQ(String id);

    ResultMsg loginForWechat(String id);

    ResultMsg loginForToekn(String token);

    ResultMsg loginForTelphone(String telphone, String code);

    ResultMsg loginForRegister(String username, String passport);
}
