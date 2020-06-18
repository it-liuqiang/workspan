package com.ebiz.quartz.jsoup;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * 【类或接口功能描述】
 *
 * @author Administrator
 * @version 1.0
 * @date 2020/4/28
 */
public class JsoupUtils {

    private static Logger logger = Logger.getLogger(JsoupUtils.class);



    public static void getDoc(String url){
        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            logger.info("获取 "+url+" 页面内容失败:" + e.getMessage());
            e.printStackTrace();
        }
        //获取body
        Element body = document.body();
        System.out.println(body);
    }
    public static void main(String[] args){
//        getDoc("https://www.ebohailife.net/");
    }




}
