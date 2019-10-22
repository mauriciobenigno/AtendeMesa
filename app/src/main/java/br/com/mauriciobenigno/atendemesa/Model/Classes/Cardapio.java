package br.com.mauriciobenigno.atendemesa.Model.Classes;

import java.util.List;

public class Cardapio {
    private int codComanda;
    private List<String> Comida;
    private List<String> Bebida;
    private String Observacao;

    public Cardapio(int codComanda, List<String> comida, List<String> bebida, String observacao) {
        this.codComanda = codComanda;
        Comida = comida;
        Bebida = bebida;
        Observacao = observacao;
    }

    public int getCodComanda() {
        return codComanda;
    }

    public void setCodComanda(String codComanda) {
        this.codComanda = codComanda;
    }

    public List<String> getComida() {
        return Comida;
    }

    public void setComida(List<String> comida) {
        Comida = comida;
    }

    public List<String> getBebida() {
        return Bebida;
    }

    public void setBebida(List<String> bebida) {
        Bebida = bebida;
    }

    public String getObservacao() {
        return Observacao;
    }

    public void setObservacao(String observacao) {
        Observacao = observacao;
    }
}
