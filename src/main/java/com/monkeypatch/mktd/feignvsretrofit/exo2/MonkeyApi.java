package com.monkeypatch.mktd.feignvsretrofit.exo2;

import com.monkeypatch.mktd.feignvsretrofit.exo2.model.Monkey;
import com.monkeypatch.mktd.feignvsretrofit.exo2.model.Photo;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.io.InputStream;

@Headers("Content-Type: application/json")
public interface MonkeyApi {

    @RequestLine("GET /monkeys/{name}")
    Monkey getMonkeyByName(@Param("name") String name) throws SecurityException;

    @RequestLine("POST /monkeys")
    Monkey createMonkey(Monkey monkey) throws SecurityException, IllegalArgumentException;

    @RequestLine("POST /monkeys/{id}/photo")
    Photo savePhoto(@Param("id") String id, InputStream stream) throws SecurityException, IllegalArgumentException;

    @RequestLine("GET /monkeys/{id}/photo")
    InputStream downloadPhoto(@Param("id") String id) throws SecurityException, IllegalArgumentException;

}
