package com.monkeypatch.mktd.feignvsretrofit.exo2;

import com.monkeypatch.mktd.feignvsretrofit.exo2.model.MonkeyRace;
import feign.Headers;
import feign.RequestLine;

import java.util.List;

@Headers("Content-Type: application/json")
public interface MonkeyRaceApi {

    @RequestLine("GET /races")
    List<MonkeyRace> getMonkeyRaces() throws SecurityException, IllegalArgumentException;

}
