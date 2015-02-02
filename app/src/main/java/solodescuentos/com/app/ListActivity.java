package solodescuentos.com.app;


import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;


public class ListActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        new HttpRequestTask().execute();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
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
            new HttpRequestTask().execute();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*public void Eliminar(View view){
        Button btn = (Button) findViewById(R.id.buttonDelete);
       String txttemp = btn.getText().toString();
        new HttpRequestTask2().execute(txttemp);
        Toast.makeText(getApplicationContext(), "Su Registro ha sido grabado, Puede verificarlo cargando la Lista Nuevamente", Toast.LENGTH_LONG).show();
    }
*/
    private class HttpRequestTask extends AsyncTask<Void, Void, Greeting[]> {


        @Override
        protected Greeting[] doInBackground(Void... params) {
            try {
                final String url = "http://restsunat.herokuapp.com/notificaciones";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Greeting[] greeting = restTemplate.getForObject(url, Greeting[].class);


                return greeting;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Greeting[] greeting) {
            ArrayList<Greeting> arrayOfUsers = new ArrayList<>();
// Create the adapter to convert the array to views
            TiendaAdapter adapter = new TiendaAdapter(getApplicationContext(), arrayOfUsers);
            // Attach the adapter to a ListView
            ListView listView = (ListView) findViewById(R.id.lvItems);
            listView.setAdapter(adapter);


            JSONArray ja = new JSONArray();


            for (int i=0;i<greeting.length;i++){
                Log.e("For",""+i);

                try {

                    JSONObject jo = new JSONObject();
                    jo.put("_id", greeting[i].get_id());
                    jo.put("nombre", greeting[i].getNombre());
                    jo.put("fecha", greeting[i].getFecha());
                    jo.put("descripcion",greeting[i].getDescripcion());
                    Log.e("verbo",greeting[i].getDescripcion());
                    //  new LoadImage().execute(greeting[i].getDescripcion());
                    ja.put(jo);



                }catch (Exception e){
                    Log.e("Error: ",e.getMessage());
                }

            }


            JSONArray jsonArray = ja;
            ArrayList<Greeting> newUsers = Greeting.fromJson(jsonArray);
            adapter.addAll(newUsers);


        }

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
