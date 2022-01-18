package com.kove.pcstore.jobs;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;


public class ComponentJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context)
            throws JobExecutionException {
        System.out.println("Add component!");
    }

}
