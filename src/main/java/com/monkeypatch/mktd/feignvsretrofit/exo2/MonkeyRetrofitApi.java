package com.monkeypatch.mktd.feignvsretrofit.exo2;

import com.monkeypatch.mktd.feignvsretrofit.exo2.model.Monkey;
import com.monkeypatch.mktd.feignvsretrofit.exo2.model.Photo;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.io.InputStream;

public interface MonkeyRetrofitApi {


    @GET("monkeys/{name}")
    Call<Monkey> getMonkeyByName(@Path("name") String name);

    @POST("monkeys")
    Call<Monkey> createMonkey(@Body Monkey monkey);

    @POST("monkeys/{id}/photo")
    Call<Photo> savePhoto(@Path("id") String id, @Body InputStream stream) throws SecurityException, IllegalArgumentException;

    @GET("monkeys/{id}/photo")
    Call<ResponseBody> downloadPhoto(@Path("id") String id) throws SecurityException, IllegalArgumentException;

}
