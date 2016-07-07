package com.monkeypatch.mktd.feignvsretrofit.exo2;

import com.monkeypatch.mktd.feignvsretrofit.exo2.model.Monkey;
import org.junit.Test;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.lang.System.out;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static junit.framework.TestCase.assertTrue;

public class _04_Download implements Configuration {

    @Test
    public void testDownload() throws Exception {
        out.println("Photo par Rob from Cambridge, MA (flickr.com) [CC BY 2.0 (http://creativecommons.org/licenses/by/2.0)], via Wikimedia Commons");
        MonkeyApi api = ApiFactory.buildMonkeyApi(BASE_URL, LOGIN, PASSWORD);

        Monkey monkey = api.getMonkeyByName("King Kong");

        // Try download
        Path tempFile = Files.createTempFile("mktd1", "exo2");
        InputStream input = api.downloadPhoto(monkey.getId());
        Files.copy(input, tempFile, REPLACE_EXISTING);
        long size = Files.size(tempFile);
        assertTrue(size > 0);
    }
}
