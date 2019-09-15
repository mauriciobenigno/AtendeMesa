package br.com.mauriciobenigno.atendemesa.View;

import androidx.appcompat.app.AppCompatActivity;
import br.com.mauriciobenigno.atendemesa.Model.Classes.Mesa;
import br.com.mauriciobenigno.atendemesa.Model.Dados.RetrofitConfig;
import br.com.mauriciobenigno.atendemesa.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
                Call<Mesa> call = new RetrofitConfig().getCaptaDadosService().BuscarMesa(Integer.toString(1));
                call.enqueue(new Callback<Mesa>() {
                    @Override
                    public void onResponse(Call<Mesa> call, Response<Mesa> response) {
                        Mesa mesa = response.body();
                        txtResultado.setText(mesa.toString());
                    }

                    @Override
                    public void onFailure(Call<Mesa> call, Throwable t) {
                        txtResultado.setText("Erro: "+t.getMessage());
                    }
                });
            }
        });
    }
}
