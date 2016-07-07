package com.monkeypatch.mktd.feignvsretrofit.exo2;

import com.monkeypatch.mktd.feignvsretrofit.exo2.model.Monkey;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.UUID;

import static junit.framework.TestCase.fail;

public class _02_Exceptions implements Configuration {

    @Test(expected = SecurityException.class)
    public void testSecurityException() throws Exception {
        MonkeyRaceApi api = ApiFactory.buildRaceApi(BASE_URL, null, null);
        api.getMonkeyRaces();
        fail("should throw an Exception");
    }

    @Test(expected = NoSuchElementException.class)
    public void testNoSuchElement() throws Exception {
        MonkeyApi api = ApiFactory.buildMonkeyApi(BASE_URL, LOGIN, PASSWORD);
        api.getMonkeyByName(UUID.randomUUID().toString() + System.nanoTime());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgument() throws Exception {
        MonkeyApi api = ApiFactory.buildMonkeyApi(BASE_URL, LOGIN, PASSWORD);
        Monkey cat = new Monkey();
        cat.setName("Felix");
        api.createMonkey(cat);
    }
}
