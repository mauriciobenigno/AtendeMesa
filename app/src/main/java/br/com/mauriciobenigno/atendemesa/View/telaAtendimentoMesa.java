
package br.com.mauriciobenigno.atendemesa.View;

import androidx.appcompat.app.AppCompatActivity;
import br.com.mauriciobenigno.atendemesa.Model.Classes.Cardapio;
import br.com.mauriciobenigno.atendemesa.Presenter.DadosCardapioAdapter;
import br.com.mauriciobenigno.atendemesa.R;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class telaAtendimentoMesa extends AppCompatActivity {

    private Spinner comboComidas;
    private Spinner comboBebidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_atendimento_mesa);
        comboComidas = findViewById(R.id.comboComidas);
        comboBebidas = findViewById(R.id.comboBebidas);



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

    }
}
