package com.bjpowernode.util;

public class ServiceFactory {
    //传递zs对象，得到ls对象的过程
    public static Object getService(Object service){
        return new TransactionInvocationHandler(service).getProxy();
    }
}
