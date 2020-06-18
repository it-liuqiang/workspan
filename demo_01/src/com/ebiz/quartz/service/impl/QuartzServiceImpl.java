package com.ebiz.quartz.service.impl;

import com.ebiz.quartz.model.BatchInfo;
import com.ebiz.quartz.service.QuartzService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 【类或接口功能描述】
 *
 * @author Administrator
 * @version 1.0
 * @date 2020/6/11
 */

public class QuartzServiceImpl implements QuartzService {
    public final Logger log = Logger.getLogger(this.getClass());
    @Override
    public void initScheduler() throws Exception {
        log.info("开始部署");
        //获取批处理配置信息
        List<BatchInfo> batchInfoList = null;
        buidInfo(batchInfoList);
        //设置任务信息到quartz
        if (!CollectionUtils.isEmpty(batchInfoList)){



        }
        //开始部署
        log.info("部署成功");
    }

    private void buidInfo(List<BatchInfo> batchInfoList) {
        BatchInfo batchInfo = new BatchInfo();
        batchInfo.setCreatedDate(new Date());
        batchInfo.setExecuteTime("* * * * * ? *");
        batchInfo.setId(null);
        batchInfo.setIsDelete((short)0);
        batchInfo.setName("测试");
        batchInfo.setObjectMethod("execute");
        batchInfo.setObjectName("autoJsoupBatch");
        batchInfo.setSuspendFlag("0");
        batchInfoList.add(batchInfo);
    }

    @Override
    public void reScheduler() throws Exception {

    }
}
