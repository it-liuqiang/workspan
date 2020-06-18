/**
 * Copyright ®2012 Ebiz-Interactive Co. Ltd.<br/>
 * All rights reserved.<br/>
 * Package:  com.guohualife.platform.base.test<br/>
 * FileName: BaseTester.java<br/>
 * Description: Ebiz-Platform<br/>
 */
package com.ebiz.base;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;


/**
 * 【类或接口功能描述】
 *
 * @author jinhao 
 * @date 2012-11-13 
 * @version 1.0
 */
@ContextConfiguration(locations = "file:/WEB-INF/applicationContext.xml")
public class BaseTester extends AbstractJUnit4SpringContextTests {
    
    public BaseTester(){
        String userdir = System.getProperty("user.dir");
        if (userdir.indexOf("WebRoot")<0){
            System.setProperty("user.dir", System.getProperty("user.dir")+"/WebRoot");
        }
        StringBuffer a = new StringBuffer();
        a.append(System.getProperty("user.dir"));
        a.append("/WEB-INF/log4j.properties");
        PropertyConfigurator.configure(  a.toString() );
    }
    
}

	