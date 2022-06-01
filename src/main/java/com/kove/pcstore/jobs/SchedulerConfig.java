package com.kove.pcstore.jobs;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedulerConfig {

    @Bean
    public JobDetail testJobDetail() {
        return JobBuilder.newJob(ComponentJob.class).withIdentity("componentJob")
                .storeDurably().build();
    }

    @Bean
    public Trigger testJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(5).repeatForever();
        return TriggerBuilder.newTrigger().forJob(testJobDetail())
                .withIdentity("testTrigger").withSchedule(scheduleBuilder).build();
    }


    
}
