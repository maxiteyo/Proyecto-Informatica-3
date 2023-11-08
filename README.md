# Proyecto-Informatica-3

El programa tiene la funcion de registrar los productos de un local. Es util para llevar la cuenta del stock que tiene cada producto y mantener ordenado el inventario del negocio.

Para inicializar el programa, se debe hacer desde el archivo llamado "Main.java". En Visual Studio Code, es necesario tener las extensiones ("Extension Pack for Java") de Java para poder correr el programa correctamente.

En el programa se va a presentar un menu de opciones, en el cual se va a poder seleccionar: 1- Agregar un producto, 2- Borrar un producto, 3- Buscar un producto y 4- Mostrar inventario. Para salir del programa se debe presionar el numero 5. Cuando se intente agregar un producto repetido, unicamente se va a solicitar la cantidad a agregar, ya que el programa va a sumarle al stock ya guardado el nuevo ingreso de ese producto. Si se intenta borrar o buscar un producto el cual no existe en el inventario, el programa va a lanzar un mensaje de error. Cuando se solicite mostrar el inventario, el programa va a hacerlo ordenando los productos alfabeticamente. A la hora de elegir una opcion del menu, procurar no ingresar otros caracteres que no sean numeros (como letras o simbolos).

En si, el programa esta construido con una lista y un arbol AVL. En la lista, los productos se van ingresando de manera ordenada alfabeticamente, y esto es usado a la hora de mostrar el inventario. El arbol AVL es principalmente utilizado a la hora de buscar un producto en el inventario, ya que nos proporciona tiempos magnificamente rapidos y eficientes. Ya sea cuando se agregue o borre un producto, estas dos acciones se realizan simultaneamente tanto para el arbol AVL como para la lista.
