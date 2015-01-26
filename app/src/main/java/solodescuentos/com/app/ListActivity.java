package solodescuentos.com.app;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;


public class ListActivity extends ActionBarActivity {
    String[] items;
    ImageView img;
    Bitmap bitmap;
    ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        /*
        items = new String[] { "Vegetables","Fruits","Flower Buds","Legumes","Bulbs","Tubers","Fruits","Flower Buds","Legumes","Bulbs","Tubers","Fruits","Flower Buds","Legumes","Bulbs","Tubers","Fruits","Flower Buds","Legumes","Bulbs","Tubers","Fruits","Flower Buds","Legumes","Bulbs","Tubers" };

       ArrayAdapter<String> itemsAdapter =
       new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

        ListView listView = (ListView) findViewById(R.id.lvItems);
        listView.setAdapter(itemsAdapter);
//http://www.learn2crack.com/2014/06/android-load-image-from-internet.html
*/      img = (ImageView)findViewById(R.id.img);
        new LoadImage().execute("http://www.adslzone.net/app/uploads/2014/08/apertura-selfie-mono.jpg");
        ArrayList<Greeting> arrayOfUsers = new ArrayList<>();
// Create the adapter to convert the array to views
        TiendaAdapter adapter = new TiendaAdapter(this, arrayOfUsers);
// Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.lvItems);
        listView.setAdapter(adapter);

        Greeting newUser = new Greeting("Moro", "Mora");
        adapter.add(newUser);
        Greeting newUser2 = new Greeting("Jes", "Lamora");
        adapter.add(newUser2);
        Greeting newUser3 = new Greeting("Manuel", "Zavaleta");
        adapter.add(newUser3);
        Greeting newUser4 = new Greeting("Dota2", "Lo max");
        adapter.add(newUser4);
        Greeting newUser5 = new Greeting("Sunat", "Aburre");
        adapter.add(newUser5);
        Greeting newUser6 = new Greeting("xD", "-.-");
        adapter.add(newUser6);

    }
    //adapter

    public class LoadImage extends AsyncTask<String, String, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(ListActivity.this);
            pDialog.setMessage("Loading Image ....");
            pDialog.show();
        }
        protected Bitmap doInBackground(String... args) {

            try {
                bitmap = BitmapFactory.decodeStream((InputStream)new URL(args[0]).getContent());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }
        protected void onPostExecute(Bitmap image) {
            if(image != null){
                img.setImageBitmap(image);
                pDialog.dismiss();
            }else{
                pDialog.dismiss();
                Toast.makeText(ListActivity.this, "Image Does Not exist or Network Error", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //adapter /

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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
