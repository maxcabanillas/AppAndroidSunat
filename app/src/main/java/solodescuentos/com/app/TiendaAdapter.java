package solodescuentos.com.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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
        Greeting item = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_tiendas, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.nombre_content_label);
        TextView tvHome = (TextView) convertView.findViewById(R.id.fecha_content_value);
        // Populate the data into the template view using the data object
        tvName.setText(item.getNombre());
        tvHome.setText(item.getFecha());
        // Return the completed view to render on screen
        return convertView;
    }
}