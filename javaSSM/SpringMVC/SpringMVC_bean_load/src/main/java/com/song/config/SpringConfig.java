package com.song.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@Configuration
//@ComponentScan({"com.itheima.service","com.itheima.dao"})
//设置spring配置类加载bean时的过滤规则，当前要求排除掉表现层对应的bean
//excludeFilters属性：设置扫描加载bean时，排除的过滤规则
//includeFilters 加载指定的bean，需要指定类别（type）与具体项（classes）
//type属性：设置排除规则，当前使用按照bean定义时的注解类型进行排除
//classes属性：设置排除的具体注解类，当前设置排除@Controller定义的bean
@ComponentScan(value = "com.song",
        excludeFilters = @ComponentScan.Filter(//排除web里Controller的bean，里面配置不生效，页面什么的也无反应
                type = FilterType.ANNOTATION
                ,classes = Controller.class
        )
)
public class SpringConfig {
}
