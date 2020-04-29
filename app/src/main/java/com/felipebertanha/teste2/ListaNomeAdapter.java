package com.felipebertanha.teste2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListaNomeAdapter extends BaseAdapter {

    private Context context;
    private final List<Pessoa> pessoas;

    public ListaNomeAdapter(Context context, List<Pessoa> pessoas) {
        this.context = context;
        this.pessoas = pessoas;
    }

    @Override
    public int getCount() {
        return pessoas.size();
    }

    @Override
    public Object getItem(int position) {
        return pessoas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lista_nome, parent, false);

        TextView nomeTextView = view.findViewById(R.id.item_lista_nome_nome);
        TextView sobrenomeTextView = view.findViewById(R.id.item_lista_nome_sobrenome);

        Pessoa pessoaAtual = (Pessoa) getItem(position);

        nomeTextView.setText(pessoaAtual.getNome());
        sobrenomeTextView.setText(pessoaAtual.getSobrenome());

        return view;
    }

    public void remove(Pessoa pessoaClickada) {
        pessoas.remove(pessoaClickada);
        notifyDataSetChanged();
    }

    public void add(Pessoa pessoa) {
        pessoas.add(pessoa);
        notifyDataSetChanged();
    }
}
