package com.karavatskiy.serhii.testaxon.data.remote.retrofit;

import com.karavatskiy.serhii.testaxon.data.pojo.RandomUserInfo;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Serhii on 24.01.2019.
 */
public interface RandomUserApi {

    @GET("api")
    Single<RandomUserInfo> getUser(@Query("results") int numberOfUsers);
}
