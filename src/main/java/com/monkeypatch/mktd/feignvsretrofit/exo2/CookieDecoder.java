package com.monkeypatch.mktd.feignvsretrofit.exo2;

import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpCookie;
import java.util.StringTokenizer;

/**
 * Created by xhitedev on 7/8/16.
 */
public class CookieDecoder implements Decoder {
    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
        return response.headers().get("Set-Cookie").iterator().next();
    }
}
