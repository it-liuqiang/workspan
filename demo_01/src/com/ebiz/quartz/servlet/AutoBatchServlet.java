package com.ebiz.quartz.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.ebiz.quartz.service.QuartzService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 【类或接口功能描述】
 *
 * @author Administrator
 * @version 1.0
 * @date 2020/4/28
 */
public class AutoBatchServlet extends HttpServlet {


    private QuartzService quartzService;

    public void setQuartzService(QuartzService quartzService) {
        this.quartzService = quartzService;
    }

    public final Logger log = Logger.getLogger(this.getClass());

    @Override
    public void destroy() {
        System.out.println("servlet容器销毁");
        super.destroy();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问成功 doget");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request , response);
    }

    @Override
    public void init() throws ServletException {
        log.info("批处理开始加载");
        //获取批处理任务
        // 取spring容器中的任务调度服务bean
        try {
            //通过servlet初始化加载部署某些配置信息
            quartzService.initScheduler();
        } catch (Exception e) {
            log.info("批处理加载失败，请手动加载！\n" + e.getMessage());
        }
    }
}
