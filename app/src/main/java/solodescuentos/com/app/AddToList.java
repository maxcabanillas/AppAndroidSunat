package solodescuentos.com.app;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


public class AddToList extends ActionBarActivity {
    //static AddToList app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_list);
        //app = ((AddToList)getApplicationContext());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_to_list, menu);
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


    public void Message (View view){
        Toast.makeText(getApplicationContext(),"Su Registro ha sido grabado, Puede verificarlo cargando la Lista Nuevamente",Toast.LENGTH_LONG).show();
        finish();
    }
    public void GrabarPostExcecute (View view){
        TextView txtNombre = (TextView) findViewById(R.id.textViewNombre);
        TextView txtUbicacion = (TextView) findViewById(R.id.textViewUbicacion);
        TextView txtDestino = (TextView) findViewById(R.id.textViewDestino);
        TextView txtFecha = (TextView) findViewById(R.id.textViewFecha);
        TextView txtDescripcion = (TextView) findViewById(R.id.textViewDescripcion);
        //  new HttpRequestTask3().execute("Manuel","Zavaleta","Vargas","Destino","https://media.licdn.com/mpr/mpr/shrink_120_120/p/6/005/092/16e/3038a67.jpg");
        Message(view);
        new HttpRequestTask3().execute(txtNombre.getText().toString(),txtFecha.getText().toString(),txtUbicacion.getText().toString(),txtDestino.getText().toString(),txtDescripcion.getText().toString());
    }



    private class HttpRequestTask3 extends AsyncTask<String, Integer, Integer> {
        @Override
        protected Integer doInBackground(String... args ) {




            try {
                Log.e("MainActivity", "post");
                final String url = "http://restsunat.herokuapp.com/notificaciones/";
                RestTemplate restTemplate = new RestTemplate();

                HttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
                HttpMessageConverter stringHttpMessageConverternew = new StringHttpMessageConverter();

                restTemplate.getMessageConverters().add(formHttpMessageConverter);
                restTemplate.getMessageConverters().add(stringHttpMessageConverternew);

                MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
                map.add("nombre", args[0] );
                map.add("fecha", args[1]);
                map.add("ubicacion", args[2]);
                map.add("destino", args[3]);
                map.add("descripcion", args[4]);

                restTemplate.postForObject(url,map, String.class);


                return null;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }
            return null;




        }




    }
}
