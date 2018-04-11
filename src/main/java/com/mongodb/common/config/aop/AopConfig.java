package com.mongodb.common.config.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

/*
* 类描述：
* @auther linzf
* @create 2018/4/11 0011 
*/
@Aspect
@Component
public class AopConfig {

    // 用@Pointcut来注解一个切入方法
    @Pointcut("execution(* com.mongodb.sys.dao.*.*(..))")
    public void executeDao() {
    }

    @AfterReturning(value = "execution(* com.mongodb.sys.dao..*.*(..)) ",returning = "keys")
    public void doAfterReturningAdvice1(JoinPoint joinPoint, Object keys){

        //System.out.println("第一个后置返回通知的返回值："+keys);
    }

    @AfterReturning(value = "execution(* com.mongodb.sys.dao..*.*(..))",returning = "keys",argNames = "keys")
    public void doAfterReturningAdvice2(String keys){

        //System.out.println("第二个后置返回通知的返回值："+keys);
    }

}
