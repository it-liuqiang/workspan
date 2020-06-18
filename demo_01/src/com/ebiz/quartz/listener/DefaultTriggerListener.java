package com.ebiz.quartz.listener;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;

/**
 * 【类或接口功能描述】
 *
 * @author Administrator
 * @version 1.0
 * @date 2020/4/29
 */
public class DefaultTriggerListener implements TriggerListener {

    protected final Logger logger = Logger.getLogger(this.getClass());

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
    public void triggerComplete(Trigger trigger, JobExecutionContext jobExecutionContext, Trigger.CompletedExecutionInstruction completedExecutionInstruction) {
        logger.info("????????????????");
    }
}
