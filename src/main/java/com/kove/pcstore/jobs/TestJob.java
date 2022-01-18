/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kove.pcstore.jobs;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class TestJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context)
            throws JobExecutionException {
        System.out.println("Your job has successfully executed!");
    }

}
