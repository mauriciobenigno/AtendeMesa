package br.com.mauriciobenigno.atendemesa.Model.Classes;

import java.util.List;

public class UtilCardapio {
    public List<String> Comidas;
    public List<String> Bebidas;

    public Cardapio parseCardapio()
    {
        Cardapio cardapio = new Cardapio(this.Comidas,this.Bebidas);
        return cardapio;
    }

    public void toUtilCardapio(Cardapio cardapio)
    {
        this.Comidas = cardapio.getComidas();
        this.Bebidas = cardapio.getBebidas();
    }
}
