package br.com.mauriciobenigno.atendemesa.Presenter;

import android.util.Log;

import java.util.ArrayList;
import br.com.mauriciobenigno.atendemesa.Model.Classes.Comanda;
import br.com.mauriciobenigno.atendemesa.Model.Classes.UtilComanda;
import br.com.mauriciobenigno.atendemesa.Model.Dados.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DadosComandaAdapter {

    public static Comanda getComanda(int id)
    {
        final Comanda retorno = new Comanda(0,new ArrayList<String>(),new ArrayList<String>(), "ik");

        Call<UtilComanda> call = new RetrofitConfig().getCaptaDadosService().BuscarComanda(Integer.toString(2));
        call.enqueue(new Callback<UtilComanda>() {
            @Override
            public void onResponse(Call<UtilComanda> call, Response<UtilComanda> response) {
                if(!response.isSuccessful())
                {
                    Log.d("ERROAPI","Codigo"+Integer.toString(response.code()));
                }
                else{
                    UtilComanda utilComanda = response.body();
                    retorno.setCodComanda(utilComanda.codComanda);
                    retorno.setComida(utilComanda.Comida);
                    retorno.setBebida(utilComanda.Bebida);
                    retorno.setObservacao(utilComanda.Observacao);
                }
            }

            @Override
            public void onFailure(Call<UtilComanda> call, Throwable t) {
                Log.d("ERROAPI","Erro");
            }
        });
        return retorno;
    }


}
