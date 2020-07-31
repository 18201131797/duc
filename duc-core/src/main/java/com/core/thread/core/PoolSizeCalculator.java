package com.core.thread.core;

import java.math.BigDecimal;

public class PoolSizeCalculator {


    private static final int availableProcessors = new BigDecimal(Runtime.getRuntime().availableProcessors()).intValue();

    private PoolSizeCalculator() {
    }

    /**
     *@description:CPU密集型最佳线程数
     *
     *@param
     *@author liwt
     *@date 2020/7/31 11:28
     *@return
     *@version 1.0.1
     */
    public static int CPUConcentrated() {
        return availableProcessors + 1;
    }

    /**
     *@description:IO密集型最佳线程数
     *
     *@param
     *@author liwt
     *@date 2020/7/31 11:28
     *@return
     *@version 1.0.1
     */
    public static int IOConcentrated() {
        return (int) Math.floor(availableProcessors / (1 - 0.9));
    }
}