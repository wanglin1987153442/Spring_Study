package com.Spring_Study.webx.util;

import com.Spring_Study.webx.entity.Bili;
import com.Spring_Study.webx.entity.Wyy_topic;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.tools.javac.Main;
import org.apache.bcel.generic.NEW;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.print.DocFlavor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wl
 * @ClassNameJsoup
 * @Description TODO
 * @Date 2020/3/27
 * @Version 1.0
 */
public class Y_Jsoup {
    private static final Integer SUCCESS = 200;
    public  static List<Bili> getData(){
        List<Bili>list= new ArrayList<>();
        String  url = "https://www.bilibili.com/ranking/all/188/0/3";
        //设置响应头
String useragent =" Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.106 Safari/537.36";
        //创建context对象
    CloseableHttpClient  httpClient = HttpClients.createDefault();
       //创建get
    HttpGet httpget= new HttpGet(url);
        httpget.setHeader("User-Agent",useragent);
//        System.out.println(httpget.getFirstHeader("User-Agent"));
        HttpClientContext context = HttpClientContext.create();
    //创建response对象
        CloseableHttpResponse response = null;
        try {
            //获取相应头
            response = httpClient.execute(httpget,context);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(response.getStatusLine());
   if (response.getStatusLine().getStatusCode()== SUCCESS){
       HttpEntity httpEntity =response.getEntity();
       if (httpClient!=null){

               //设置编码
               String res = null;
               try {
                   res = EntityUtils.toString(httpEntity,"utf-8");
               } catch (IOException e) {
                   e.printStackTrace();
               }

               Document document = Jsoup.parse(res);
//               System.out.println(document);
           //获取script脚本进行解析
               Elements scripts =document.getElementsByTag("script");
               String wholedata =scripts.get(5).html();
               System.out.println(wholedata);
               //获取纯list数据
               String  data =wholedata.substring(wholedata.indexOf("rankList")+10,wholedata.indexOf("rankRouteParams")-2);
               JSONArray jsonArray =JSONArray.parseArray(data);
               jsonArray.forEach(o->{
                   JSONObject json =JSONObject.parseObject(o.toString());
                   Bili bili =Bili.builder()
                           .img(json.getString("pic"))
                           .author(json.getString("author"))
                           .play(json.getString("play"))
                           .title(json.getString("title")).view(json.getString("video_review")).score(Long.valueOf(json.getString("pts"))).build();
list.add(bili);
               });
//               Elements elements =document.getElementsByClass("rank-item");
//               for ( Element element : elements){
//
//                   String title =element.select(".title").text();
//
//                   String play=element.child(1).child(1).child(1).child(0).text();
//                   String view=element.child(1).child(1).child(1).child(1).text();
//
//                   String author=element.child(1).child(1).child(1).child(2).child(0).text();
//                      String  score =element.select(".pts div" ).text();
//
//                    String  num  =element.child(0).text();

//
           System.out.println(list);



       }
       try {
           //关闭连接
           response.close();
           httpClient.close();

       } catch (IOException e) {
           e.printStackTrace();
       }


   }
        return list;
}

    public static void main(String[] args) {

        getData();
    }
}