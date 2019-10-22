package br.com.mauriciobenigno.atendemesa.Model.Classes;

import java.util.List;

public class UtilComanda {
    public String codComanda;
    public List<String> Comida;
    public List<String> Bebida;
    public String Observacao;

    public Comanda parseComanda()
    {
        Comanda comanda = new Comanda(Integer.parseInt(this.codComanda),this.Comida,this.Bebida,this.Observacao);
        return comanda;
    }

    public void toComandaUtil(Comanda cardapio)
    {
        this.codComanda = Integer.toString(cardapio.getCodComanda());
        this.Comida = cardapio.getComida();
        this.Bebida = cardapio.getBebida();
        this.Observacao = cardapio.getObservacao();
    }
}
