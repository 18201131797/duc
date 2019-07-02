package com.core.email;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.error.PebbleException;
import com.mitchellbosecke.pebble.template.PebbleTemplate;
import jetbrick.template.JetEngine;
import jetbrick.template.JetTemplate;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0.0.0
 * @Description:
 * @Author: liwt
 * @date: 2019/7/2 13:28
 */

public class Example {
    // 该邮箱修改为你需要测试的邮箱地址
    private static final String TO_EMAIL = "920526770@qq.com";
    static {
        // 配置，一次即可

        OhMyEmail.config(OhMyEmail.SMTP_163(false), "18201131797@163.com", "lwt920526770");
        // 如果是企业邮箱则使用下面配置
        //OhMyEmail.config(SMTP_ENT_QQ(false), "xxx@qq.com", "*******");
    }

    /**
     * 测试发送HTML
     * @throws SendMailException
     */
    public static void testSendHtml() throws SendMailException{
        OhMyEmail.subject("这是一封测试HTML邮件")
                .from("发件人的邮箱")
                .to(TO_EMAIL)
                .html("<h1 font=red>信件内容</h1>")
                .send();
    }

    /**
     * 测试发送TXT
     * @throws SendMailException
     */
    public static void testSendText() throws SendMailException{
        OhMyEmail.subject("这是一封测试TEXT邮件")
                .from("发件人的邮箱")
                .to(TO_EMAIL)
                .text("信件内容")
                .send();
    }

    /**
     * 测试发送附件
     * @throws SendMailException
     */
    public static void testSendAttach() throws SendMailException{
        OhMyEmail.subject("这是一封测试附件邮件")
                .from("发件人的邮箱")
                .to(TO_EMAIL)
                .html("<h1 font=red>信件内容</h1>")
                .attach(new File("/Users/biezhi/Downloads/hello.jpeg"), "测试图片.jpeg")
                .send();
    }

    /**
     * 测试发送附加URL
     * @throws SendMailException
     * @throws MalformedURLException
     */
    public static void testSendAttachURL() throws SendMailException, MalformedURLException{
        OhMyEmail.subject("这是一封测试网络资源作为附件的邮件")
                .from("发件人的邮箱")
                .to(TO_EMAIL)
                .html("<h1 font=red>信件内容</h1>")
                .attachURL(new URL("https://pics4.baidu.com/feed/55e736d12f2eb938cb08e6e7ac489430e5dd6f69.jpeg?token=946bb426f81626cf4d9a7b174a5f1649&s=776B925460D272750E9FDFAF0300E00E"), "测试图片.jpeg")
                .send();
    }

    /**
     * 测试发送html模版
     * @throws IOException
     * @throws PebbleException
     * @throws SendMailException
     */
    public static void testPebble() throws IOException, PebbleException, SendMailException {
        PebbleEngine engine           = new PebbleEngine.Builder().build();
        PebbleTemplate compiledTemplate = engine.getTemplate("register.html");

        Map<String, Object> context = new HashMap<String, Object>();
        context.put("username", "biezhi");
        context.put("email", "admin@biezhi.me");

        Writer writer = new StringWriter();
        compiledTemplate.evaluate(writer, context);

        String output = writer.toString();
        System.out.println(output);

        OhMyEmail.subject("这是一封测试Pebble模板邮件")
                .from("发件人的邮箱")
                .to(TO_EMAIL)
                .html(output)
                .send();
    }

    /**
     * 测试发送jetx模版
     * @throws IOException
     * @throws PebbleException
     * @throws SendMailException
     */
    public static void testJetx() throws SendMailException{

        JetEngine engine   = JetEngine.create();
        JetTemplate template = engine.getTemplate("/register.jetx");

        Map<String, Object> context = new HashMap<String, Object>();
        context.put("username", "biezhi");
        context.put("email", "admin@biezhi.me");
        context.put("url", "<a href='http://biezhi.me'>https://biezhi.me/active/asdkjajdasjdkaweoi</a>");

        StringWriter writer = new StringWriter();
        template.render(context, writer);
        String output = writer.toString();
        System.out.println(output);

        OhMyEmail.subject("这是一封测试Jetx模板邮件")
                .from("发件人的邮箱")
                .to(TO_EMAIL)
                .html(output)
                .send();
    }

    public static void main(String[] args) throws Exception{
        testSendHtml();
    }
}
