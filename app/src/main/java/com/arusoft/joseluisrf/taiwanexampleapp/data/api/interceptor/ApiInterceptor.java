package com.arusoft.joseluisrf.taiwanexampleapp.data.api.interceptor;


import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


public class ApiInterceptor implements Interceptor {

    private static final String HEADER_AUTHORIZATION = "Authorization";
    private static final String NO_AUTHENTICATION = "No-authentication";
    private static final String BEARER = "Bearer ";
    public static final String ACCEPT = "Accept";
    public static final String USER_AGENT = "User-Agent";

//    private final SessionManager sessionManager;

    @Inject
    public ApiInterceptor() {
//        this.sessionManager = sessionManager;

    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        Request.Builder requestBuilder = request.newBuilder();
        if (request.header(NO_AUTHENTICATION) == null) {
            // needs credentials

            requestBuilder.header(USER_AGENT, "TaiwanApp");
            requestBuilder.header(ACCEPT, "application/json");
//            if (sessionManager.authToken() != null && sessionManager.authToken().length() > 0) {
//                requestBuilder.header(HEADER_AUTHORIZATION, sessionManager.getUserSession().getAuthToken());
//            }
        }

        return chain.proceed(requestBuilder.build());
    }

}