package com.ebiz.quartz.service.impl;

import com.ebiz.quartz.listener.DefaultTriggerListener;
import com.ebiz.quartz.model.BatchInfo;
import com.ebiz.quartz.model.QuartzJobDTO;
import com.ebiz.quartz.service.QuartzService;
import com.ebiz.quartz.util.QuartzJob;
import com.ebiz.quartz.util.QuartzUtil;
import com.ebiz.quartz.util.SpringContext;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 【类或接口功能描述】
 *
 * @author Administrator
 * @version 1.0
 * @date 2020/6/11
 */
@Service
public class QuartzServiceImpl implements QuartzService {

    @Autowired
    private QuartzUtil quartzUtil;

    @Autowired
    private DefaultTriggerListener defaultTriggerListener;

    public final Logger logger = Logger.getLogger(this.getClass());

    @Override
    public void initScheduler() throws Exception {
         ;
        List<BatchInfo> batchInfoList = buidInfo(new BatchInfo());
        //设置任务信息到quartz
        for (BatchInfo batchInfo : batchInfoList) {
            QuartzJobDTO job = new QuartzJobDTO();
//            String exeParams = batchInfo.getExecuteParameter();
//            if(StringUtils.isNotBlank(exeParams)){
//                job.getJobDataMap().put(QuartzJob.EXECUTE_PARAMETER, exeParams);
//            }

            job.getJobDataMap().put(QuartzJob.OBJECT_NAME, batchInfo.getObjectName());
            job.getJobDataMap().put(QuartzJob.OBJECT_METHOD, batchInfo.getObjectMethod());

            //判断是否以多线程的方式执行任务
            logger.info("单线程执行任务" + batchInfo.getObjectName() + "." + batchInfo.getObjectMethod());
            job.setJobClass(QuartzJob.class);
            job.setCronExpression(batchInfo.getExecuteTime());
            String jobName = batchInfo.getName() +"_" + batchInfo.getId();
            job.getJobDataMap().put(QuartzJob.OBJECT_ID, batchInfo.getObjectMethod());
            job.setJobName(jobName);
            logger.info("----开始部署任务:" + jobName);
            quartzUtil.scheduleCronJob(job);
            logger.info("----成功部署任务:" + jobName);
        }
    }

    private List<BatchInfo> buidInfo(BatchInfo batchInfo) {
        List<BatchInfo> batchInfoList = new ArrayList<>();
        batchInfo.setCreatedDate(new Date());
        batchInfo.setExecuteTime("0 */1 * * * ?");
        batchInfo.setId(1L);
        batchInfo.setIsDelete((short)0);
        batchInfo.setName("这是一个自动采集数据的批");
        batchInfo.setObjectMethod("execute");
        batchInfo.setObjectName("autoJsoupBatch");
        batchInfo.setSuspendFlag("0");

        batchInfoList.add(batchInfo);
        return batchInfoList;
    }

    @Override
    public void reScheduler() throws Exception {

    }
}
