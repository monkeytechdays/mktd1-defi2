package com.monkeypatch.mktd.feignvsretrofit.exo2;

import com.monkeypatch.mktd.feignvsretrofit.exo2.model.Monkey;
import com.monkeypatch.mktd.feignvsretrofit.exo2.model.Photo;

import java.io.InputStream;

public interface MonkeyApi {

    Monkey getMonkeyByName(String name) throws SecurityException;

    Monkey createMonkey(Monkey monkey) throws SecurityException, IllegalArgumentException;

    Photo savePhoto(String id, InputStream stream) throws SecurityException, IllegalArgumentException;

    InputStream downloadPhoto(String id) throws SecurityException, IllegalArgumentException;

}
