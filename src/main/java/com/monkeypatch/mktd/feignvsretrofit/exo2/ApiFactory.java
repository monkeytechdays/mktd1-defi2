package com.monkeypatch.mktd.feignvsretrofit.exo2;

import java.io.IOException;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

import static com.monkeypatch.mktd.feignvsretrofit.exo2.Configuration.BASE_URL;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

/**
 * @see <a href="https://fr.wikipedia.org/wiki/Cookie_(informatique)">Miam</a>
 */
class ApiFactory {


    static MonkeyApi buildMonkeyApi(String url, String login, String password) {
        // TODO you should implements this method
        throw new RuntimeException("Not yet implemented");
    }

    static MonkeyRaceApi buildRaceApi(String url, String login, String password) {
        // TODO you should implements this method
        throw new RuntimeException("Not yet implemented");
    }

    /**
     * Decode HTTP errors
     * status 400 (Bad argument) => throw an IllegalArgumentException
     * status 404 (Not Found) => throw a NoSuchElementException
     * status 401, 403 (Unauthorized, Forbidden) => throw a SecurityException
     *
     * @param status  HTTP status
     * @param message a message
     * @return the exception to throw
     */
    public static RuntimeException decodeError(int status, String message, Supplier<RuntimeException> defaultCase) {
        switch (status) {
            case 404:
                return new NoSuchElementException(message);
            case 400:
                return new IllegalArgumentException(message);
            case 401:
            case 403:
                return new SecurityException(message);
            default:
                return defaultCase.get();
        }
    }


    /**
     * Cookies Manager @since JDK 1.6
     *
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/net/CookieManager.html>JDK CookieManager</a>
     */
    private static final CookieManager COOKIE_MANAGER = new CookieManager();

    /**
     * Add Cookie to the cookie manager
     *
     * @param headers response header as Map<String, List<String>>
     * @return the authentication cookie value
     */
    private static String handleCookies(Map<String, Collection<String>> headers) {
        Map<String, List<String>> h = headers.entrySet().stream()
                .collect(toMap(Map.Entry::getKey, entry -> entry.getValue().stream()
                        .collect(toList())));
        try {
            URI uri = URI.create(BASE_URL);
            COOKIE_MANAGER.put(uri, h);
            return COOKIE_MANAGER.getCookieStore().get(uri).stream()
                    .filter(cookie -> "token".equals(cookie.getName()))
                    .findFirst()
                    .map(HttpCookie::getValue)
                    .orElseThrow(() -> new IllegalStateException("Authentication cookie not found"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}