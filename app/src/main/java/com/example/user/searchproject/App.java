package com.example.user.searchproject;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by user on 03.07.17.
 */

public class App extends Application {
    private static SearchApi mSearchApi;
    private Retrofit mRetrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        mSearchApi = mRetrofit.create(SearchApi.class);
    }

    public static SearchApi getApi() {
        return mSearchApi;
    }
}
