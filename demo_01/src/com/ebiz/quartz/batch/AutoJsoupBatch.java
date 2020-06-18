package com.ebiz.quartz.batch;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 【类或接口功能描述】
 *
 * @author Administrator
 * @version 1.0
 * @date 2020/4/28
 */
@Component
public class AutoJsoupBatch {

    public final Logger log = Logger.getLogger(this.getClass());


    public  void execute(){
        Map<String , Object> JsoupDate = new HashMap<>();
        String url500 = "http://kaijiang.500.com/shtml/ssq/";
        try {
            log.info("[批处理][开始从"+url500+"获取本期开奖号码]");
            Document doc = Jsoup.connect(url500).get();
            Element body = doc.body();
            //获取期数
            Element change_date = doc.getElementById("change_date");
            //获取号码
            Elements ball_box01 = doc.getElementsByClass("ball_box01");
            List<String> nums = ball_box01.eachText();
            JsoupDate.put("change_date" , change_date.text());
            JsoupDate.put("nums" , nums);
            // TODO: 2020/4/28  输出
            System.out.println(JsoupDate);
        } catch (IOException e) {
            log.info("[批处理][获取本期号码失败;]"+e);
            //失败记录存表
            e.printStackTrace();
        }

    }









}
