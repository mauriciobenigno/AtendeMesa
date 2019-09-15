package br.com.mauriciobenigno.atendemesa.View;

import androidx.appcompat.app.AppCompatActivity;
import br.com.mauriciobenigno.atendemesa.Model.Classes.Mesa;
import br.com.mauriciobenigno.atendemesa.Presenter.GridViewAdapter;
import br.com.mauriciobenigno.atendemesa.Presenter.ListViewAdapter;
import br.com.mauriciobenigno.atendemesa.R;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class telaMesas extends AppCompatActivity {

    private ViewStub stubListMesa;
    private ViewStub stubGridMesa;
    private ListView listViewMesas;
    private GridView gridViewMesas;

    private ListViewAdapter listViewAdapter;
    private GridViewAdapter gridViewAdapter;

    private List<Mesa> listaMesas;
    private int modoVisualizacao = 0;

    static final int VISUALIZAR_MODO_LISTA = 0;
    static final int VISUALIZAR_MODO_GRADE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_mesas);

        stubListMesa = (ViewStub)findViewById(R.id.stub_list_mesas);
        stubGridMesa = (ViewStub)findViewById(R.id.stub_grid_mesas);

        stubListMesa.inflate();
        stubGridMesa.inflate();

        listViewMesas = findViewById(R.id.listMesas);
        gridViewMesas = findViewById(R.id.gridMesas);


        // recebe a lista de mesas
        listaMesas = getListaMesas();

        // restaura o ultimo modo de visualização definido no aplicativo
        SharedPreferences sharedPreferences = getSharedPreferences("Status",MODE_PRIVATE);
        modoVisualizacao = sharedPreferences.getInt("ModoVisualizacao", VISUALIZAR_MODO_LISTA);

        listViewMesas.setOnItemClickListener(onItemClickListener);
        gridViewMesas.setOnItemClickListener(onItemClickListener);


        AdaptarVisualizacao();

    }


    //classe para teste
    public List<Mesa> getListaMesas()
    {
        List<Mesa> mesaList = new ArrayList<>();
        mesaList.add(new Mesa(1,"Mesa 1", "Livre",4));
        mesaList.add(new Mesa(2,"Mesa 2", "Livre",6));
        mesaList.add(new Mesa(3,"Mesa 3", "Livre",5));
        mesaList.add(new Mesa(4,"Mesa 4", "Ocupado",3));
        mesaList.add(new Mesa(5,"Mesa 5", "Livre",2));
        mesaList.add(new Mesa(6,"Mesa 6", "Atendimento",4));
        mesaList.add(new Mesa(7,"Mesa 7", "Ocupado",7));
        mesaList.add(new Mesa(8,"Mesa 8", "Livre",8));
        return  mesaList;
    }


    private void AdaptarVisualizacao()
    {
        if(VISUALIZAR_MODO_LISTA == modoVisualizacao)
        {
            stubListMesa.setVisibility(View.VISIBLE);
            stubGridMesa.setVisibility(View.GONE);
        }
        else
        {
            stubListMesa.setVisibility(View.GONE);
            stubGridMesa.setVisibility(View.VISIBLE);
        }
        setAdaptador();
    }

    private void setAdaptador()
    {
        if(VISUALIZAR_MODO_LISTA == modoVisualizacao)
        {
            listViewAdapter = new ListViewAdapter(this,R.layout.list_mesa, listaMesas);
            listViewMesas.setAdapter(listViewAdapter);
        }
        else
        {
            gridViewAdapter = new GridViewAdapter(this,R.layout.grid_mesa, listaMesas);
            gridViewMesas.setAdapter(gridViewAdapter);
        }
    }


    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Toast.makeText(getApplicationContext(), listaMesas.get(i).getNome()+" - "+
                    listaMesas.get(i).getStatus(),Toast.LENGTH_LONG).show();
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menudireito,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu_item_visualizacao:
                if(VISUALIZAR_MODO_GRADE == modoVisualizacao)
                {
                    listViewAdapter = new ListViewAdapter(this,R.layout.list_mesa, listaMesas);
                    listViewMesas.setAdapter(listViewAdapter);
                    modoVisualizacao = VISUALIZAR_MODO_LISTA;
                }
                else
                {
                    gridViewAdapter = new GridViewAdapter(this,R.layout.grid_mesa, listaMesas);
                    gridViewMesas.setAdapter(gridViewAdapter);
                    modoVisualizacao = VISUALIZAR_MODO_GRADE;

                }
                AdaptarVisualizacao();
                // salva preferencias de visualização
                SharedPreferences sharedPreferences  = getSharedPreferences("Status", MODE_PRIVATE);
                SharedPreferences.Editor editor =  sharedPreferences.edit();
                editor.putInt("ModoVisualizacao",modoVisualizacao);
                editor.commit();
        }
        return true;
    }
}
