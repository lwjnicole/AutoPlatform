package com.lwjnicole.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;
	
public class HttpRequestUtil {

    private PoolingHttpClientConnectionManager connectionManager;

 

    /** 设置字符集 */
    private String                             UTF_8         = "UTF-8";

    /** 整个连接池最大连接数 */
    private Integer                            MAX_TOTAL     = 200;

    /*每路由最大连接数，默认值是2*/
    private Integer                            MAX_PER_ROUTE = 10;

    /** 无结果返回*/
    private String                             NOT_RESULT    = "";

    /**
     * defaultHeaders(构建默认请求头信息)
     * @Title: init
     */
    private static Map<String, Object> defaultHeaders() {
        Map<String, Object> defaultHeaders = new HashMap<String, Object>();
        defaultHeaders.put("Accept",
            "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        defaultHeaders.put("Connection", "Keep-Alive");
        defaultHeaders.put("User-Agent",
            "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");
        defaultHeaders.put("Cookie", "");
        return defaultHeaders;
    }

    /**
     * init(构建connectionManager，指定最大连接池、最大连接数)
     * @Title: init
     */
    private void init() {
        if (EmptyUtil.isNullOrEmpty(connectionManager)) {
            connectionManager = new PoolingHttpClientConnectionManager();
            connectionManager.setMaxTotal(MAX_TOTAL);
            connectionManager.setDefaultMaxPerRoute(MAX_PER_ROUTE);
            new IdleConnectionMonitorThread(connectionManager).start();
        }
    }

    /**
     * getHttpClient(从地址池中获得可关闭的HttpClient对象)
     * @Title: getHttpClient
     */
    private CloseableHttpClient getHttpClient() {
        init();
        // 设置请求超时时间
        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(5000)
            .setSocketTimeout(10000).setConnectTimeout(10000).build();
        return HttpClients.custom().setConnectionManager(connectionManager)
            .setDefaultRequestConfig(requestConfig).build();
    }

    /**
     * getHttpClient(从地址池中获得可关闭的HttpClient对象)
     * @Title: getHttpClient
     */
    private CloseableHttpClient getHttpClient(int timeout) {
        init();
        // 设置请求超时时间
        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(timeout)
            .setSocketTimeout(timeout).setConnectTimeout(timeout).build();
        return HttpClients.custom().setConnectionManager(connectionManager)
            .setDefaultRequestConfig(requestConfig).build();
    }

    /**
     * 不带参数的get请求
     * @param url
     * @return
     * @throws IOException
     */
    public String httpGetRequest(String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        return getResult(httpGet);
    }

    /**
     * 带参数的get请求
     * @param url
     * @param params
     * @param timeout
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    public String httpGetRequest(String url, Map<String, Object> params, int timeout)
                                                                                            throws URISyntaxException,                                                                                          IOException {
        URIBuilder ub = new URIBuilder();
        ub.setPath(url);

        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
        ub.setParameters(pairs);

        HttpGet httpGet = new HttpGet(ub.build());
        Map<String, Object> headers = HttpRequestUtil.defaultHeaders();
        for (Map.Entry<String, Object> param : headers.entrySet()) {
            httpGet.addHeader(param.getKey(), String.valueOf(param.getValue()));
        }
        return getResult(httpGet, timeout);
    }

    /**
     * 带参数及头信息的get请求
     * @param url
     * @param headers
     * @param params
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    public String httpGetRequest(String url, Map<String, Object> headers,
                                        Map<String, Object> params) throws URISyntaxException,
                                                                   IOException {
        URIBuilder ub = new URIBuilder();
        ub.setPath(url);

        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
        ub.setParameters(pairs);

        HttpGet httpGet = new HttpGet(ub.build());
        for (Map.Entry<String, Object> param : headers.entrySet()) {
            httpGet.addHeader(param.getKey(), String.valueOf(param.getValue()));
        }
        return getResult(httpGet);
    }

    /**
     * 普通的post请求
     * @param url
     * @return
     * @throws IOException
     */
    public String httpPostRequest(String url) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        return getResult(httpPost);
    }

   /**
    * 带参数及超时时间的post请求
    * @param url
    * @param params
    * @param timeout
    * @return
    * @throws IOException
    */
    public String httpPostRequest(String url, Map<String, Object> params, int timeout)
                                                                                             throws IOException {
        HttpPost httpPost = new HttpPost(url);

        Map<String, Object> headers = HttpRequestUtil.defaultHeaders();
        for (Map.Entry<String, Object> param : headers.entrySet()) {
            httpPost.addHeader(param.getKey(), String.valueOf(param.getValue()));
        }
        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
        httpPost.setEntity(new UrlEncodedFormEntity(pairs, UTF_8));
        return getResult(httpPost, timeout);
    }

    /**
     * 带参数及请求头的post请求
     * @param url
     * @param headers
     * @param params
     * @return
     * @throws IOException
     */
    public String httpPostRequest(String url, Map<String, Object> headers,
                                         Map<String, Object> params) throws IOException {
        HttpPost httpPost = new HttpPost(url);

        for (Map.Entry<String, Object> param : headers.entrySet()) {
            httpPost.addHeader(param.getKey(), String.valueOf(param.getValue()));
        }

        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
        httpPost.setEntity(new UrlEncodedFormEntity(pairs, UTF_8));

        return getResult(httpPost);
    }

   /**
    * 参数为json字符串的post请求
    */
    public String httpPostJsonRequest(String url, String params, int timeout)
                                                                                    throws IOException {
        HttpPost httpPost = new HttpPost(url);
        Map<String, Object> headers = HttpRequestUtil.defaultHeaders();
        for (Map.Entry<String, Object> param : headers.entrySet()) {
            if (!"Accept".equals(param.getKey())) {
                httpPost.addHeader(param.getKey(), String.valueOf(param.getValue()));
            } else {
                httpPost.addHeader("Accept", "application/json;q=0.9,*/*;q=0.8");
            }
        }
        httpPost.setEntity(new StringEntity(params, ContentType.APPLICATION_JSON));
        return getResult(httpPost, timeout);
    }

    /**
     * 参数为json字符串的post请求
     * @param url
     * @param jsonObject
     * @param timeout
     * @return
     * @throws IOException
     */
    public JSONObject httpPostJsonRequest(String url, JSONObject jsonObject, int timeout)
                                                                                                throws IOException {
        if (EmptyUtil.isNullOrEmpty(jsonObject)) {          
            return null;
        }
        String params = jsonObject.toJSONString();
        String retStr = httpPostJsonRequest(url, params, timeout);
        return JSONObject.parseObject(retStr);
    }

    /**
     * 参数转换
     * @param params
     * @return
     */
    private ArrayList<NameValuePair> covertParams2NVPS(Map<String, Object> params) {
        ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair>();
        for (Map.Entry<String, Object> param : params.entrySet()) {
            pairs.add(new BasicNameValuePair(param.getKey(), String.valueOf(param.getValue())));
        }
        return pairs;
    }

    /**
     * 获得结果
     * @param request
     * @return
     * @throws IOException
     */
    private String getResult(HttpRequestBase request) throws IOException {
        CloseableHttpClient httpClient = getHttpClient();
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity, UTF_8);
                return result;
            }
        }
        return NOT_RESULT;
    }

    /**
     * 获得结果
     * @param request
     * @param timeout
     * @return
     * @throws IOException
     */
    private String getResult(HttpRequestBase request, int timeout) throws IOException {
        CloseableHttpClient httpClient = getHttpClient(timeout);
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity, UTF_8);
                return result;
            }
        }
        return NOT_RESULT;
    }

    /**
     * 定时回收连接池中过期的连接、长时间不使用的连接
     */
    public static class IdleConnectionMonitorThread extends Thread {

        private final HttpClientConnectionManager connMgr;
        private volatile boolean                  shutdown;

        public IdleConnectionMonitorThread(HttpClientConnectionManager connMgr) {
            super();
            this.connMgr = connMgr;
        }

        @Override
        public void run() {
            try {
                while (!shutdown) {
                    synchronized (this) {
                        wait(5000);
                        // Close expired connections
                        connMgr.closeExpiredConnections();
                        // Optionally, close connections
                        // that have been idle longer than 30 sec
                        connMgr.closeIdleConnections(30, TimeUnit.SECONDS);
                    }
                }
            } catch (InterruptedException ex) {
                // terminate
            }
        }

        public void shutdown() {
            shutdown = true;
            synchronized (this) {
                notifyAll();
            }
        }

    }

}

