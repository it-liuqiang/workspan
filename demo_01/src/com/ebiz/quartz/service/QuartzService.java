package com.ebiz.quartz.service;

import org.springframework.stereotype.Service;

/**
 * 【类或接口功能描述】
 *
 * @author Administrator
 * @version 1.0
 * @date 2020/6/11
 */
@Service
public interface QuartzService {
    //初始化
    public void initScheduler() throws Exception;

    //重新调度
    public void reScheduler() throws Exception;
}
