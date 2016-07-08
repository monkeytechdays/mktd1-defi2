package com.monkeypatch.mktd.feignvsretrofit.exo2;

import com.monkeypatch.mktd.feignvsretrofit.exo2.model.MonkeyRace;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface MonkeyRaceRetrofitApi {

    @GET("races")
    Call<List<MonkeyRace>> getMonkeyRaces();
}
