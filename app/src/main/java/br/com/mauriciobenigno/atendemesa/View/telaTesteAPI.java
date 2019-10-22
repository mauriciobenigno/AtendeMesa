package br.com.mauriciobenigno.atendemesa.View;

import androidx.appcompat.app.AppCompatActivity;
import br.com.mauriciobenigno.atendemesa.Model.Classes.Cardapio;
import br.com.mauriciobenigno.atendemesa.Model.Classes.UtilCardapio;
import br.com.mauriciobenigno.atendemesa.Model.Classes.UtilComanda;
import br.com.mauriciobenigno.atendemesa.Model.Classes.UtilMesa;
import br.com.mauriciobenigno.atendemesa.Model.Dados.RetrofitConfig;
import br.com.mauriciobenigno.atendemesa.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;
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

                Call<List<UtilCardapio>> call = new RetrofitConfig().getCaptaDadosService().BuscarCardapio();
                call.enqueue(new Callback<List<UtilCardapio>>() {
                    @Override
                    public void onResponse(Call<List<UtilCardapio>> call, Response<List<UtilCardapio>> response) {
                        if(!response.isSuccessful())
                        {
                            txtResultado.setText(Integer.toString(response.code()));
                        }
                        else {
                            List<UtilCardapio> card = response.body();
                            Log.d("ERROAPI","Tamanho: "+card.size());
                            UtilCardapio cardapio = card.get(0);
                            String saida ="";
                            for (int i=0; i<cardapio.Comidas.size(); i++) {
                                saida += "item: "+i+" - "+cardapio.Comidas.get(i)+"\n";
                            }
                            txtResultado.setText(saida);

                        }
                    }

                    @Override
                    public void onFailure(Call<List<UtilCardapio>> call, Throwable t) {
                        Log.d("ERROAPI","Erro:"+t.getMessage());
                    }
                });

                /*Call<List<UtilCardapio>> call = new RetrofitConfig().getCaptaDadosService().BuscarCardapio();
                call.enqueue(new Callback<UtilCardapio>() {
                    @Override
                    public void onResponse(Call<UtilCardapio> call, Response<UtilCardapio> response) {
                        if(!response.isSuccessful())
                        {
                            txtResultado.setText(Integer.toString(response.code()));
                        }
                        else{
                            UtilCardapio card = response.body();
                            String saida ="";
                            for (int i=0; i<card.Comidas.size(); i++) {
                                saida += "item: "+i+" - "+card.Comidas.get(i)+"\n";
                            }
                           txtResultado.setText(saida);
                        }
                    }

                    @Override
                    public void onFailure(Call<UtilCardapio> call, Throwable t) {
                        Log.d("ERROAPI","Erro:"+t.getMessage());
                    }
                });*/


                /*// Consulta individual, funcionando
                Call<UtilComanda> call = new RetrofitConfig().getCaptaDadosService().BuscarComanda(Integer.toString(2));
                call.enqueue(new Callback<UtilComanda>() {
                    @Override
                    public void onResponse(Call<UtilComanda> call, Response<UtilComanda> response) {
                        if(!response.isSuccessful())
                        {
                            txtResultado.setText(Integer.toString(response.code()));
                        }
                        else{
                            UtilComanda coma = response.body();
                            Log.d("ERROAPI","Comanda: "+coma.codComanda+"\nObs: "+coma.Observacao);
                            Log.d("ERROAPI","Tamanho lista comida: "+coma.Comida.size()+"\nTamanho lista bebida: "+coma.Bebida.size());
                            txtResultado.setText("Comanda: "+coma.codComanda+"\nObs: "+coma.Observacao);
                        }
                    }

                    @Override
                    public void onFailure(Call<UtilComanda> call, Throwable t) {
                        txtResultado.setText("Erro");
                        Log.d("ERROAPI","Erro");
                    }
                });*/


                /*Call<List<UtilMesa>> call = new RetrofitConfig().getCaptaDadosService().BuscarMesas();
                call.enqueue(new Callback<List<UtilMesa>>() {
                    @Override
                    public void onResponse(Call<List<UtilMesa>> call, Response<List<UtilMesa>> response) {
                        if(!response.isSuccessful())
                        {
                            txtResultado.setText(Integer.toString(response.code()));
                            //Log.d("ERROAPI",response.code());
                        }
                        else {
                            List<UtilMesa> Mesas = response.body();
                            String saida = new String();
                            for (UtilMesa table : Mesas)
                            {
                                saida+=table.parseMesa().getNome()+"\n";
                                //saida+=table.Nome+"\n";
                            }
                            //Log.d("ERROAPI",saida);
                            txtResultado.setText(saida);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<UtilMesa>> call, Throwable t) {
                        txtResultado.setText("Erro");
                    }
                });*/
            }
        });
    }
}
