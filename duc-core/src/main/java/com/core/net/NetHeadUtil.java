package com.core.net;

import lombok.Data;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0.0.0
 * @Description: http请求带请求头
 * @Author: liwt
 * @date: 2019/7/5 10:47
 */

public class NetHeadUtil {

    public static HashMap<String, String> pMap;

    public static String bearer;

    private NetHeadUtil(){}

    /**
     * @return
     * @description: 设置请求头属性
     * @author liwt
     * @date 2019/7/5 10:47
     * @version 1.0.0.1
     */
    public static Map<String, String> setProperty() {
        if (pMap != null) {
            return pMap;
        }
        pMap = new HashMap<>();
        pMap.put("accept", "application/json");
        pMap.put("authorization", bearer);

        return pMap;
    }

    /**
     * @return
     * @description: 发送get请求
     * @author liwt
     * @date 2019/7/5 10:47
     * @version 1.0.0.1
     */
    public static String sendGet(String url) {


        String result = null;
        CloseableHttpClient httpclient = null;
        CloseableHttpResponse response = null;
        try {
            if (url.startsWith("https")) {
                SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, new TrustStrategy() {
                    public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {//信任所有
                        return true;
                    }
                }).build();
                SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
                httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
            } else {
                httpclient = HttpClients.createDefault();
            }


            HttpGet httpGet = new HttpGet(url);

            // 设置通用的请求属性
            for (Map.Entry<String, String> entry : setProperty().entrySet()) {
                httpGet.setHeader(entry.getKey(), entry.getValue());
            }
            response = httpclient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                result = EntityUtils.toString(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                EntityUtils.consumeQuietly(response.getEntity());
            }
        }
        return result;
    }
}
