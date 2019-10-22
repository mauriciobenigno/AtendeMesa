package br.com.mauriciobenigno.atendemesa.Model.Dados;

import java.util.List;

import br.com.mauriciobenigno.atendemesa.Model.Classes.Mesa;
import br.com.mauriciobenigno.atendemesa.Model.Classes.UtilCardapio;
import br.com.mauriciobenigno.atendemesa.Model.Classes.UtilComanda;
import br.com.mauriciobenigno.atendemesa.Model.Classes.UtilMesa;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CaptaDados {

    @GET("mesa/{id}")
    Call<Mesa> BuscarMesa(@Path("id") String id);

    @GET("mesa")
    Call<List<UtilMesa>> BuscarMesas();

    @POST("mesa/{id}")
    Call<UtilMesa> atualizaMesa(@Path("id") int id, @Body UtilMesa mesa);

    @GET("comanda/{id}")
    Call<UtilComanda> BuscarComanda(@Path("id") String id);

    //@GET("cardapio")
    //Call<UtilCardapio> BuscarCardapio();

    @GET("cardapio")
    Call<List<UtilCardapio>> BuscarCardapio();

}
