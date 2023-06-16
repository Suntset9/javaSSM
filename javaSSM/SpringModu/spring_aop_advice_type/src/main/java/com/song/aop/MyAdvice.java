package com.song.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.net.SocketTimeoutException;

//@component：  标注一个类为Spring容器的Bean，（把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>）
@Component
//@Aspect表明这是一个切面类
@Aspect
public class MyAdvice {
    //设置切入点 切入点表达式标准格式：动作关键字(访问修饰符  返回值  包名.类/接口名.方法名(参数) 异常名）
    @Pointcut("execution(void com.song.dao.BookDao.update())")
    private void updatept(){};
    //切入点二 会去寻找这个方法，如果格式不对，找不到这个方法就不会执行这里的东西 注意返回值等
    @Pointcut("execution(int com.song.dao.BookDao.select())")
    private void selectPt(){}

    //@before 前置通知 原始方法运行前执行
    @Before("updatept()")
    public void before(){
        System.out.println("before advice");
    }

    //@After 后置通知，在原始方法运行之后执行
    //@After("selectPt()")
    public void after(){
        System.out.println("After advice");
    }

   /**
    * @Around 环绕通知 常用！ 在原始方法运行的前后执行
    *   ProceedingJoinPoint 继承了 JoinPoint。是在JoinPoint的基础上暴露出 proceed 这个方法。
    *   proceed很重要，这个是aop代理链执行的方法。 --调用原始方法需要使用这个
    *   返回值：Object
    *      注意事项：
    * 1. 环绕通知方法形参必须是ProceedingJoinPoint，表示正在执行的连接点，使用该对象的proceed()方法表示对原始对象方法进行调用，返回值为原始对象方法的返回值。
    * 2. 环绕通知方法的返回值建议写成Object类型，用于将原始对象方法的返回值进行返回，哪里使用代理对象就返回到哪里。
    *
    * */
    //@Around("selectPt()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around before advice ...");
        //表示对原始方法调用，不知道是否异常，所以强制捕获或者抛出异常，避免出现异常而不知道
        //方法有返回值，可以将返回值传递给变量然后打印
        Object proceed = pjp.proceed();

        System.out.println("around after advice ...");
        //对参数等进行返回 原始方法返回值为viod 得到的为null
        return proceed;
    }


    /**
     * @AfterReturning：返回后通知，在原始方法执行完毕后运行，且原始方法执行过程中未出现异常现象
     *
     */
    @AfterReturning("selectPt()")
    public void afterreturning(){
        System.out.println("afterReturning advice ...");
    }

    /**
     *  @AfterThrowing：抛出异常后通知，在原始方法执行过程中出现异常后运行
     */
    @AfterThrowing("selectPt()")
    public void afterThrowing() {
        System.out.println("afterThrowing advice ...");
    }
}
