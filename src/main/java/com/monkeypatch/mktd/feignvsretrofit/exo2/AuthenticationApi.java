package com.monkeypatch.mktd.feignvsretrofit.exo2;

import com.monkeypatch.mktd.feignvsretrofit.exo2.model.LoginPassword;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

// TODO you may update this interface to complete the exo1
public interface AuthenticationApi {

    /**
     * Authenticate a user
     *
     * @param loginPassword the login/password
     * @return the authentication token (extract from Cookie)
     */
    @POST("auth")
    Call<ResponseBody> login(@Body LoginPassword loginPassword) throws SecurityException;
}
