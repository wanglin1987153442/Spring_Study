package com.Spring_Study.webx.util;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * <pre>
 * Http工具，包含：
 * 高级http工具(使用net.sourceforge.htmlunit获取完整的html页面,即完成后台js代码的运行)
 * </pre>
 * Created by xuyh at 2017/7/17 19:08.
 */
public class HttpUtils {
    /**
     * 请求超时时间,默认20000ms
     */
    private int timeout = 20000;
    /**
     * 等待异步JS执行时间,默认20000ms
     */
    private int waitForBackgroundJavaScript = 20000;

    private static HttpUtils httpUtils;

    public HttpUtils() {
    }

    /**
     * 获取实例
     *
     * @return
     */
    public static HttpUtils getInstance() {
        if (httpUtils == null) {
            httpUtils = new HttpUtils();
        }
        return httpUtils;
    }

    public int getTimeout() {
        return timeout;
    }

    /**
     * 设置请求超时时间
     *
     * @param timeout
     */
    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getWaitForBackgroundJavaScript() {
        return waitForBackgroundJavaScript;
    }

    /**
     * 设置获取完整HTML页面时等待异步JS执行的时间
     *
     * @param waitForBackgroundJavaScript
     */
    public void setWaitForBackgroundJavaScript(int waitForBackgroundJavaScript) {
        this.waitForBackgroundJavaScript = waitForBackgroundJavaScript;
    }

    /**
     * 将网页返回为解析后的文档格式
     *
     * @param html
     * @return
     * @throws Exception
     */
    public static Document parseHtmlToDoc(String html) throws Exception {
        return removeHtmlSpace(html);
    }

    private static Document removeHtmlSpace(String str) {
        Document doc = Jsoup.parse(str);
        String result = doc.html().replace("&nbsp;", "");
        return Jsoup.parse(result);
    }

    /**
     * 获取页面文档字串(等待异步JS执行)
     *
     * @param url 页面URL
     * @return
     * @throws Exception
     */
    public String getHtmlPageResponse(String url) throws Exception {
        String result = "";

        final WebClient webClient = new WebClient(BrowserVersion.CHROME);

        webClient.getOptions().setThrowExceptionOnScriptError(false);//当JS执行出错的时候是否抛出异常
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);//当HTTP的状态非200时是否抛出异常
        webClient.getOptions().setActiveXNative(false);
        webClient.getOptions().setCssEnabled(false);//是否启用CSS
        webClient.getOptions().setJavaScriptEnabled(true); //很重要，启用JS
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());//很重要，设置支持AJAX

        webClient.getOptions().setTimeout(timeout);//设置“浏览器”的请求超时时间
        webClient.setJavaScriptTimeout(timeout);//设置JS执行的超时时间

        HtmlPage page;
        try {
            page = webClient.getPage(url);
        } catch (Exception e) {
            webClient.close();
            throw e;
        }
        webClient.waitForBackgroundJavaScript(waitForBackgroundJavaScript);//该方法阻塞线程

        result = page.asXml();
        webClient.close();

        return result;
    }

    /**
     * 获取页面文档Document对象(等待异步JS执行)
     *
     * @param url 页面URL
     * @return
     * @throws Exception
     */
    public Document getHtmlPageResponseAsDocument(String url) throws Exception {
        return parseHtmlToDoc(getHtmlPageResponse(url));
    }
}