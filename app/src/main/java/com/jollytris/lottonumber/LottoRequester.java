package com.jollytris.lottonumber;

import java.io.IOException;

import io.reactivex.Observable;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by zic325 on 2017. 4. 10..
 */

public class LottoRequester {

    private static final String URL = "http://www.nlotto.co.kr/";

    private static final LottoRequester instance = new LottoRequester();

    private Api api;

    private LottoRequester() {
        initialize();
    }

    public static LottoRequester getInstance() {
        return instance;
    }

    public Api api() {
        return api;
    }

    private void initialize() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response response = chain.proceed(chain.request());
                return response;
            }
        });

        Retrofit retrofit = new Retrofit.Builder().baseUrl(URL)
                .client(builder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(Api.class);
    }

    public interface Api {
        @GET("common.do")
        Observable<Lotto> getWinNumber(@Query("method") String method, @Query("drwNo") int drwNo);
    }
}
