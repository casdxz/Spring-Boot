package com.bear.boot.task;

import java.util.Random;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.sleep;


/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-04-12 19:43
 **/
public abstract class AbstractTask {
    private static final Random random = new Random();

    public void doTaskOne() throws Exception {
        System.out.println("开始做任务一");
        long start = currentTimeMillis();
        sleep(random.nextInt(1000));
        long end = currentTimeMillis();
        System.out.println("完成任务一，耗时：" + (end -start) + "毫秒");
    }

    public void doTaskTwo() throws Exception {
        System.out.println("开始做任务二");
        long start = currentTimeMillis();
        sleep(random.nextInt(1000));
        long end = currentTimeMillis();
        System.out.println("完成任务二，耗时：" + (end -start) + "毫秒");
    }

    public void doTaskThree() throws Exception {
        System.out.println("开始做任务三");
        long start = currentTimeMillis();
        sleep(random.nextInt(1000));
        long end = currentTimeMillis();
        System.out.println("完成任务三，耗时：" + (end -start) + "毫秒");
    }
}
