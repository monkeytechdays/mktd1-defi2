package com.monkeypatch.mktd.feignvsretrofit.exo2;


import com.monkeypatch.mktd.feignvsretrofit.exo2.model.MonkeyRace;

import java.io.IOException;
import java.util.List;

public class MonkeyRaceImpl implements MonkeyRaceApi {
    private MonkeyRaceRetrofitApi api;

    public MonkeyRaceImpl(MonkeyRaceRetrofitApi api) {
        this.api = api;
    }

    @Override
    public List<MonkeyRace> getMonkeyRaces() {
        try {
            return api.getMonkeyRaces().execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
