package br.com.mauriciobenigno.atendemesa.Model.Classes;

import br.com.mauriciobenigno.atendemesa.R;

public class Mesa {

    private int imagemID;
    private int id;
    private String Nome;
    private String Status;
    private int Lugares;
    private String Garcom;
    private int CodigoComanda;


    public Mesa(int id, String nome, String status, int lugares) {
        this.id = id;
        this.Nome=nome;
        this.Status = status;
        this.imagemID = imagemStatus(status);
        this.Lugares = lugares;
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
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }

    public int getLugares() {
        return Lugares;
    }

    public void setLugares(int lugares) {
        this.Lugares = lugares;
    }

    public String getGarcom() {
        return Garcom;
    }

    public void setGarcom(String garcom) {
        this.Garcom = garcom;
    }

    public int getCodigoComanda() {
        return CodigoComanda;
    }

    public void setCodigoComanda(int codigoComanda) {
        this.CodigoComanda = codigoComanda;
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
            return (R.drawable.livre);
        }
        else if(status.equals("Atendida"))
        {
            return (R.drawable.atendimento);
        }
        else if(status.equals("Ocupado"))
        {
            return (R.drawable.ocupada);
        }
        return (R.drawable.numero1);
    }
}
