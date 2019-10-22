package br.com.mauriciobenigno.atendemesa.Model.Dados;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonAppend;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import br.com.mauriciobenigno.atendemesa.Model.Classes.Mesa;
import br.com.mauriciobenigno.atendemesa.Model.Classes.UtilCardapio;
import br.com.mauriciobenigno.atendemesa.Model.Classes.UtilMesa;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface CaptaDados {

    @GET("mesa/{id}")
    Call<Mesa> BuscarMesa(@Path("id") String id);

    @GET("mesa")
    Call<List<UtilMesa>> BuscarMesas();

    @POST("mesa/{id}")
    Call<UtilMesa> atualizaMesa(@Path("id") int id, @Body UtilMesa mesa);

    @GET("cardapio/{id}")
    Call<UtilCardapio> BuscarCardapio(@Path("id") String id);

    @GET("cardapio/")
    Call<List<UtilCardapio>> BuscarCardapios();


}
