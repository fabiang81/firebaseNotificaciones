package com.fabcode.notificacionfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.iid.FirebaseInstanceId;

import RestAPI.Endpoints;
import RestAPI.adapter.RestApiAdapter;
import RestAPI.model.UsuarioRespuesta;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String ANIMAL_EMISOR = "perro";
    private static final String ANIMAL_RECEPTOR = "gato";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviarToken(View v){
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d("TOKEN", token);
        enviarTokenRegistro(token);
    }

    private void enviarTokenRegistro(String token){
        Log.d("TOKEN", token);
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Endpoints endpoints = restApiAdapter.establecerConexionesAPI();
        Call<UsuarioRespuesta> usuarioRespuestaCall = endpoints.registrarTokenID(token, ANIMAL_EMISOR);
        usuarioRespuestaCall.enqueue(new Callback<UsuarioRespuesta>() {
            @Override
            public void onResponse(Call<UsuarioRespuesta> call, Response<UsuarioRespuesta> response) {
                UsuarioRespuesta usuarioRespuesta = response.body();
                Log.d("ID_FIREBASE ", usuarioRespuesta.getId());
                Log.d("TOKEN_FIREBASE ", usuarioRespuesta.getToken());
            }

            @Override
            public void onFailure(Call<UsuarioRespuesta> call, Throwable t) {

            }
        });
    }

    public void toqueAnimal(View v){
        Log.d("TOQUE_ANIMAL", "true");
        final UsuarioRespuesta usuarioRespuesta = new UsuarioRespuesta("-KXi7AeK57I4jwpY6YgG", "123", ANIMAL_RECEPTOR);
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Endpoints endpoints = restApiAdapter.establecerConexionesAPI();
        Call<UsuarioRespuesta> usuarioRespuestaCall = endpoints.toqueAnimal(usuarioRespuesta.getId(), ANIMAL_EMISOR);
        usuarioRespuestaCall.enqueue(new Callback<UsuarioRespuesta>() {
            @Override
            public void onResponse(Call<UsuarioRespuesta> call, Response<UsuarioRespuesta> response) {
                UsuarioRespuesta usuarioRespuesta1 = response.body();
                Log.d("ID_FIREBASE", usuarioRespuesta1.getId());
                Log.d("TOKEN_FIREBASE", usuarioRespuesta1.getToken());
                Log.d("ANIMAL_FIREBASE", usuarioRespuesta1.getAnimal());
            }

            @Override
            public void onFailure(Call<UsuarioRespuesta> call, Throwable t) {

            }
        });
    }

}
