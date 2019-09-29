package br.com.mauriciobenigno.atendemesa.Model.Classes;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;

import java.io.File;

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

    public void toMesaUtil(Mesa mesa)
    {
        id = Integer.toString(mesa.getId());
        Status = mesa.getStatus();
        Nome = mesa.getNome();
        Lugares = Integer.toString(mesa.getLugares());
        Garcom = mesa.getGarcom();
        CodigoComanda = Integer.toString(mesa.getCodigoComanda());
    }

    public JSONObject toJson()
    {
        JSONObject json = new JSONObject();
        try {
            json.put("id", this.id);
            json.put("Nome", this.Nome);
            json.put("Status", this.Status);
            json.put("Lugares", this.Lugares);
            json.put("Garcom", this.Garcom);
            json.put("CodigoComanda", this.CodigoComanda);
            return json;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }
}
