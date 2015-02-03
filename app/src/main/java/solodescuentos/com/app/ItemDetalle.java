package solodescuentos.com.app;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;


public class ItemDetalle extends ActionBarActivity {
String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detalle);
        Bundle bundle = getIntent().getExtras();

        TextView tvName = (TextView) findViewById(R.id.nombre_content_label);
        TextView tvHome = (TextView) findViewById(R.id.fecha_content_value);
        TextView txtUbicacion = (TextView) findViewById(R.id.ubicacion_content_value);
        TextView txtDestino = (TextView) findViewById(R.id.destino_content_value);



        ImageView imgView = (ImageView) findViewById(R.id.imageView);
        id=bundle.getString("Extra_ID");
        tvName.setText(bundle.getString("Extra_Nombre"));
        tvHome.setText(bundle.getString("Extra_Fecha"));
        txtUbicacion.setText(bundle.getString("Extra_Ubicacion"));
        txtDestino.setText(bundle.getString("Extra_Destino"));

        if (bundle.getString("Extra_Descripcion")==null || bundle.getString("Extra_Descripcion")==""){
            Picasso.with(getApplicationContext()).load("http://icons.iconarchive.com/icons/guillendesign/variations-3/256/Default-Icon-icon.png").into(imgView);
        }else{
            Picasso.with(getApplicationContext()).load(bundle.getString("Extra_Descripcion")).into(imgView);
        }


    }



    public void deleteItem(View view){
        new HttpRequestTask2().execute(id);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.item_tienda_detalle, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private class HttpRequestTask2 extends AsyncTask<String, Integer, Integer> {
        @Override
        protected Integer doInBackground(String... args ) {
            try {
                final String url = "http://restsunat.herokuapp.com/notificaciones/"+args[0];
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                restTemplate.delete(url);
                // URL u = new URL();
                return null;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }
            return null;




        }
    }

   }
