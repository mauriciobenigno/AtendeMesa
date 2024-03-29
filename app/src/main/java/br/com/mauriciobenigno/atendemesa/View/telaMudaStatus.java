package br.com.mauriciobenigno.atendemesa.View;

import androidx.appcompat.app.AppCompatActivity;
import br.com.mauriciobenigno.atendemesa.Model.Classes.Mesa;
import br.com.mauriciobenigno.atendemesa.Model.Classes.UtilMesa;
import br.com.mauriciobenigno.atendemesa.Presenter.DadosMesaAdapter;
import br.com.mauriciobenigno.atendemesa.R;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

public class telaMudaStatus extends AppCompatActivity {

    private List<Mesa> listaMesas;
    TextView txtNomeStatus;
    Button btMudaStatus;
    RadioButton rbLivre;
    RadioButton rbOcupado;
    RadioButton rbAtendida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_muda_status);

        txtNomeStatus=(TextView)findViewById(R.id.txtIdMesa);
        btMudaStatus=(Button)findViewById(R.id.btSetarStatus);
        rbLivre=(RadioButton)findViewById(R.id.rbLivre);
        rbOcupado=(RadioButton)findViewById(R.id.rbOcupado);
        rbAtendida=(RadioButton)findViewById(R.id.rbAtendido);

        // Receber lista atualizada de status
        listaMesas = DadosMesaAdapter.listaMesas;
        //recuperar a informação id
        Intent intent= getIntent();
        Bundle bundle = intent.getExtras();
        int ID = bundle.getInt("ID");

        String infos = new String();
        infos +=listaMesas.get(ID).getNome()+"\n";
        infos +="STATUS: "+listaMesas.get(ID).getStatus();
        txtNomeStatus.setText(infos);

        // Converte a mesa em Util mesa para envio para API
        final UtilMesa mesaEnvio = new UtilMesa();
        mesaEnvio.toMesaUtil(listaMesas.get(ID));

        btMudaStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rbLivre.isChecked())
                {
                    //Chamar api para setar esse id como Livre
                    mesaEnvio.Status="Livre";
                    DadosMesaAdapter.atualizaMesa(Integer.parseInt(mesaEnvio.id),mesaEnvio);
                    //listaMesas.get(ID).setStatus("Livre");
                }
                else if(rbAtendida.isChecked())
                {
                    //Chamar API para setar esse id como Atendida
                    mesaEnvio.Status="Atendida";
                    DadosMesaAdapter.atualizaMesa(Integer.parseInt(mesaEnvio.id),mesaEnvio);
                }
                else
                {
                    //Chamar API para setar esse id como ocupado
                    mesaEnvio.Status="Ocupado";
                    DadosMesaAdapter.atualizaMesa(Integer.parseInt(mesaEnvio.id),mesaEnvio);
                }
                DadosMesaAdapter.listaMesas = DadosMesaAdapter.getMesasAPI();
                Intent intent = new Intent(getApplicationContext(), telaMesas.class);
                startActivity(intent);
                finish();
            }
        });



    }
}
