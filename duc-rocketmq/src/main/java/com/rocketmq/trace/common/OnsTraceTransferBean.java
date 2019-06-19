package com.rocketmq.trace.common;

import java.util.HashSet;
import java.util.Set;


/**
 * @version 1.0.0.0
 * @Description:
 * @Author: liwt
 * @date: 2019/6/19 11:06
 */
public class OnsTraceTransferBean {
    private String transData;
    private Set<String> transKey = new HashSet<String>();


    public String getTransData() {
        return transData;
    }


    public void setTransData(String transData) {
        this.transData = transData;
    }


    public Set<String> getTransKey() {
        return transKey;
    }


    public void setTransKey(Set<String> transKey) {
        this.transKey = transKey;
    }
}
