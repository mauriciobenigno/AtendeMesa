package br.com.mauriciobenigno.atendemesa.Model.Classes;

public class UtilMesa {
    public String id;
    public String Status;
    public String Nome;
    public String Lugares;
    public String Garcom;
    public String CodigoComanda;

    public Mesa parseMesa()
    {
        Mesa mesa = new Mesa(Integer.parseInt(id), Nome, Status, Integer.parseInt(Lugares));
        mesa.setGarcom(Garcom);
        mesa.setCodigoComanda(Integer.parseInt(CodigoComanda));
        return mesa;
    }
}
