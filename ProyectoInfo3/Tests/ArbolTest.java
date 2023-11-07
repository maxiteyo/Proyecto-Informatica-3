package ProyectoInfo3.Tests;

import ProyectoInfo3.Arbol.ArbolAVL;
import ProyectoInfo3.ModeloDeDatos.Producto;
import java.util.Scanner;

public class ArbolTest {
    
    public void agregarArbol(ArbolAVL arbol,Producto producto){
    
    arbol.add(producto);
    }

    public void borrar(ArbolAVL arbol,String nombre){

      try {
        arbol.delete(arbol.buscar(nombre));
      } catch (Exception e) {
          e.printStackTrace();
          return;
      }
    }

    public void buscar(ArbolAVL arbol){

    Scanner consola= new Scanner(System.in);
    Producto producto= new Producto();
    String nombre;

    System.out.print("Ingrese el nombre del producto a buscar: ");
    nombre=consola.nextLine();
    try {
    producto=arbol.buscar(nombre);        
    } catch (Exception e) {
        e.printStackTrace();
        return;
    }
    System.out.println("*******Producto*******");//hacer bonito la impresion del producto encontrado
    System.out.println("Nombre: "+ producto.getNombre());
    System.out.println("Codigo: "+ producto.getCodigo());
    System.out.println("Precio: $"+ producto.getPrecio());
    System.out.println("Stock: "+producto.getStock());
    System.out.println("**********************");
    }

}
