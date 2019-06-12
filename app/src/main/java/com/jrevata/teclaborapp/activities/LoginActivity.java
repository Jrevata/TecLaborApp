package com.jrevata.teclaborapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jrevata.teclaborapp.R;
import com.jrevata.teclaborapp.models.Login;
import com.jrevata.teclaborapp.models.Usuario;
import com.jrevata.teclaborapp.repositories.UsuarioRepository;
import com.jrevata.teclaborapp.services.ApiService;
import com.jrevata.teclaborapp.services.ApiServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();

    EditText username, password;
    Button button_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.editText_username);
        password = findViewById(R.id.editText_password);
        button_login = findViewById(R.id.button_login);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {

        ApiService api = ApiServiceGenerator.createService(this, ApiService.class);

        //Login login = new Login(username.toString(), password.toString());
        String usuario = username.getText().toString();
        String contra = password.getText().toString();
        Call<Usuario> call = api.login(usuario, contra);

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode );
                    if(statusCode==401){
                        Toast.makeText(LoginActivity.this, getString(R.string.invalid_credentials), Toast.LENGTH_LONG).show();
                        return;
                    }

                    if (response.isSuccessful()) {

                        Usuario usuario = response.body();
                        UsuarioRepository.createUser(usuario);
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(LoginActivity.this, "Bienvenido(a) " + usuario.nomuno, Toast.LENGTH_LONG).show();
                        finish();
                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {

            }
        });


    }
}
