package com.bear.boot.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-04-12 19:45
 **/
@Component
public class ScheduledJobs {

    /**
     *方法执行完成后，5秒在开始执行定时任务
     *
     * @throws InterruptedException 中断异常
     */
    //@Scheduled(fixedDelay = 5000)
    //public void fixedDelayJob() throws InterruptedException {
    //    System.out.println("fixedDelay 开始:" + new Date());
    //    Thread.sleep(10 * 1000);
    //    System.out.println("fixedDelay 结束:" + new Date());
    //}

    /**
     *  每隔3秒执行 定时任务
     * @throws InterruptedException
     */
    @Scheduled(fixedRate = 3000)
    public void fixedRateJob() throws InterruptedException {
        System.out.println("===========fixedRate 开始:" + new Date());
        Thread.sleep(5 * 1000);
        System.out.println("===========fixedRate 结束:" + new Date());
    }

    /**
     * 每隔10秒执行 定时任务
     */
    //@Scheduled(cron = "0/10 * * * * ?")
    //public void cron() {
    //    System.out.println("========================= ...>>cron...." + new Date());
    //}
}
