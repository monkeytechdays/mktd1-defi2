package com.monkeypatch.mktd.feignvsretrofit.exo2;

import org.junit.Test;

import static junit.framework.TestCase.fail;

public class _01_Authentication implements Configuration {

    @Test
    public void testAuthentication() throws Exception {
        try {
            MonkeyRaceApi api = ApiFactory.buildRaceApi(BASE_URL, null, null);
            api.getMonkeyRaces();
            fail("should throw an Exception");
        } catch (Exception e) {
            // It's OK
        }
        // With a good login/password
        MonkeyRaceApi api = ApiFactory.buildRaceApi(BASE_URL, LOGIN, PASSWORD);
        api.getMonkeyRaces();
    }
}
