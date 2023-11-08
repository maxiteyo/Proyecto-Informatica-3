package ProyectoInfo3;

import java.util.Scanner;

import ProyectoInfo3.Lista.Lista;
import ProyectoInfo3.ModeloDeDatos.Producto;
import ProyectoInfo3.Tests.StackListTest;
import ProyectoInfo3.Arbol.ArbolAVL;
import ProyectoInfo3.Tests.ArbolTest;

public class Main {
    public static void main(String[] args) {
        
        int opcion=0,contador=0;
        Scanner consola= new Scanner(System.in);
        ArbolAVL arbol= new ArbolAVL();
        ArbolTest arbolTest= new ArbolTest();
        Lista lista= new Lista();
        StackListTest listaTest= new StackListTest();
        //listaTest.agregarLista(lista, new Producto("papa",20,1,300,true));
        //listaTest.agregarLista(lista, new Producto("cebolla",30,2,150,true));


    do {
            
        System.out.println("************MENU************");
        System.out.println("*  1- Agregar producto     *");
        System.out.println("*  2- Borrar producto      *");
        System.out.println("*  3- Buscar producto      *");
        System.out.println("*  4- Mostrar inventario   *");
        System.out.println("*  5- Salir                *");
        System.out.println("****************************");
        System.out.print("OPCION: ");
        opcion=consola.nextInt();

        switch(opcion){
            case 1:
            Scanner consola2= new Scanner(System.in);
            Producto producto = new Producto();
            producto.setCodigo(contador);
            System.out.print("Ingrese nombre del producto a agregar: ");
            producto.setNombre(consola2.nextLine());
            System.out.print("Ingrese stock del producto: ");
            producto.setStock(consola2.nextInt());
            Producto buscado= listaTest.buscarLista(lista, producto);
            if(buscado==null){
                System.out.print("Ingrese precio del producto: ");
                producto.setPrecio(consola2.nextFloat());
                producto.setNuevo(true);
            }else{
                producto.setNuevo(false);
                buscado.setStock(buscado.getStock()+producto.getStock());//no seria producto.setStock?
                System.out.println("Producto encontrado, se actualizo el stock.");
            }
            
            arbolTest.agregarArbol(arbol,producto);
            listaTest.agregarLista(lista,producto);
            contador++;
            break;

            case 2:
            Scanner consola3= new Scanner(System.in);
            String nombre;
      
            System.out.println("Ingrese el nombre del producto a borrar:");
            nombre=consola3.nextLine();
            arbolTest.borrar(arbol,nombre);
            listaTest.borrarLista(lista, nombre);
            break;

            case 3:
            arbolTest.buscar(arbol);
            break;

            case 4:
            listaTest.mostrarInv(lista);
            break;

            case 5:
            break;

            default:
            System.out.println("La opcion ingresada es incorrecta, porfavor ingrese una nueva");
            break;
        }
    } while (opcion != 5);
}
}
