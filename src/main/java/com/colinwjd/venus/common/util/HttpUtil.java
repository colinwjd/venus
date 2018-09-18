package com.colinwjd.venus.common.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
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
        String result = null;
        try {
            HttpResponse response = HTTP_CLIENT.execute(httpGet);
            result = EntityUtils.toString(response.getEntity());
        } catch (ParseException | IOException e) {
            log.warn("Http get exception: ", e);
        }
        return result;
    }

    public static String post(String url, Map<String, String> params) {
        List<NameValuePair> pairs = new ArrayList<>();
        params.forEach((k, v) -> pairs.add(new BasicNameValuePair(k, v)));
        HttpEntity entity = new UrlEncodedFormEntity(pairs, Consts.UTF_8);
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(entity);
        String result = null;
        try {
            HttpResponse response = HTTP_CLIENT.execute(httpPost);
            result = EntityUtils.toString(response.getEntity());
        } catch (ParseException | IOException e) {
            log.warn("Http post exception: ", e);
        }
        return result;
    }
}
