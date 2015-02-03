package solodescuentos.com.app;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by prac-mzavaleta on 26/01/2015.
 */
public class TiendaAdapter extends ArrayAdapter<Greeting> {


    public TiendaAdapter(Context context, ArrayList<Greeting> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Greeting item = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_tiendas, parent, false);
        }



        // Lookup view for data population descripcion_content_label
        TextView tvName = (TextView) convertView.findViewById(R.id.nombre_content_label);
        TextView tvHome = (TextView) convertView.findViewById(R.id.fecha_content_value);

        ImageView imgView = (ImageView) convertView.findViewById(R.id.imageView);
        Button btn = (Button) convertView.findViewById(R.id.buttonMore);
       // btn.setText(item.get_id());


        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ItemDetalle.class);
                intent.putExtra("Extra_Nombre", item.getNombre());
                intent.putExtra("Extra_Fecha", item.getFecha());
                intent.putExtra("Extra_Ubicacion", item.getUbicacion());
                intent.putExtra("Extra_Destino", item.getDestino());
                intent.putExtra("Extra_Descripcion", item.getDescripcion());
                intent.putExtra("Extra_ID", item.get_id());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               // startActivity(intent);
                getContext().startActivity(intent);
              //  Toast.makeText(getContext(), "id"+item.get_id(), Toast.LENGTH_LONG).show();
            }
        });
        // Populate the data into the template view using the data object
        tvName.setText(item.getNombre());
        tvHome.setText(item.getFecha());

        if (item.getDescripcion()==null || item.getDescripcion()==""){
            Picasso.with(getContext()).load("http://icons.iconarchive.com/icons/guillendesign/variations-3/256/Default-Icon-icon.png").into(imgView);
        }else{
            Picasso.with(getContext()).load(item.getDescripcion()).into(imgView);
        }





        return convertView;





    }

    }




