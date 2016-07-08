package com.monkeypatch.mktd.feignvsretrofit.exo2;

import com.monkeypatch.mktd.feignvsretrofit.exo2.model.Monkey;
import com.monkeypatch.mktd.feignvsretrofit.exo2.model.Photo;

import java.io.IOException;
import java.io.InputStream;


public class MonkeyImpl implements MonkeyApi {
    private MonkeyRetrofitApi api;

    public MonkeyImpl(MonkeyRetrofitApi api) {
        this.api = api;
    }


    @Override
    public Monkey getMonkeyByName(String name) {
        try {
            return api.getMonkeyByName(name).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Monkey createMonkey(Monkey monkey) {
        try {
            return api.createMonkey(monkey).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Photo savePhoto(String id, InputStream stream) throws SecurityException, IllegalArgumentException {
        try {
            return api.savePhoto(id,stream).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public InputStream downloadPhoto(String id) throws SecurityException, IllegalArgumentException {
        try {
            return api.downloadPhoto(id).execute().body().byteStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
