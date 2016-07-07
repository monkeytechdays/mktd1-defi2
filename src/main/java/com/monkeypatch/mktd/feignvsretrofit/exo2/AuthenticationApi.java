package com.monkeypatch.mktd.feignvsretrofit.exo2;

import com.monkeypatch.mktd.feignvsretrofit.exo2.model.LoginPassword;

// TODO you may update this interface to complete the exo1
public interface AuthenticationApi {

    /**
     * Authenticate a user
     * @param loginPassword the login/password
     * @return the authentication token (extract from Cookie)
     */
    String login(LoginPassword loginPassword) throws SecurityException;
}
