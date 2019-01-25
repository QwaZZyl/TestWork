package com.karavatskiy.serhii.testaxon.di;

import android.app.Application;
import android.content.Context;
import com.karavatskiy.serhii.testaxon.data.remote.retrofit.RandomUserApi;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Serhii on 24.01.2019.
 */
@Module
public class AppModule {

    private static final String BASE_URL = "https://randomuser.me";

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
    @Provides
    RandomUserApi provideRandomUserApi(Retrofit retrofit) {
        return retrofit.create(RandomUserApi.class);
    }
}
