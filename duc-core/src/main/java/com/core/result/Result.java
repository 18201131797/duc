package com.core.result;

import com.alibaba.fastjson.JSONObject;
import lombok.Builder;
import lombok.Data;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0.0.0
 * @Description: 返回结果
 * @Author: liwt
 * @date: 2019/5/29 17:00
 */
@Data
@Builder
public class Result {

    //返回数据
    private static Map result;

    private boolean success;
    private String msg;
    private Object data;

    /**
     * @version 1.0.0.0
     * @Description: 返回成功
     * @Author: liwt
     * @date: 2019/5/29 17:00
     */
    public static Result resultSuccess() {
        return Result.builder().success(true).build();
    }

    /**
     * @version 1.0.0.0
     * @Description: 返回成功
     * @Author: liwt
     * @date: 2019/5/29 17:00
     */
    public static Result resultSuccess(Integer code, Object data) {
        return Result.builder().success(true).msg(getMsg(code)).data(data).build();
    }

    /**
     * @version 1.0.0.0
     * @Description: 返回成功
     * @Author: liwt
     * @date: 2019/5/29 17:00
     */
    public static Result resultSuccess(Integer code) {
        return Result.builder().success(true).msg(getMsg(code)).build();
    }

    /**
     * @version 1.0.0.0
     * @Description: 返回失败
     * @Author: liwt
     * @date: 2019/5/29 17:00
     */
    public static Result resultFail() {
        return Result.builder().success(false).build();
    }

    /**
     * @version 1.0.0.0
     * @Description: 返回自定义结果
     * @Author: liwt
     * @date: 2019/5/29 17:00
     */
    public static Result result(boolean success, Integer code, Object data) {
        return Result.builder().success(success).msg(getMsg(code)).data(data).build();
    }

    /**
     * @version 1.0.0.0
     * @Description: 返回自定义结果
     * @Author: liwt
     * @date: 2019/5/29 17:00
     */
    public static Result result(boolean success, Integer code) {
        return Result.builder().success(success).msg(getMsg(code)).build();
    }


    /**
     * @version 1.0.0.0
     * @Description: 根据code获取msg
     * @Author: liwt
     * @date: 2019/5/29 17:00
     */
    public static String getMsg(Integer code) {
        String result = null;
        try {
            File file = ResourceUtils.getFile("classpath:result.properties");
            Map<String, String> resultMap = readFile(file.getPath());
            result = resultMap.get(code.toString());
        } catch (Exception ex) {

        }
        return result;
    }

    /**
     * @version 1.0.0.0
     * @Description: 读取文件 result.properties
     * @Author: liwt
     * @date: 2019/5/29 17:00
     */
    public static Map<String, String> readFile(String path) throws IOException {
        // 使用一个字符串集合来存储文本中的路径 ，也可用String []数组
        Map<String, String> map = new HashMap<>();
        FileInputStream fis = new FileInputStream(path);
        // 防止路径乱码   如果utf-8 乱码  改GBK     eclipse里创建的txt  用UTF-8，在电脑上自己创建的txt  用GBK
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line = "";
        while ((line = br.readLine()) != null) {
            String[] strs = line.split("=");
            if (strs != null && strs.length == 2) {
                map.put(strs[0], strs[1]);
            }
        }
        br.close();
        isr.close();
        fis.close();
        return map;
    }

    public static void main(String[] args) {
        System.out.printf(JSONObject.toJSONString(Result.resultSuccess(10000)));
    }
}
