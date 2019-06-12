package com.jrevata.teclaborapp.services;

import com.jrevata.teclaborapp.models.Login;
import com.jrevata.teclaborapp.models.ResponseMessage;
import com.jrevata.teclaborapp.models.Usuario;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    public static final String API_BASE_URL = "https://campus.tecsup.edu.pe:443/campus-rest/";

    @FormUrlEncoded
    @POST("login")
    Call<Usuario> login(@Field("usuario")String usuario,
                       @Field("clave") String clave);

    @GET("logout")
    Call<ResponseMessage> logout();

}
