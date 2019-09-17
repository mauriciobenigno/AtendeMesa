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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;

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
                Call<JSONArray> call = new RetrofitConfig().getCaptaDadosService().BuscarMesas();
                call.enqueue(new Callback<JSONArray>() {
                    @Override
                    public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
                        txtResultado.setText(response.toString());
                    }

                    @Override
                    public void onFailure(Call<JSONArray> call, Throwable t) {
                        txtResultado.setText("Deu erro");
                    }
                });
            }
        });
    }
}
