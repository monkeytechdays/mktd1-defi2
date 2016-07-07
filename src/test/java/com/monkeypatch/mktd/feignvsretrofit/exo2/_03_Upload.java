package com.monkeypatch.mktd.feignvsretrofit.exo2;

import com.monkeypatch.mktd.feignvsretrofit.exo2.model.Monkey;
import com.monkeypatch.mktd.feignvsretrofit.exo2.model.Photo;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.assertNotNull;

public class _03_Upload implements Configuration {

    @Test
    public void testUpload() throws Exception {
        System.out.println("Photo par Rob from Cambridge, MA (flickr.com) [CC BY 2.0 (http://creativecommons.org/licenses/by/2.0)], via Wikimedia Commons");
        MonkeyApi api = ApiFactory.buildMonkeyApi(BASE_URL, LOGIN, PASSWORD);

        Monkey monkey = api.getMonkeyByName("King Kong");
        try (InputStream photo = getClass().getResourceAsStream("/monkey.jpg")) {
            Photo result = api.savePhoto(monkey.getId(), photo);
            assertNotNull(result);
        }
    }
}
