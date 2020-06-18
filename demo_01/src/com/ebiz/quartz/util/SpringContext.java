
package com.ebiz.quartz.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContext implements ApplicationContextAware {
    private static ApplicationContext context = null;

    public SpringContext() {
    }

    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }

    public void setApplicationContext(ApplicationContext applicationcontext) throws BeansException {
        context = applicationcontext;
    }


    /**
     * 实现ApplicationContextAware接口, 注入Context到静态变量中.
     */
    public static void setContext(ApplicationContext context) {
        SpringContext.context = context;
    }


}
