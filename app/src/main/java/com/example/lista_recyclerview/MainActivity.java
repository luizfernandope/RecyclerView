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



        listaUsuarios = new ArrayList<Usuario>();//tem q inicializar a lista para não dar erros
        configurarRetrofit();
        Call<List<Usuario>> mostarUsuarios = apiCall.listarUsuarios();
        mostarUsuarios.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {

                for(int i=0; i<response.body().size(); i++){
                    System.out.println("\n"+response.body().get(i).getCpf() + "|" + response.body().get(i).getSenha());
                    listaUsuarios.add(response.body().get(i));

                }
                inicializarListagem();
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {

            }
        });






    }

    void inicializarListagem(){

            recyclerView = findViewById(R.id.recyclerView_usuarios);
            recyclerView.setHasFixedSize(true);//da mais desempenho na listagem
            adapterUsuario = new AdapterUsuario(MainActivity.this, listaUsuarios);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapterUsuario);

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