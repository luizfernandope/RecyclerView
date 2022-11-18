package com.example.lista_recyclerview.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lista_recyclerview.R;


public class UsuarioViewHolder extends RecyclerView.ViewHolder {

    public TextView cpf, senha;
    public TextView numUsuario;

    public UsuarioViewHolder(@NonNull View itemView) {
        super(itemView);
        cpf = itemView.findViewById(R.id.tvCPF);
        senha = itemView.findViewById(R.id.tvSenha);
        numUsuario = itemView.findViewById(R.id.tvNumUsuario);

    }
}
