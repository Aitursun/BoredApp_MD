package com.example.boredapp_md.remote_data;

import com.example.boredapp_md.models.ModelDo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DoApi {


    @GET("api/activity")
    Call<ModelDo> getActivities();

    @GET("/api/activity/{key}")
    Call<ModelDo> getActivityByKey(
            @Query("key") String key
    );

    @GET("/api/activity?price}")
    Call<ModelDo> getActivityBy(
            @Query("price") boolean price
    );

    @GET("/api/activity?link}")
    Call<ModelDo> getActivityBy(
            @Query("link") String link
    );
}