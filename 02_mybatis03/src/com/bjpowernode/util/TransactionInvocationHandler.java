package com.bjpowernode.util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransactionInvocationHandler implements InvocationHandler {
    private Object target;
    public TransactionInvocationHandler(Object target){
        this.target = target;
    }
    //代理类的业务方法
    //ls的表白方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SqlSession session = null;
        Object obj = null;
        try {
            session = SqlSessionUtil.getSession();
            //处理业务逻辑
            //zs的表白方法 method.invoke
            obj = method.invoke(target, args);
            //处理业务逻辑完毕后，提交事务
            session.commit();

        /*SqlSessionUtil util = new SqlSessionUtil();
        util.getSession();*/
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            SqlSessionUtil.myClose(session);
        }
        return  obj;
    }
    public Object getProxy(){
        //取得代理类对象，ls对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
