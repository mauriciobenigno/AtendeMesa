package br.com.mauriciobenigno.atendemesa.Model.Dados;

import org.json.JSONArray;

import java.util.List;

import br.com.mauriciobenigno.atendemesa.Model.Classes.Mesa;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CaptaDados {

    @GET("{id}")
    Call<Mesa> BuscarMesa(@Path("id") String id);

    /*@GET("mesa")
    Call<String> BuscarMesas();*/

    @GET("mesa")
    Call<JSONArray> BuscarMesas();


    /*@PUT("{id}")
    AlteraMesa(@Path("id") String id, );*/

}
