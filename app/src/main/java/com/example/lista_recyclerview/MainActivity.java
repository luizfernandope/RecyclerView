package com.example.lista_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.lista_recyclerview.Adapters.AdapterUsuario;
import com.example.lista_recyclerview.Interfaces.ApiCALL;
import com.example.lista_recyclerview.models.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ApiCALL apiCall;
    RecyclerView recyclerView;
     AdapterUsuario adapterUsuario;
     ArrayList<Usuario> listaUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView_usuarios);
        recyclerView.setHasFixedSize(true);//da mais desempenho na listagem

        listaUsuarios = new ArrayList<Usuario>();
        listaUsuarios.add(new Usuario("111", "s1nha"));
        listaUsuarios.add(new Usuario("222", "s2nha"));
        listaUsuarios.add(new Usuario("333", "s3nha"));
        listaUsuarios.add(new Usuario("444", "s4nha"));
        listaUsuarios.add(new Usuario("555", "s5nha"));
        listaUsuarios.add(new Usuario("666", "s6nha"));
        listaUsuarios.add(new Usuario("777", "s7nha"));
        listaUsuarios.add(new Usuario("888", "s8nha"));


        adapterUsuario = new AdapterUsuario(MainActivity.this, listaUsuarios);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterUsuario);

        configurarRetrofit();
        Call<List<Usuario>> mostarUsuarios = apiCall.listarUsuarios();

//        mostarUsuarios.enqueue(new Callback<List<Usuario>>() {
//            @Override
//            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Usuario>> call, Throwable t) {
//
//            }
//        });
    }

    void configurarRetrofit(){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://clinica-api-tcc.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        // Instacia da interface;
        apiCall = retrofit.create(ApiCALL.class);

    }
}