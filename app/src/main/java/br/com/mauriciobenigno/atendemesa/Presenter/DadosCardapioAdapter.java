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

    public static Cardapio cardap;

    public static Cardapio getCardapio()
    {
        final Cardapio retorno = new Cardapio(new ArrayList<String>(),new ArrayList<String>());

        Call<List<UtilCardapio>> call = new RetrofitConfig().getCaptaDadosService().BuscarCardapio();
        call.enqueue(new Callback<List<UtilCardapio>>() {
            @Override
            public void onResponse(Call<List<UtilCardapio>> call, Response<List<UtilCardapio>> response) {
                if(!response.isSuccessful())
                {
                    Log.d("ERROAPI","Codigo"+Integer.toString(response.code()));
                }
                else {
                    List<UtilCardapio> card = response.body();
                    UtilCardapio cardapio = card.get(0);
                    retorno.setComidas(cardapio.Comidas);
                    retorno.setBebidas(cardapio.Bebidas);
                }
            }

            @Override
            public void onFailure(Call<List<UtilCardapio>> call, Throwable t) {
                Log.d("ERROAPI","Erro:"+t.getMessage());
            }
        });

        return retorno;
    }
}
