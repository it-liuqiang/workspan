package com.ebiz.quartz.util;

import com.ebiz.quartz.listener.DefaultTriggerListener;
import com.ebiz.quartz.model.QuartzJobDTO;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.CronTriggerBean;
import org.springframework.scheduling.quartz.JobDetailBean;
import org.springframework.scheduling.quartz.SimpleTriggerBean;
import org.springframework.stereotype.Component;


@Component
public class QuartzUtil {

    @Autowired
	private Scheduler scheduler;

	public void scheduleCronJob(QuartzJobDTO quartzJobDTO) throws Exception {

		// 创建一个job
		JobDetailBean jobDetail = createJobDetail(quartzJobDTO);
		scheduler.addJob(jobDetail, true);

		// 创建一个定时器
		CronTriggerBean trigger = new CronTriggerBean();
		trigger.setCronExpression(quartzJobDTO.getCronExpression());
		trigger.setJobDetail(jobDetail);
		trigger.setName(quartzJobDTO.getJobName());
		trigger.setJobName(jobDetail.getName());
		trigger.setMisfireInstruction(CronTriggerBean.MISFIRE_INSTRUCTION_DO_NOTHING);
		trigger.addTriggerListener(DefaultTriggerListener.TRIGGER_LISTENER_NAME);
		scheduler.scheduleJob(trigger);
	}

	public void scheduleSimpleJob(QuartzJobDTO quartzJobDTO) throws Exception {
		// 创建一个job
		JobDetailBean jobDetail = createJobDetail(quartzJobDTO);
		scheduler.addJob(jobDetail, true);
		// 创建一个定时器
		SimpleTriggerBean trigger = new SimpleTriggerBean();
		trigger.setRepeatCount(quartzJobDTO.getRepeatCount());
		trigger.setRepeatInterval(quartzJobDTO.getRepeatInterval());
		trigger.setStartTime(quartzJobDTO.getStartTime());
		trigger.setStartDelay(quartzJobDTO.getStartDelay());
		trigger.setJobDetail(jobDetail);
		trigger.setName(quartzJobDTO.getJobName());
		trigger.setJobName(jobDetail.getName());
		scheduler.scheduleJob(trigger);
	}

	public void cancelJob(String jobName) throws Exception {
		scheduler.pauseTrigger(jobName, Scheduler.DEFAULT_GROUP);
		scheduler.unscheduleJob(jobName, Scheduler.DEFAULT_GROUP);
		scheduler.deleteJob(jobName, Scheduler.DEFAULT_GROUP);
	}

	public void rescheduleJob(QuartzJobDTO quartzJobDTO) throws Exception {
		// 创建一个job
		JobDetailBean jobDetail = createJobDetail(quartzJobDTO);
		scheduler.addJob(jobDetail, true);
		
		// 创建一个定时器
		CronTriggerBean trigger = new CronTriggerBean();
		trigger.setCronExpression(quartzJobDTO.getCronExpression());
		trigger.setJobDetail(jobDetail);
		trigger.setName(quartzJobDTO.getJobName());
		trigger.setJobName(jobDetail.getName());
		scheduler.rescheduleJob(trigger.getName(), Scheduler.DEFAULT_GROUP, trigger);
	}

	public String[] getJobNames() throws Exception {
		return scheduler.getJobNames(Scheduler.DEFAULT_GROUP);
	}
	
	/**
	 * 新建一个JobDetail
	 * @param quartzJobDTO
	 * @return
	 */
	private JobDetailBean createJobDetail(QuartzJobDTO quartzJobDTO) {
		//创建一个job
		JobDetailBean jobDetail = new JobDetailBean();
		jobDetail.setName(quartzJobDTO.getJobName());
		jobDetail.setJobClass(quartzJobDTO.getJobClass());
		jobDetail.getJobDataMap().putAll(quartzJobDTO.getJobDataMap());
		return jobDetail;
	}
}
