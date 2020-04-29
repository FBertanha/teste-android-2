package com.felipebertanha.teste2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nomeEditText;
    private Button adicionarButton;
    private ListView listaListView;
    private ArrayAdapter<String> listaAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomeEditText = findViewById(R.id.main_nome);
        adicionarButton = findViewById(R.id.main_adicionar);
        listaListView = findViewById(R.id.main_lista);

        //Criando adapter
        listaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        //Setar adapter na ListView
        listaListView.setAdapter(listaAdapter);

        listaListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final String nomeClickado = listaAdapter.getItem(position);

                //confirmar exclusao
                AlertDialog.Builder alertaConfirmacao = new AlertDialog.Builder(MainActivity.this);
                alertaConfirmacao.setTitle("Confirma exclusão?");
                alertaConfirmacao.setMessage("Deseja realmente excluir o nome: " + nomeClickado + "?");

                alertaConfirmacao.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        exibirToast("Exclusao cancelada!");
                    }
                });

                alertaConfirmacao.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listaAdapter.remove(nomeClickado);
                    }
                });

                alertaConfirmacao.setCancelable(false);
                alertaConfirmacao.show();

                return false;
            }
        });
    }


    public void adicionarPressionado(View view) {
        //pegar nome digitado
        String nomeDigitado = nomeEditText.getText().toString();

        exibirToast(nomeDigitado);

        //Adicionar na listaaa
        listaAdapter.add(nomeDigitado);

    }

    private void exibirToast(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }
}
