package br.com.mauriciobenigno.atendemesa.Presenter;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.mauriciobenigno.atendemesa.Model.Classes.Cardapio;
import br.com.mauriciobenigno.atendemesa.Model.Classes.UtilCardapio;
import br.com.mauriciobenigno.atendemesa.Model.Dados.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DadosCardapioAdapter {

    public static Cardapio getCardapio(int id)
    {
        final Cardapio retorno = new Cardapio(0,new ArrayList<String>(),new ArrayList<String>(), "ik");
        Call<UtilCardapio> call = new RetrofitConfig().getCaptaDadosService().BuscarCardapio(Integer.toString(id));
        call.enqueue(new Callback<UtilCardapio>() {
            @Override
            public void onResponse(Call<UtilCardapio> call, Response<UtilCardapio> response) {
                if(!response.isSuccessful())
                {
                    Log.d("ERROP","Codigo"+Integer.toString(response.code()));
                }
                else {
                    UtilCardapio utilCardapio = response.body();
                    retorno.setCodComanda(utilCardapio.codComanda);
                    retorno.setComida(utilCardapio.Comida);
                    retorno.setBebida(utilCardapio.Bebida);
                    retorno.setObservacao(utilCardapio.Observacao);
                }
            }

            @Override
            public void onFailure(Call<UtilCardapio> call, Throwable t) {
                Log.d("ERROP",t.getMessage());
            }
        });
        return retorno;
    }

    /*public static List<Cardapio> getCardapios()
    {

    }*/
}
