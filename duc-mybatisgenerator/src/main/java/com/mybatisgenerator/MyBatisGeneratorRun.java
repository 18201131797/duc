package com.mybatisgenerator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) throws Exception {
        MyBatisGeneratorRun app = new MyBatisGeneratorRun();
        System.out.println(app.getClass().getResource("/").getPath());
        System.out.println(System.getProperty("user.dir"));
        app.generator(EStyle.MYBATIS.getAddress());
    }

    public void generator(String conf) throws Exception {

        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(conf);
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(resourceAsStream);

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);

        for (String warning : warnings) {
            System.out.println(warning);
        }
    }

}
