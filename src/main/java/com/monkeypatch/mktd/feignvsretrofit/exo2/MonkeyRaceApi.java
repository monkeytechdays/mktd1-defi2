package com.monkeypatch.mktd.feignvsretrofit.exo2;

import com.monkeypatch.mktd.feignvsretrofit.exo2.model.MonkeyRace;

import java.util.List;

// TODO you may update this interface to complete the exo1
public interface MonkeyRaceApi {

    List<MonkeyRace> getMonkeyRaces() throws SecurityException, IllegalArgumentException;

}
