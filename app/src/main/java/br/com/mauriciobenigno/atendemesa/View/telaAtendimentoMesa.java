
package br.com.mauriciobenigno.atendemesa.View;

import androidx.appcompat.app.AppCompatActivity;
import br.com.mauriciobenigno.atendemesa.Model.Classes.Cardapio;
import br.com.mauriciobenigno.atendemesa.Presenter.DadosCardapioAdapter;
import br.com.mauriciobenigno.atendemesa.R;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class telaAtendimentoMesa extends AppCompatActivity {

    // ComboBox
    private Spinner comboComidas;
    private Spinner comboBebidas;
    // Botões
    private Button btIncluirComida;
    private Button btIncluirBebida;
    private Button btProsseguirPedido;
    // Lista
    private ListView listaItens;
    ArrayList<String> listItems=new ArrayList<String>();
    private ArrayAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_atendimento_mesa);
        comboComidas = findViewById(R.id.comboComidas);
        comboBebidas = findViewById(R.id.comboBebidas);
        // botões
        btIncluirComida = findViewById(R.id.btIncluirComida);
        btIncluirBebida = findViewById(R.id.btIncluirBebida);
        btProsseguirPedido = findViewById(R.id.btProsseguirPedido);
        // lista
        listaItens = findViewById(R.id.listViewItens);


        // Obtem lista de comida e bebida da API
        Cardapio cardapio = DadosCardapioAdapter.cardap;//DadosCardapioAdapter.getCardapio();
        Log.d("CARDAP","Quantidade comidas: "+cardapio.getComidas().size());

        if(!cardapio.getComidas().isEmpty())
        {
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, cardapio.getComidas());
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            comboComidas.setAdapter(dataAdapter);
        }

        if(!cardapio.getBebidas().isEmpty())
        {
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, cardapio.getBebidas());
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            comboBebidas.setAdapter(dataAdapter);
        }


        btIncluirComida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = comboComidas.getItemAtPosition(comboComidas.getSelectedItemPosition()).toString();
                listItems.add(item);
                mAdapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1, listItems);
                listaItens.setAdapter(mAdapter);
            }
        });

        btIncluirBebida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = comboBebidas.getItemAtPosition(comboBebidas.getSelectedItemPosition()).toString();
                listItems.add(item);
                mAdapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1, listItems);
                listaItens.setAdapter(mAdapter);
            }
        });

        btProsseguirPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), telaConcluirPedido.class);
                startActivity(intent);
            }
        });

    }
}
