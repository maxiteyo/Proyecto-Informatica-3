package ProyectoInfo3.Tests;

import ProyectoInfo3.ModeloDeDatos.Producto;
import ProyectoInfo3.Lista.Lista;
import ProyectoInfo3.Lista.Nodo;
import java.util.Scanner;

public class StackListTest<AnyType> {
    
    public void agregarLista(Lista list,Producto producto){
        list.empujar(producto);
    }

    public void mostrarInv(Lista lista){
        lista.mostrar();
    }

    public Producto buscarLista(Lista lista,Producto producto){
        return lista.buscar(producto);
    }

    public void borrarLista(Lista lista,String nombre){
        lista.borrar(nombre);
    }

}
