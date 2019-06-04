package com.core.express;

import com.alibaba.fastjson.JSONObject;
import com.core.net.NetUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0.0.1
 * @Description:快递100公共类
 * @Author: liwt
 * @date: 2019/5/18 9:39
 */
@Slf4j
public class Express100Util {
    /**
     * 请求参数说明
     * private String key;                    //企业授权key
     * private String company;                //快递公司编码
     * private String number;                 //快递单号
     * private String from;                   //出发地城市
     * private String to;                     //目的地城市
     * private String callbackurl;            //回调地址
     * private String salt;                   //加密串
     * private String resultv2;                  //行政区域解析
     * private String autoCom;                   //单号智能识别
     * private String interCom;                  //开启国际版
     * private String departureCountry;       //出发国
     * private String departureCom;           //出发国快递公司编码
     * private String destinationCountry;     //目的国
     * private String destinationCom;         //目的国快递公司编码
     * private String phone;                  //手机号
     * <p>
     * 请求示例
     * schema=json
     * param={
     * "company":"ems",
     * "number":"em263999513jp",
     * "from":"广东省深圳市南山区",
     * "to":"北京市朝阳区",
     * "key":"XXX ",
     * "parameters":{
     * "callbackurl":"http://www.xxxxx.com/callback",
     * "salt":"nfds09jdfaldfa2wewe823",
     * "resultv2":"1",
     * "autoCom":"1",
     * "interCom"："1",
     * "departureCountry":"CN",
     * "departureCom":"ems",
     * "destinationCountry":"JP",
     * "destinationCom":"japanposten",
     * "phone":"13868688888"
     * }
     * }
     */

    private static Logger logger = Logger.getLogger(Express100Util.class);

    /**
     * 实时查询请求地址
     */
    private static final String SUBSCRIBE_URL = "http://poll.kuaidi100.com/poll";

    private Map<String, String> param;  //快递100订阅请求参数

    /**
     * @param jsonObject 订阅请求参数
     * @Description:快递100初始化请求参数
     * @Author: liwt
     * @date: 2019/5/18 9:39
     */
    private void initParam(JSONObject jsonObject) {
        this.param = new HashMap<String, String>() {{
            put("schema", "json");
            put("param", jsonObject.toJSONString());
        }};
    }

    /**
     * @param key         企业授权key
     * @param company     快递公司编码
     * @param number      快递单号
     * @param callbackurl 回调地址
     * @Description:快递100简版
     * @Author: liwt
     * @date: 2019/5/18 9:39
     */
    public Express100Util(String key, String company, String number, String callbackurl) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key", key);
        jsonObject.put("company", company);
        jsonObject.put("number", number);
        jsonObject.put("parameters", new HashMap<String, String>() {{
            put("callbackurl", callbackurl);
        }});
        initParam(jsonObject);
    }

    /**
     * @param key                企业授权key
     * @param company            快递公司编码
     * @param number             快递单号
     * @param from               出发地城市
     * @param to                 目的地城市
     * @param callbackurl        回调地址
     * @param salt               加密串
     * @param resultv2           行政区域解析
     * @param autoCom            单号智能识别
     * @param interCom           开启国际版
     * @param departureCountry   出发国
     * @param departureCom       出发国快递公司编码
     * @param destinationCountry 目的国
     * @param destinationCom     目的国快递公司编码
     * @param phone              手机号
     * @Description:快递100完整版
     * @Author: liwt
     * @date: 2019/5/18 9:39
     */
    public Express100Util(String key, String company, String number, String from, String to,
                          String callbackurl, String salt, String resultv2, String autoCom, String interCom,
                          String departureCountry, String departureCom, String destinationCountry,
                          String destinationCom, String phone) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key", key);
        jsonObject.put("company", company);
        jsonObject.put("number", number);
        jsonObject.put("from", from);
        jsonObject.put("to", to);
        jsonObject.put("parameters", new HashMap<String, String>() {{
            put("callbackurl", callbackurl);
            put("salt", salt);
            put("resultv2", resultv2);
            put("autoCom", autoCom);
            put("interCom", interCom);
            put("departureCountry", departureCountry);
            put("departureCom", departureCom);
            put("destinationCountry", destinationCountry);
            put("destinationCom", destinationCom);
            put("phone", phone);
        }});
        initParam(jsonObject);
    }

    /**
     * @Description:订阅
     * @Author: liwt
     * @date: 2019/5/18 9:39
     */
    public Boolean subscribe() {
        String result = NetUtil.request(SUBSCRIBE_URL, this.param, "POST");
        log.info("express return: " + result);
        Map<String, Object> map = (Map) JSONObject.parse(result);
        return (Boolean) map.get("result");
    }


    public static void main(String[] args) {
        Express100Util express100Util = new Express100Util("fJtsBpfL5820", "zhongtongkuaiyun", "542952733398", "http://xshell.51vip.biz/api-member-web/express/callback.do?cid=2&id=1129633424575959040");
        System.out.print(express100Util.subscribe());
    }
}
