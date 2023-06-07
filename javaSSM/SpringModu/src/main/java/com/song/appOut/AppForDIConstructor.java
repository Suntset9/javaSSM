package com.song.appOut;

import com.song.sevice.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForDIConstructor {
    /**
     * 构造器注入
     * @param args
     */
    public static void main( String[] args ) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService) ctx.getBean("bookService02");
        bookService.save();
        //在同一个类里面-注入的类型和参数一样使用构造器跟set，构造方法传入跟set注入等有冲突，因为有关联，这种情况下set注入和构造注入选择一种即可
        //还跟前面的一些di入门案例等冲突了，理解会用即可
        ctx.registerShutdownHook();

        /**
         * 依赖注入方式选择：
         * 1. 强制依赖使用构造器进行，使用setter注入有概率不进行注入导致null对象出现
         * 2. 可选依赖使用setter注入进行，灵活性强
         * 3. Spring框架倡导使用构造器，第三方框架内部大多数采用构造器注入的形式进行数据初始化，相对严谨
         * 4. 如果有必要可以两者同时使用，使用构造器注入完成强制依赖的注入，使用setter注入完成可选依赖的注入
         * 5. 实际开发过程中还要根据实际情况分析，如果受控对象没有提供setter方法就必须使用构造器注入
         * 6. **==自己开发的模块推荐使用setter注入==**
         */
    }
}
