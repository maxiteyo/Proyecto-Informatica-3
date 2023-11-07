package ProyectoInfo3.Lista;

import java.util.Scanner;
import ProyectoInfo3.ModeloDeDatos.Producto;

public class Lista<AnyType> {
    public Nodo<AnyType> root = null;

  /**
   * Agregar el elemento a la pila
   * 
   * @param element
   */
  /*public void push(Producto producto) {
    Nodo<AnyType> newNodo = new Nodo<AnyType>(producto);
    Nodo<AnyType> temp = new Nodo<AnyType>(null);
    if(root==null){
        newNodo.next = root;
        root = newNodo;
    }else{
      temp=root;
      while ((producto.nombre).compareTo(temp.producto.nombre) < 0 && temp != null) {
      temp=temp.next;
    }

    newNodo.next=temp.next;
    temp.next=newNodo;

    }
  }*/

  public void push(Producto producto) {
    Nodo<AnyType> newNodo = new Nodo<AnyType>(producto);
  
    if(producto.isNew()){
      if (root == null || (producto.getNombre()).compareTo(root.producto.getNombre()) <= 0) {
        newNodo.next = root;
        root = newNodo;
    } else {
        Nodo<AnyType> temp = root;
        while (temp.next != null && (producto.getNombre()).compareTo(temp.next.producto.getNombre()) > 0) {
            temp = temp.next;
        }

        newNodo.next = temp.next;
        temp.next = newNodo;
    }
    }

}

public Producto buscar(Producto producto){

  Nodo<AnyType> temp = root;

  while(temp != null){
    if(temp.producto.getNombre().equalsIgnoreCase(producto.getNombre())){
      return temp.producto;
    }
    temp=temp.next;
  }
  return null;
    

  }

  /**
   * Borramos y retornamos el ùiltimo valor.
   * 
   * @return
   */
  public void borrar(String nombre) {
    
    Nodo<AnyType> temp = root;
    if(root.producto.getNombre().equalsIgnoreCase(nombre)){
      root=root.next;
    }else{
      while(temp!= null && temp.next != null) {
      if(temp.next.producto.getNombre().equalsIgnoreCase(nombre)){
        temp.next=temp.next.next;
      }
      temp=temp.next;
    }
    }

  }

  /**
   * Retornamos el últimos valor.
   * 
   * @return
   */
  public Producto top() {
    return root.producto;
  }

  public void mostrar(){
    Nodo<AnyType> temp = root;

    System.out.println("|*******INVENTARIO*******|");
    while (temp != null){
      System.out.println();
      System.out.println("Nombre: "+ temp.producto.getNombre());
      System.out.println("Codigo: "+ temp.producto.getCodigo());
      System.out.println("Precio: $"+ temp.producto.getPrecio());
      System.out.println("Stock: "+ temp.producto.getStock());
      temp=temp.next;
    }
    System.out.println("\n**********************");
  }

  public boolean isEmpty() {
    return this.root == null ? true : false;
  }

  public void makeEmpty() {
    this.root = null;
  }

  public int size() {
    int count = 0;
    Nodo<AnyType> actual = this.root;
    while (actual != null) {
      count++;
      actual = actual.next;
    }
    return count;
  }
}
