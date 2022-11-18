package com.example.lista_recyclerview.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lista_recyclerview.R;
import com.example.lista_recyclerview.ViewHolders.UsuarioViewHolder;
import com.example.lista_recyclerview.models.Usuario;

import java.util.ArrayList;
import java.util.Enumeration;

public class AdapterUsuario extends RecyclerView.Adapter<UsuarioViewHolder>
{
    private Context context;
    private ArrayList<Usuario> usuarios;

    public AdapterUsuario(Context context, ArrayList<Usuario> usuarios){
        this.context = context;
        this.usuarios = usuarios;
    }

    @NonNull
    @Override
    public com.example.lista_recyclerview.ViewHolders.UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.component_usuario, parent, false);
        UsuarioViewHolder viewHolder = new UsuarioViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.lista_recyclerview.ViewHolders.UsuarioViewHolder holder, int position) {
        Usuario usuario = usuarios.get(position);
        holder.numUsuario.setText("Usuario " + String.valueOf(position+1));
        holder.cpf.setText( "CPF: "+ usuario.getCpf());
        holder.senha.setText( "Senha: " + usuario.getSenha());
    }

    @Override
    public int getItemCount()
    {
        if (usuarios.toArray() != null)
            return usuarios.size();
        else
            return 0;
    }

}
