package com.ebiz.quartz.listener;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;
import org.springframework.stereotype.Component;

/**
 * 【类或接口功能描述】
 *
 * @author Administrator
 * @version 1.0
 * @date 2020/4/29
 */
@Component
public class DefaultTriggerListener implements TriggerListener {

    protected final Logger logger = Logger.getLogger(this.getClass());
    /**
     * 触发器监听器名称,必须保持唯一性
     */
    public static final String TRIGGER_LISTENER_NAME = "defaultTriggerListener";
    @Override
    public String getName() {
        return null;
    }

    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext jobExecutionContext) {
        logger.info("????????????????");
    }

    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext jobExecutionContext) {
        return false;
    }

    @Override
    public void triggerMisfired(Trigger trigger) {
        logger.info("????????????????");
    }

    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext jobExecutionContext, int i) {
        logger.info("????????????????");
    }


}
