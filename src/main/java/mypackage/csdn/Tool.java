package mypackage.csdn;


import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * 1.创建HttpUtil类来写一个简单的http请求方法，访问地址
 */
public class Tool {
//    获取页面数据
    public static String doGet(String url) {
        String body = "";
        //连接
        HttpClient httpClient = HttpClientBuilder.create().build();
//        HttpClientParams.setCookiePolicy(httpClient.getParams(), CookiePolicy.BROWSER_COMPATIBILITY);
        //请求
        HttpGet httpGet = new HttpGet(url);
        //设置浏览器代理
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36");
        try{
            //响应
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            body = EntityUtils.toString(httpEntity, Consts.UTF_8);
//            System.out.println("body:"+body);
//
//                parse(body);

            //释放连接
            httpGet.releaseConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return body;
    }

    //    获取页面数据
    public static String doGet2(String url) {
        String body = "";
        //连接
        HttpClient httpClient = HttpClientBuilder.create().build();
//        HttpClientParams.setCookiePolicy(httpClient.getParams(), CookiePolicy.BROWSER_COMPATIBILITY);
        //请求
        HttpGet httpGet = new HttpGet(url);
        //设置浏览器代理
//        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36");
        //设置头部信息进行模拟登录（添加登录后的Cookie）
        httpGet.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        httpGet.setHeader("Accept-Encoding", "gzip, deflate, br");
        httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
        httpGet.setHeader("Cookie", "uuid_tt_dd=10_20287725960-1588951416633-590605; dc_session_id=10_1588951416633.880931; Hm_lvt_6bcd52f51e9b3dce32bec4a3997715ac=1590220264,1590220287,1590225963,1590226013; Hm_up_6bcd52f51e9b3dce32bec4a3997715ac=%7B%22islogin%22%3A%7B%22value%22%3A%221%22%2C%22scope%22%3A1%7D%2C%22isonline%22%3A%7B%22value%22%3A%221%22%2C%22scope%22%3A1%7D%2C%22isvip%22%3A%7B%22value%22%3A%220%22%2C%22scope%22%3A1%7D%7D; Hm_ct_6bcd52f51e9b3dce32bec4a3997715ac=6525*1*10_20287725960-1588951416633-590605!1788*1*PC_VC!5744*1*weixin_42063820; __gads=ID=d460cd5602291e9a:T=1588951421:S=ALNI_MaTnTUhWDra-JkAPYiNEtJdtxPYPg; Hm_lvt_e5ef47b9f471504959267fd614d579cd=1589170767,1589330979,1590198258; Hm_up_e5ef47b9f471504959267fd614d579cd=%7B%22islogin%22%3A%7B%22value%22%3A%221%22%2C%22scope%22%3A1%7D%2C%22isonline%22%3A%7B%22value%22%3A%221%22%2C%22scope%22%3A1%7D%2C%22isvip%22%3A%7B%22value%22%3A%220%22%2C%22scope%22%3A1%7D%7D; Hm_ct_e5ef47b9f471504959267fd614d579cd=6525*1*10_20287725960-1588951416633-590605!5744*1*weixin_42063820; UserName=weixin_42063820; UserInfo=e3d1be4f33a947d0b2b28ef52034c8bf; UserToken=e3d1be4f33a947d0b2b28ef52034c8bf; UserNick=scanner%E5%B0%8F%E9%9C%B8%E7%8E%8B; AU=3E3; UN=weixin_42063820; BT=1589185121492; p_uid=U000000; Hm_lvt_c072e0d113e6b5841848d39d71a2c580=1589986977,1589987791; Hm_up_c072e0d113e6b5841848d39d71a2c580=%7B%22islogin%22%3A%7B%22value%22%3A%221%22%2C%22scope%22%3A1%7D%2C%22isonline%22%3A%7B%22value%22%3A%221%22%2C%22scope%22%3A1%7D%2C%22isvip%22%3A%7B%22value%22%3A%220%22%2C%22scope%22%3A1%7D%7D; Hm_ct_c072e0d113e6b5841848d39d71a2c580=5744*1*weixin_42063820!6525*1*10_20287725960-1588951416633-590605; dc_sid=faa3e6e27335667818b3a387df227bd0; c_ref=https%3A//blog.csdn.net/weixin_42063820; c_first_ref=www.baidu.com; c_first_page=https%3A//bbs.csdn.net/topics/392258425; dc_tos=qas2ap; Hm_lpvt_6bcd52f51e9b3dce32bec4a3997715ac=1590226083; TY_SESSION_ID=e0d20f69-1888-440d-8a40-0f2a4726dbf0; c_utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-7.nonecase; Hm_lpvt_e5ef47b9f471504959267fd614d579cd=1590198258; __yadk_uid=fLj06DvtaHDa4f3aDhhqRFvKIi68F9vZ; announcement=%257B%2522isLogin%2522%253Atrue%252C%2522announcementUrl%2522%253A%2522https%253A%252F%252Fbss.csdn.net%252Fm%252Ftopic%252Flive_recruit%253Futm_source%253Dannounce0515%2522%252C%2522announcementCount%2522%253A0%252C%2522announcementExpire%2522%253A3600000%257D");
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:68.0) Gecko/20100101 Firefox/68.0");
        try{
            //响应
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            body = EntityUtils.toString(httpEntity, Consts.UTF_8);
//            System.out.println("body:"+body);
//
//                parse(body);

            //释放连接
            httpGet.releaseConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return body;
    }

//    获取a标签
    public static Elements parse(String html) {
        //解析html获取Document
        Document doc= Jsoup.parse(html);
        //获取spu
        Elements eles=doc.select("article>a");
        return eles;
    }
}

