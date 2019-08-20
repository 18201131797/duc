package com.mybatisgenerator.core;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *@description:生成实体
 *
 *@param
 *@author liwt
 *@date 2019/8/20 14:28
 *@return
 *@version 1.0.1
 */
public class MyBatisGeneratorRun {

    //数据库驱动地址
    private String driveAddress = System.getProperty("user.dir") + File.separator + "duc-mybatisgenerator" + File.separator + "src" +
            File.separator + "main" + File.separator + "resources" + File.separator + "lib" + File.separator + "mysql-connector-java-5.1.9.jar";

    private String sourceAddress;

    /**
     *@description:检测目录是否存在
     *
     *@param
     *@author liwt
     *@date 2019/8/20 16:15
     *@return
     *@version 1.0.1
    */
    public boolean checkCatalog() throws IOException {
        InputStream in = MyBatisGeneratorRun.class.getClassLoader().getResourceAsStream("conf.properties");//类装载器方式获取输入流
        Properties pro = new Properties();//实例化
        pro.load(in);//装载属性
        String path = pro.getProperty("duc.source.address");//得到需要的属性
        if(new File(path).isDirectory()){
            this.sourceAddress = path;
           return true;
        }
        System.err.println("------------------------------warning-----------------------------");
        System.err.println(path);
        System.err.println("目录不存在");
        System.err.println("请创建目录或修改conf.properties文件下：duc.source.address属性");
        System.err.println("------------------------------------------------------------------");
        return false;
    }

    public void generator(String conf) throws Exception {

        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(conf);
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(resourceAsStream);
        //设置数据库驱动地址
        config.addClasspathEntry(driveAddress);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);

        System.err.println("------------------------------info-----------------------------");
        System.err.println("创建成功!");
        System.err.println("地址："+this.sourceAddress);
        System.err.println("------------------------------------------------------------------");
    }

}
