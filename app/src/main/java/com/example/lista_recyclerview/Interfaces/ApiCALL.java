package com.example.lista_recyclerview.Interfaces;

import com.example.lista_recyclerview.models.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCALL {

    // https://clinica-api-tcc.herokuapp.com/             usuarios/getAll


    // Usuario.
    @GET("usuarios/getAll")
    Call<List<Usuario>> listarUsuarios();
}
