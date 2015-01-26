package solodescuentos.com.app;

/**
 * Created by IIIII on 1/24/2015.
 */
public class Greeting {

    private String nombre;
    private String fecha;
    private String ubicacion;
    private String destino;
    private String _id;
    private String descripcion;

    public Greeting(String n, String f) {
        this.setNombre(n);
        this.setFecha(f);

    }
    public Greeting() {
       super();

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
}