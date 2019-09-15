package br.com.mauriciobenigno.atendemesa.Model.Dados;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private final Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("http://mauriciojbas.pythonanywhere.com/mesa/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public CaptaDados getCaptaDadosService()
    {
        return this.retrofit.create(CaptaDados.class);
    }
}
