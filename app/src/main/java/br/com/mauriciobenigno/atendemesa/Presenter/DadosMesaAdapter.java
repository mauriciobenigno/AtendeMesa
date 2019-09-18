package br.com.mauriciobenigno.atendemesa.Presenter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.com.mauriciobenigno.atendemesa.Model.Classes.Mesa;
import br.com.mauriciobenigno.atendemesa.Model.Classes.UtilMesa;
import br.com.mauriciobenigno.atendemesa.Model.Dados.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DadosMesaAdapter
{
    //classe para teste
    public static List<Mesa> getMesasAPI()
    {
        final List<Mesa> mesaList = new ArrayList<>();

        Call<List<UtilMesa>> call = new RetrofitConfig().getCaptaDadosService().BuscarMesas();
        call.enqueue(new Callback<List<UtilMesa>>() {
            @Override
            public void onResponse(Call<List<UtilMesa>> call, Response<List<UtilMesa>> response) {
                if(!response.isSuccessful())
                {
                    //txtResultado.setText(response.code());
                }
                else {
                    List<UtilMesa> Mesas = response.body();
                    String saida = new String();
                    for (UtilMesa table : Mesas)
                    {
                        mesaList.add(table.parseMesa());
                        //saida+=table.parseMesa().getNome()+"\n";
                        //saida+=table.Nome+"\n";
                    }
                    //txtResultado.setText(saida);
                }
            }

            @Override
            public void onFailure(Call<List<UtilMesa>> call, Throwable t) {
                //txtResultado.setText("Erro");
            }
        });
        return  mesaList;
    }
}
