package com.song.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component//定义bean
@Aspect//声明切面类
public class DataAdvice {

    //切入点：作用于所有服务层下面的带两个参数的方法
    @Pointcut("execution(boolean com.song.service.*Service.*(*,*))")
    private void servicePt(){}

    /**
     *  if (args[i].getClass().equals(String.class)) getclass获取参数类型，equals判断是否字符串类型
     * @param pjp
     * @return
     * @throws Throwable
     */
   // @Around("DataAdvice.servicePt()")//配置环绕通知
   //public Object trimStr(ProceedingJoinPoint pjp) throws Throwable {
   //     Object[] args = pjp.getArgs();//获取到方法的参数列表
   //     for (int i = 0; i < args.length; i++) {
   //         if (args[i].getClass().equals(String.class)){
   //             args[i]=args[i].toString().trim();
   //         }
   //     }
   //     Object ret = pjp.proceed(args);
   //
   //
   //     return ret;
   // }

    @Around("DataAdvice.servicePt()") //定义环绕通知切点
    public Object trimStr(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs(); //获取被通知方法的参数列表
        Object[] newArgs = new Object[args.length]; //创建一个新的参数列表，长度等于原参数列表长度
        for (int i = 0; i < args.length; i++) { //遍历原参数列表
            Object arg = args[i]; //获取当前参数值
            if (arg instanceof String) { //如果参数类型是String
                newArgs[i] = ((String) arg).trim(); //对字符串参数去掉前后空格，并存入新参数列表
            } else { //如果参数类型不是String
                newArgs[i] = arg; //直接将参数值存入新参数列表
            }
        }
        return pjp.proceed(newArgs); //使用新参数列表执行被通知方法，并返回执行结果
    }

}
