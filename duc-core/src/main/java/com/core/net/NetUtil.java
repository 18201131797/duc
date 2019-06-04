package com.core.net;

import java.io.*;
import java.net.*;
import java.util.Enumeration;
import java.util.Map;


/**
 * @author liwt
 * @version 1.0.0
 * @description: 与网路相关的工具集合
 * @date 2016年9月29日 下午3:09:07
 */
public class NetUtil {

    public static String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";


    /**
     * get方法直接调用post方法
     *
     * @param url 网络地址
     * @return 返回网络数据
     */
    public static String get(String url) {
        return request(url, null, "GET");
    }

    /**
     * @param url
     * @param param
     * @description: 设定post方法获取网络资源, 如果参数为null, 实际上设定为get方法
     * @author liwt
     * @date 2019年5月19日 下午5:46:56
     * @version 1.0.0.1
     */
    public static String post(String url, Map<String, String> param) {
        return request(url, param, "POST");
    }

    /**
     * @param strUrl
     * @param params
     * @descriptions get方式提交
     * @date 2016年10月3日 下午9:10:05
     * @author liwt
     * @version 1.0.0.1
     */
    public static String get(String strUrl, Map params) {
        return request(strUrl, params, "GET");
    }

    /**
     * @param strUrl
     * @param params
     * @param method POST or GET
     * @description: 请求
     * @author liwt
     * @date 2019年5月19日 下午5:39:50
     * @version 1.0.0.1
     */
    @SuppressWarnings("unchecked")
    public static String request(String strUrl, Map params, String... method) {
        String md = method.length == 0 ? "GET" : method[0];
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        String rs = null;
        try {
            StringBuffer sb = new StringBuffer();
            if (md == null || md.equals("GET")) {
                strUrl = strUrl + "?" + urlencode(params);
            }
            URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            if (md == null || md.equals("GET")) {
                conn.setRequestMethod("GET");
            } else {
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
            }
            conn.setRequestProperty("User-agent", userAgent);
            conn.setUseCaches(false);
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);
            conn.setInstanceFollowRedirects(false);
            conn.connect();
            if (params != null && md.equals("POST")) {
                try {
                    DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                    out.writeBytes(urlencode(params));
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
            InputStream is = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sb.append(strRead);
            }
            rs = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return rs;
    }

    //将map型转为请求参数型
    public static String urlencode(Map<String, Object> data) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue() + "", "UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }


    /**
     * @return
     * @description: 获取本机IP地址信息
     * @author liwt
     * @date 2016年9月29日 下午3:08:41
     * @version 1.0.0.1
     */
    public static String getLocalIP() {
        String address = "";
        try {
            Enumeration<?> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ine = null;
            while (allNetInterfaces.hasMoreElements() && address.equals("")) {
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                if (!netInterface.isVirtual()) {
                    Enumeration<?> addresses = netInterface.getInetAddresses();
                    while (addresses.hasMoreElements() && address.equals("")) {
                        ine = (InetAddress) addresses.nextElement();
                        if (ine != null && ine instanceof Inet4Address) {
                            if (!ine.getHostAddress().equals("127.0.0.1") && !netInterface.isVirtual()) {
                                address = ine.getHostAddress();
                                break;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return address.trim();
    }


}
