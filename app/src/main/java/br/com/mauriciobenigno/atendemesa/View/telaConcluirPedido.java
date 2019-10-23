package br.com.mauriciobenigno.atendemesa.View;

import androidx.appcompat.app.AppCompatActivity;
import br.com.mauriciobenigno.atendemesa.R;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class telaConcluirPedido extends AppCompatActivity {

    private Button btConcluirComanda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_concluir_pedido);

        btConcluirComanda = findViewById(R.id.btConcluirComanda);

        btConcluirComanda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // adicionar código aqui para enviar comanda para o webservice

                // codigo para finalizar a tela.
                finish();
            }
        });
    }
}
