package com.monkeypatch.mktd.feignvsretrofit.exo2;

import com.monkeypatch.mktd.feignvsretrofit.exo2.model.LoginPassword;
import feign.Headers;
import feign.RequestLine;

@Headers("Content-Type: application/json")
public interface AuthenticationApi {

    /**
     * Authenticate a user
     * @param loginPassword the login/password
     * @return the authentication token (extract from Cookie)
     */

    @RequestLine("POST /auth")
    String login(LoginPassword loginPassword) throws SecurityException;
}
