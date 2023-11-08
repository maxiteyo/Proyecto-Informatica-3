package ProyectoInfo3.Lista;

import ProyectoInfo3.ModeloDeDatos.Producto;

public class Nodo<AnyType> {

  public Producto producto;
  public Nodo<AnyType> siguiente;

  public Nodo(Producto producto) {
    this.producto = producto;
    this.siguiente = null;
  }

}
