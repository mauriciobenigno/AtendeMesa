package br.com.mauriciobenigno.atendemesa.Presenter;

import android.util.Log;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.com.mauriciobenigno.atendemesa.Model.Classes.Mesa;
import br.com.mauriciobenigno.atendemesa.Model.Classes.UtilMesa;
import br.com.mauriciobenigno.atendemesa.Model.Dados.RetrofitConfig;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DadosMesaAdapter
{
    public static List<Mesa> listaMesas;
    //classe para pegar a lista de mesas
    public static List<Mesa> getMesasAPI()
    {
        final List<Mesa> mesaList = new ArrayList<>();

        Call<List<UtilMesa>> call = new RetrofitConfig().getCaptaDadosService().BuscarMesas();
        call.enqueue(new Callback<List<UtilMesa>>() {
            @Override
            public void onResponse(Call<List<UtilMesa>> call, Response<List<UtilMesa>> response) {
                if(!response.isSuccessful())
                {
                    Log.d("ERRO","Codigo"+Integer.toString(response.code()));
                }
                else {
                    List<UtilMesa> Mesas = response.body();
                    String saida = new String();
                    for (UtilMesa table : Mesas)
                    {
                        mesaList.add(table.parseMesa());
                    }

                }
            }

            @Override
            public void onFailure(Call<List<UtilMesa>> call, Throwable t) {
                Log.d("ERRO",t.getMessage());
            }
        });
        return  mesaList;
    }
    // Classe para alterar dados da mesa
    public static void atualizaMesa(int id, UtilMesa mesa)
    {
        //JSONObject json = mesa.toJson();
        Call<UtilMesa> call = new RetrofitConfig().getCaptaDadosService().atualizaMesa(id,mesa);
        //Call<ResponseBody> call = new RetrofitConfig().getCaptaDadosService().atualizaMesa(id,
        //        mesa.Nome,mesa.Status,mesa.Lugares,mesa.Garcom,mesa.CodigoComanda);

        call.enqueue(new Callback<UtilMesa>() {
            @Override
            public void onResponse(Call<UtilMesa> call, Response<UtilMesa> response) {
                if(!response.isSuccessful())
                {
                    Log.d("ERROPUT","Codigo "+Integer.toString(response.code()));
                }
                else
                {
                    Log.d("ERROPUT","DEU CERTO ");
                }
            }

            @Override
            public void onFailure(Call<UtilMesa> call, Throwable t) {
                Log.d("ERROPUT",t.getMessage());
            }
        });


    }
}
