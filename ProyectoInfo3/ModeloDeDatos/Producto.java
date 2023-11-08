package ProyectoInfo3.ModeloDeDatos;

public class Producto {

    public Producto() {
    }

    private String nombre;
    private int stock;
    private int codigo;
    private float precio;
    private boolean esNuevo;

    

public Producto(String nombre, int stock, int codigo, float precio, boolean esNuevo) {
        this.nombre = nombre;
        this.stock = stock;
        this.codigo = codigo;
        this.precio = precio;
        this.esNuevo = esNuevo;
    }

public boolean esNuevo() {
        return esNuevo;
    }

    public void setNuevo(boolean esNuevo) {
        this.esNuevo = esNuevo;
    }


public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public int getStock() {
    return stock;
}

public void setStock(int stock) {
    this.stock = stock;
}

public int getCodigo() {
    return codigo;
}

public void setCodigo(int codigo) {
    this.codigo = codigo;
}

public float getPrecio() {
    return precio;
}

public void setPrecio(float precio) {
    this.precio = precio;
}
}
