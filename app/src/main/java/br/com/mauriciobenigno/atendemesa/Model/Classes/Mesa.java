package br.com.mauriciobenigno.atendemesa.Model.Classes;

import br.com.mauriciobenigno.atendemesa.R;

public class Mesa {

    private int imagemID;
    private int id;
    private String nome;
    private String status;
    private int lugares;
    private String garcom;
    private int codigoComanda;


    public Mesa(int id, String nome, String status, int lugares) {
        this.id = id;
        this.nome=nome;
        this.status = status;
        this.imagemID = imagemStatus(status);
        this.lugares = lugares;
    }

    public int getImagemID() {
        return imagemID;
    }

    public void setImagemID(int imagemID) {
        this.imagemID = imagemID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getLugares() {
        return lugares;
    }

    public void setLugares(int lugares) {
        this.lugares = lugares;
    }

    public String getGarcom() {
        return garcom;
    }

    public void setGarcom(String garcom) {
        this.garcom = garcom;
    }

    public int getCodigoComanda() {
        return codigoComanda;
    }

    public void setCodigoComanda(int codigoComanda) {
        this.codigoComanda = codigoComanda;
    }

    @Override
    public  String toString()
    {
        return "ID: "+ getId()+
                "\nNome: " + getNome()+
                "\nStatus: "+ getStatus()+
                "\nLugares: "+ getLugares()+
                "\nGarçom: "+ getGarcom()+
                "\nCodigoComanda: "+getCodigoComanda();
    }

    private int imagemStatus(String status)
    {
        if(status.equals("Livre"))
        {
            return (R.drawable.numero1);
        }
        else if(status.equals("Em Atendimento"))
        {
            return (R.drawable.numero2);
        }
        else if(status.equals("Ocupado"))
        {
            return (R.drawable.numero3);
        }
        return (R.drawable.numero1);
    }
}
