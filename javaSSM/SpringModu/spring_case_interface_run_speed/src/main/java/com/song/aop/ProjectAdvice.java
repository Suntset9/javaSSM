package com.song.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component//声明为组件，交给spring管理
@Aspect//声明切面类
public class ProjectAdvice {
    //匹配业务层的所有方法
    @Pointcut("execution(* com.song.service.*Service.*(..))")
    private void servicePt(){}

    //设置环绕通知，在原始操作的运行前后记录执行时间
    @Around("ProjectAdvice.servicePt()") //本类类名可以省略不写
    public void runSpeed(ProceedingJoinPoint pjp) throws Throwable {
        //获取执行的签名对象
        Signature signature = pjp.getSignature();
        //获取接口/类全限定名
        String className = signature.getDeclaringTypeName();
        //获取方法名
        String methodName = signature.getName();
        //记录开始时间
        long start = System.currentTimeMillis();
        //执行万次操作
        for (int i = 0; i < 10000; i++) {
           pjp.proceed();
        }
        //记录结束时间
        long end = System.currentTimeMillis();
        //打印执行结果
        System.out.println("万次执行："+ className+"."+methodName+"---->" +(end-start) + "ms");
    }
}