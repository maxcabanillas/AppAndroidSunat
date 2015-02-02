package solodescuentos.com.app;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by IIIII on 1/24/2015.
 */
public class Greeting {

    private String nombre;
    private String fecha;
    private String ubicacion;
    private String destino;
    private String _id;
    private String __v;
    private String descripcion;

    public Greeting(String n, String f) {
        this.setNombre(n);
        this.setFecha(f);

    }

    public Greeting() {
        super();
    }





    public static ArrayList<Greeting> fromJson(JSONArray jsonObjects) {
        ArrayList<Greeting> users = new ArrayList<Greeting>();
        for (int i = 0; i < jsonObjects.length(); i++) {
            try {
                users.add(new Greeting(jsonObjects.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    public Greeting(JSONObject object) {
        try {
            this._id = object.getString("_id");
            this.nombre = object.getString("nombre");
            this.fecha = object.getString("fecha");
            this.descripcion = object.getString("descripcion");
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String get__v() {
        return __v;
    }

    public void set__v(String __v) {
        this.__v = __v;
    }
}