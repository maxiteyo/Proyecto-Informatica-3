package ProyectoInfo3.Arbol;
import ProyectoInfo3.ModeloDeDatos.Producto;

public class NodoAVL<AnyType> {
    private Producto producto;
    private NodoAVL<AnyType> left;
    private NodoAVL<AnyType> right;

    //Para avl
    private int height = 0;


    public NodoAVL() {
    }

    public NodoAVL(Producto producto) {
        this.producto = producto;
        this.left = null;
        this.right = null;
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

    public NodoAVL<AnyType> getLeft() {
        return left;
    }

    public void setLeft(NodoAVL<AnyType> left) {
        this.left = left;
    }

    public NodoAVL<AnyType> getRight() {
        return right;
    }

    public void setRight(NodoAVL<AnyType> right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
