package com.colinwjd.venus.common.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * Http 工具
 *
 * @author Colin Wang
 * @date 2018/09/18
 */
@Slf4j
public final class HttpUtil {

    private static final HttpClient HTTP_CLIENT = HttpClients.createDefault();

    public static String get(String url) {
        HttpGet httpGet = new HttpGet(url);
        return execute(httpGet);
    }

    public static String get(String url, Map<String, String> params) {
        HttpGet httpGet = new HttpGet(buildUri(url, params));
        return execute(httpGet);
    }

    public static String post(String url) {
        HttpPost httpPost = new HttpPost(url);
        return execute(httpPost);
    }

    public static String post(String url, Map<String, String> params) {
        HttpEntity entity = new UrlEncodedFormEntity(buildParams(params), Consts.UTF_8);
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(entity);
        return execute(httpPost);
    }

    public static String post(String url, String json) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.setEntity(new StringEntity(json, Consts.UTF_8));
        return execute(httpPost);
    }

    private static List<NameValuePair> buildParams(Map<String, String> params) {
        List<NameValuePair> pairs = new ArrayList<>(MapUtils.size(params));
        if (MapUtils.isNotEmpty(params)) {
            params.forEach((k, v) -> pairs.add(new BasicNameValuePair(k, v)));
        }
        return pairs;
    }

    private static String buildUri(String url, Map<String, String> params) {
        String uri = null;
        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            uriBuilder.addParameters(buildParams(params));
            uri = uriBuilder.build().toString();
        } catch (URISyntaxException e) {
            log.warn("URI build exception: ", e);
        }
        return uri;
    }

    private static String execute(HttpUriRequest request) {
        String result = null;
        try {
            HttpResponse response = HTTP_CLIENT.execute(request);
            result = EntityUtils.toString(response.getEntity());
        } catch (IOException | ParseException e) {
            log.warn("Http request exception: ", e);
        }
        return result;
    }
}
