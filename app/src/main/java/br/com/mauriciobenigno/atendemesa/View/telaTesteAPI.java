package br.com.mauriciobenigno.atendemesa.View;

import androidx.appcompat.app.AppCompatActivity;
import br.com.mauriciobenigno.atendemesa.Model.Classes.Mesa;
import br.com.mauriciobenigno.atendemesa.Model.Classes.UtilMesa;
import br.com.mauriciobenigno.atendemesa.Model.Dados.RetrofitConfig;
import br.com.mauriciobenigno.atendemesa.Presenter.DadosMesaAdapter;
import br.com.mauriciobenigno.atendemesa.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class telaTesteAPI extends AppCompatActivity {

    TextView txtResultado;
    Button btResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_teste_api);

        txtResultado = (TextView)findViewById(R.id.textView2);
        btResultado = (Button)findViewById(R.id.btAtivar);

        btResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<List<UtilMesa>> call = new RetrofitConfig().getCaptaDadosService().BuscarMesas();
                call.enqueue(new Callback<List<UtilMesa>>() {
                    @Override
                    public void onResponse(Call<List<UtilMesa>> call, Response<List<UtilMesa>> response) {
                        if(!response.isSuccessful())
                        {
                            txtResultado.setText(response.code());
                        }
                        else {
                            List<UtilMesa> Mesas = response.body();
                            String saida = new String();
                            for (UtilMesa table : Mesas)
                            {
                                saida+=table.parseMesa().getNome()+"\n";
                                //saida+=table.Nome+"\n";
                            }
                            txtResultado.setText(saida);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<UtilMesa>> call, Throwable t) {
                        txtResultado.setText("Erro");
                    }
                });
            }
        });
    }
}
