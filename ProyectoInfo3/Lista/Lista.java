package ProyectoInfo3.Lista;

import java.util.Scanner;
import ProyectoInfo3.ModeloDeDatos.Producto;

public class Lista<AnyType> {
    public Nodo<AnyType> raiz = null;

  /**
   * Agregar el elemento a la lista
   * 
   * @param element
   */
  public void empujar(Producto producto) {
    Nodo<AnyType> newNodo = new Nodo<AnyType>(producto);
  
    if(producto.esNuevo()){
      if (raiz == null || (producto.getNombre()).compareTo(raiz.producto.getNombre()) <= 0) {
        newNodo.siguiente = raiz;
        raiz = newNodo;
    } else {
        Nodo<AnyType> temp = raiz;
        while (temp.siguiente != null && (producto.getNombre()).compareTo(temp.siguiente.producto.getNombre()) > 0) {
            temp = temp.siguiente;
        }

        newNodo.siguiente = temp.siguiente;
        temp.siguiente = newNodo;
    }
    }

}

public Producto buscar(Producto producto){

  Nodo<AnyType> temp = raiz;

  while(temp != null){
    if(temp.producto.getNombre().equalsIgnoreCase(producto.getNombre())){
      return temp.producto;
    }
    temp=temp.siguiente;
  }
  return null;
    

  }

  /**
   * Borramos
   * 
   * @return
   */
  public void borrar(String nombre) {
    
    Nodo<AnyType> temp = raiz;
    if(raiz.producto.getNombre().equalsIgnoreCase(nombre)){
      raiz=raiz.siguiente;
    }else{
      while(temp!= null && temp.siguiente != null) {
      if(temp.siguiente.producto.getNombre().equalsIgnoreCase(nombre)){
        temp.siguiente=temp.siguiente.siguiente;
      }
      temp=temp.siguiente;
    }
    }

  }

  /**
   * Retornamos el últimos valor.
   * 
   * @return
   */
  public Producto arriba() {
    return raiz.producto;
  }

  public void mostrar(){
    Nodo<AnyType> temp = raiz;

    System.out.println("\n|*******INVENTARIO*******|");
    while (temp != null){
      System.out.println();
      System.out.println("Nombre: "+ temp.producto.getNombre());
      System.out.println("Codigo: "+ temp.producto.getCodigo());
      System.out.println("Precio: $"+ temp.producto.getPrecio());
      System.out.println("Stock: "+ temp.producto.getStock());
      temp=temp.siguiente;
    }
    System.out.println("\n**********************\n");
  }

  public boolean isEmpty() {
    return this.raiz == null ? true : false;
  }

  public void makeEmpty() {
    this.raiz = null;
  }

  public int tamanio() {
    int count = 0;
    Nodo<AnyType> actual = this.raiz;
    while (actual != null) {
      count++;
      actual = actual.siguiente;
    }
    return count;
  }
}
