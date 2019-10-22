package br.com.mauriciobenigno.atendemesa.Model.Classes;

import java.util.List;

public class UtilCardapio {
    public String codComanda;
    public List<String> Comida;
    public List<String> Bebida;
    public String Observacao;

    public Cardapio parseCardapio()
    {
        Cardapio cardapio = new Cardapio(Integer.parseInt(this.codComanda),this.Comida,this.Bebida,this.Observacao);
        return cardapio;
    }

    public void toCardapioUtil(Cardapio cardapio)
    {
        this.codComanda = Integer.toString(cardapio.getCodComanda());
        this.Comida = cardapio.getComida();
        this.Bebida = cardapio.getBebida();
        this.Observacao = cardapio.getObservacao();
    }
}
