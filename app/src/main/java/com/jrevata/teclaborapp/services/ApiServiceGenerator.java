package com.jrevata.teclaborapp.services;

import android.content.Context;
import android.util.Log;

import com.jrevata.teclaborapp.models.Usuario;
import com.jrevata.teclaborapp.repositories.UsuarioRepository;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServiceGenerator {

    private final static String TAG = ApiServiceGenerator.class.getSimpleName();

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(ApiService.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit;

    private ApiServiceGenerator() {
    }

    public static <S> S createService(final Context context, Class<S> serviceClass) {
        if(retrofit == null) {

            httpClient.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {



                    try {

                        Request originalRequest = chain.request();

                        // Load Token from SharedPreferences (firsttime is null)
//                        SharePreferences.PREFERENCE_TOKEN_LOGIN;
                        String tok = null;
                        if(!UsuarioRepository.verifyLogeo()){
                            tok = UsuarioRepository.getUser().getToken();
                            Log.d(TAG, "Loaded Token: " + tok);
                        }
//                        SharePreferences.savePreferenceStringToken(this, tok, SharePreferences.PREFERENCE_TOKEN_LOGIN);


                        if(tok == null){
                            // Firsttime assuming login
                            return chain.proceed(originalRequest);
                        }

                        // Request customization: add request headers
                        Request modifiedRequest = originalRequest.newBuilder()
                                .header("Authorization", tok)
                                .build();

                        return chain.proceed(modifiedRequest); // Call request with tok


                    }catch (Exception e){
                        Log.e(TAG, e.toString());
//                        FirebaseCrash.report(e);
                        throw e;
                    }

                }
            });

            retrofit = builder.client(httpClient.build()).build();
        }
        return retrofit.create(serviceClass);
    }




}