package br.com.mauriciobenigno.atendemesa.Presenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import br.com.mauriciobenigno.atendemesa.Model.Classes.Mesa;
import br.com.mauriciobenigno.atendemesa.R;

public class ListViewAdapter extends ArrayAdapter<Mesa> {
    public ListViewAdapter(@NonNull Context context, int resource, @NonNull List<Mesa> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if(v==null)
        {
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_mesa, null);
        }

        Mesa mesa = getItem(position);
        ImageView img = (ImageView)v.findViewById(R.id.imageView);
        TextView txtNome = (TextView)v.findViewById(R.id.txtNome);
        TextView txtStatus = (TextView)v.findViewById(R.id.txtStatus);
        TextView txtLugares = (TextView)v.findViewById(R.id.txtLugares);

        img.setImageResource(mesa.getImagemID());
        txtNome.setText(mesa.getNome());
        txtStatus.setText(mesa.getStatus());
        txtLugares.setText("Lugares: "+Integer.toString(mesa.getLugares()));

        return v;
    }
}
