package com.zmy.study.rx;

import java.util.concurrent.Executors;

/**
 * Created by lings on 2018/3/22.
 */

public class Schedulers {
    private static final Scheduler ioScheduler = new Scheduler(Executors.newSingleThreadExecutor());
    public static Scheduler io() {
        return ioScheduler;
    }
}
