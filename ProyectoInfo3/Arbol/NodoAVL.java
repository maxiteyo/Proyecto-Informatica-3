package ProyectoInfo3.Arbol;
import ProyectoInfo3.ModeloDeDatos.Producto;

public class NodoAVL<AnyType> {
    private Producto producto;
    private NodoAVL<AnyType> izquierda;
    private NodoAVL<AnyType> derecha;

    //Para avl
    private int altura = 0;


    public NodoAVL() {
    }

    public NodoAVL(Producto producto) {
        this.producto = producto;
        this.izquierda = null;
        this.derecha = null;
    }

    /*
     *
     * Setters & Getters
     *
     */

    public Producto getProducto() {
        return producto;
    }

    public void setElement(Producto producto) {
        this.producto = producto;
    }

    public Producto getElement(){
        return producto;
    }

    public NodoAVL<AnyType> getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoAVL<AnyType> izquierda) {
        this.izquierda = izquierda;
    }

    public NodoAVL<AnyType> getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoAVL<AnyType> derecha) {
        this.derecha = derecha;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
