package br.com.mauriciobenigno.atendemesa;

import androidx.appcompat.app.AppCompatActivity;
import br.com.mauriciobenigno.atendemesa.Presenter.DadosMesaAdapter;
import br.com.mauriciobenigno.atendemesa.View.telaMesas;
import br.com.mauriciobenigno.atendemesa.View.telaTesteAPI;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btAbrirTela;
    Button btTestarAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Faz consulta no webservice para adiantar os dados, para ficarem pré carregados na tela de mesas
        DadosMesaAdapter.listaMesas = DadosMesaAdapter.getMesasAPI();

        btAbrirTela = (Button)findViewById(R.id.btAbrirTelaTeste);
        btTestarAPI = (Button)findViewById(R.id.btTesteAPI);

        btAbrirTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), telaMesas.class);
                 startActivity(intent);
            }
        });

        btTestarAPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), telaTesteAPI.class);
                startActivity(intent);
            }
        });


    }
}
