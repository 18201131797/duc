package com.mybatisgenerator;

import com.mybatisgenerator.core.EStyle;
import com.mybatisgenerator.core.MyBatisGeneratorRun;

/**
 * @description:创建实体
 *
 * @author: liwt
 * @date: 2019/8/20 16:25
 * @version: 1.0.1
*/
public class Create {


    public static void main(String[] args) throws Exception {
        MyBatisGeneratorRun app = new MyBatisGeneratorRun();
        if(app.checkCatalog()){
            //创建样式
            app.generator(EStyle.MYBATIS.getAddress());
        }
    }
}
