package com.mars.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by david on 2015-01-20.
 */
public class SampleJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {

        System.out.println("quartz定时任务");
    }
}
