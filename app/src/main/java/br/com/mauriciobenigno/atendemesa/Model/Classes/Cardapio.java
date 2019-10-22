package br.com.mauriciobenigno.atendemesa.Model.Classes;

import java.util.List;

public class Cardapio {
    private List<String> Comidas;
    private List<String> Bebidas;

    public Cardapio(List<String> comidas, List<String> bebidas) {
        Comidas = comidas;
        Bebidas = bebidas;
    }

    public List<String> getComidas() {
        return Comidas;
    }

    public void setComidas(List<String> comidas) {
        Comidas = comidas;
    }

    public List<String> getBebidas() {
        return Bebidas;
    }

    public void setBebidas(List<String> bebidas) {
        Bebidas = bebidas;
    }
}
