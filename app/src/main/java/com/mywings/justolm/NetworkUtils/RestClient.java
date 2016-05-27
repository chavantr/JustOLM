package com.mywings.justolm.NetworkUtils;


import android.content.Context;

import org.apache.http.NameValuePair;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tatyabhau Chavan on 5/27/2016.
 */
public class RestClient extends DefaultHttpClient {

    //region Variables
    private static RestClient ourInstance;
    private String url;
    private String baseUrl = "http://yogeshkoli.com/justolm/auth/v1/";
    private Context context;
    private List<NameValuePair> header;
    private List<NameValuePair> param;
    private String json;
    private String message;
    private String response;
    private int responseCode;
    private String userName;
    private String password;
    private boolean authentication;
    //endregion

    public RestClient(Context context, String url) {
        this.context = context;
        this.url = baseUrl + url;
        header = new ArrayList<>();
        param = new ArrayList<>();
        header.add(new BasicNameValuePair("Cache-Control", "no-store"));
    }

    public static RestClient getInstance(Context context, String url) {
        if (null == ourInstance) {
            ourInstance = new RestClient(context, url);
        }
        return ourInstance;
    }





}
