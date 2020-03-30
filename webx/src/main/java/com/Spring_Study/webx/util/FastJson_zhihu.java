package com.Spring_Study.webx.util;

import com.Spring_Study.webx.entity.Book;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wl
 * @ClassNameSingerJsoup
 * @Description TODO
 * @Date 2020/3/27
 * @Version 1.0
 */
public class FastJson_zhihu {
    private static final Integer SUCCESS = 200;

    public static List<Book> getData() {
        List<Book> list = new ArrayList<>();
        int i = 2;
        for (i = 2; i < 10; i++) {
            String url = "https://www.zhihu.com/api/v3/books/categories/245?version=v2&limit=10&sort_by=read_count_7days&offset=" +  i * 5;
            System.out.println(url);
            CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
            HttpGet get = new HttpGet(url);
            HttpClientContext clientContext = HttpClientContext.create();
            CloseableHttpResponse response = null;
            try {
                response = closeableHttpClient.execute(get, clientContext);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (response.getStatusLine().getStatusCode() == SUCCESS) {
                HttpEntity entity = response.getEntity();
                String res = null;
                try {
                    res = EntityUtils.toString(entity, "UTF-8");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                JSONObject jsonObject = JSONObject.parseObject(res);
                JSONArray list1 = jsonObject.getJSONArray("data");
                list1.forEach(o -> {
                    JSONObject jsonObject1 = JSONObject.parseObject(o.toString());

                    Book book = Book.builder()
                            .skuId(jsonObject1.getString("sku_id"))
                            .type(jsonObject1.getString("type"))
                            .description(jsonObject1.getString("description"))
                            .title(jsonObject1.getString("title"))
                            .url(jsonObject1.getString("url"))
                            .cover(jsonObject1.getString("cover"))
                            .bookSize(jsonObject1.getInteger("book_size"))
                            .name(JSONObject.parseObject(jsonObject1.getJSONArray("authors").get(0).toString()).getString("name"))
                            .price(jsonObject1.getJSONObject("promotion").getString("price"))
                            .build();
                    list.add(book);
                });
                System.out.println(list);
            } else {
                System.out.println("请求失败");
            }
        }
        return list;
    }

    public static void main(String[] args) {
        getData();
    }
}


