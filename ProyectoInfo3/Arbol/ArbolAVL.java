package ProyectoInfo3.Arbol;
import ProyectoInfo3.ModeloDeDatos.Producto;

public class ArbolAVL<AnyType> {
    private NodoAVL<AnyType> raiz;

    /*
     *
     * Operaciones
     *
     */

    public void agregar(Producto producto) {
        raiz = agregar(producto, raiz);
    }

    private NodoAVL<AnyType> agregar(Producto producto, NodoAVL<AnyType> nodo) {
        if (nodo == null) {
            return new NodoAVL<>(producto);
        }
        if (((String) producto.getNombre()).compareTo((String) nodo.getElement().getNombre()) < 0) {
            nodo.setIzquierda(agregar(producto, nodo.getIzquierda()));
        } else if (((String) producto.getNombre()).compareTo((String) nodo.getElement().getNombre()) > 0) {
            nodo.setDerecha(agregar(producto, nodo.getDerecha()));
        } else {
            //nodo.getProducto().setStock(producto.getStock()+nodo.getProducto().getStock());
            return nodo;
        }
        actualizarAltura(nodo);
        return aplicarRotacion(nodo);
    }

    public void borrar(Producto producto) throws Exception {
        raiz = borrar(producto, raiz);
    }

    private NodoAVL<AnyType> borrar(Producto producto, NodoAVL<AnyType> nodo) throws Exception {
        if (nodo == null) {
            throw new Exception("El elemento no esta en el inventario");
        }
        if (((String) producto.getNombre()).compareTo((String) nodo.getElement().getNombre()) < 0) {
            nodo.setIzquierda(borrar(producto, nodo.getIzquierda()));
        } else if (((String) producto.getNombre()).compareTo((String) nodo.getElement().getNombre()) > 0) {
            nodo.setDerecha(borrar(producto, nodo.getDerecha()));
        } else {
            // One Child or Leaf Node (no children)
            if (nodo.getIzquierda() == null) {
                return nodo.getDerecha();
            } else if (nodo.getDerecha() == null) {
                return nodo.getIzquierda();
            }
            // Two Children
            nodo.setElement((Producto) getMax(nodo.getIzquierda()));// OJO, PUEDE PRESENTAR FALLAS, NO ESTABA CASTEADO
            nodo.setIzquierda(borrar(nodo.getElement(), nodo.getIzquierda()));
        }
        actualizarAltura(nodo);
        return aplicarRotacion(nodo);
    }

    private Producto getMax(NodoAVL<AnyType> nodo) {
        if (nodo.getDerecha() != null) {
            return getMax(nodo.getDerecha());
        }
        return nodo.getElement();
    }

    private Producto getMin(NodoAVL<AnyType> nodo) {
        if (nodo.getIzquierda() != null) {
            return getMin(nodo.getIzquierda());
        }
        return nodo.getElement();
    }

    public Producto buscar(AnyType x) throws Exception {
        if (x.equals(raiz.getElement().getNombre())) return raiz.getElement();
        else if (((String) x).compareTo((String) raiz.getElement().getNombre()) < 0 && raiz.getIzquierda() != null) return buscar(x, raiz.getIzquierda());
        else if (((String) x).compareTo((String) raiz.getElement().getNombre()) > 0 && raiz.getDerecha() != null) return buscar(x, raiz.getDerecha());
        else throw new Exception("El elemento no esta en el inventario");
    }

    private Producto buscar(AnyType x, NodoAVL<AnyType> nodo) throws Exception {
        if (x.equals(nodo.getElement().getNombre())) return nodo.getElement();
        else if (((String) x).compareTo((String) nodo.getElement().getNombre()) < 0 && nodo.getIzquierda() != null) return buscar(x, nodo.getIzquierda());
        else if (((String) x).compareTo((String) nodo.getElement().getNombre()) > 0 && nodo.getDerecha() != null) return buscar(x, nodo.getDerecha());
        else throw new Exception("El elemento no esta en el inventario");
    }


    /*
     *
     * Estados
     *
     */
    public boolean isEmpty() {
        return raiz == null;
    }

    /*
     *
     * Rotaciones
     *
     */

    private NodoAVL<AnyType> aplicarRotacion(NodoAVL<AnyType> nodo) {
        int balance = balance(nodo);
        if (balance > 1) {
            if (balance(nodo.getIzquierda()) < 0) {
                nodo.setIzquierda(rotacionIzquierda(nodo.getIzquierda()));
            }
            return rotacionDerecha(nodo);
        }
        if (balance < -1) {
            if (balance(nodo.getDerecha()) > 0) {
                nodo.setDerecha(rotacionDerecha(nodo.getDerecha()));
            }
            return rotacionIzquierda(nodo);
        }
        return nodo;
    }

    private NodoAVL<AnyType> rotacionDerecha(NodoAVL<AnyType> nodo) {
        NodoAVL<AnyType> nodoIzquierdo = nodo.getIzquierda();
        NodoAVL<AnyType> nodoCentral = nodoIzquierdo.getDerecha();
        nodoIzquierdo.setDerecha(nodo);
        nodo.setIzquierda(nodoCentral);
        actualizarAltura(nodo);
        actualizarAltura(nodoIzquierdo);
        return nodoIzquierdo;
    }

    private NodoAVL<AnyType> rotacionIzquierda(NodoAVL<AnyType> nodo) {
        NodoAVL<AnyType> nodoDerecho = nodo.getDerecha();
        NodoAVL<AnyType> nodoCentral = nodoDerecho.getIzquierda();
        nodoDerecho.setIzquierda(nodo);
        nodo.setDerecha(nodoCentral);
        actualizarAltura(nodo);
        actualizarAltura(nodoDerecho);
        return nodoDerecho;
    }

    /*
     *
     * Altura y balance
     *
     */

    private void actualizarAltura(NodoAVL<AnyType> nodo) {
        int maxAltura = Math.max(
                altura(nodo.getIzquierda()),
                altura(nodo.getDerecha())
        );
        nodo.setAltura(maxAltura + 1);
    }

    private int balance(NodoAVL<AnyType> nodo) {
        return nodo != null ? altura(nodo.getIzquierda()) - altura(nodo.getDerecha()) : 0;
    }

    private int altura(NodoAVL<AnyType> nodo) {
        return nodo != null ? nodo.getAltura() : 0;
    }

    /*
     *
     * Para imprimir (prints)
     *
     */

    public void imprimirOrden() throws Exception {
        if(isEmpty()){
            throw new Exception("El arbol esta vacio");
        }

        if (raiz.getIzquierda() != null) {
            imprimirOrden(raiz.getIzquierda());
        }

        System.out.print(raiz.getElement() + "\t");

        if (raiz.getDerecha() != null) {
            imprimirOrden(raiz.getDerecha());
        }

        System.out.println();
    }

    private void imprimirOrden(NodoAVL<AnyType> nodo) {
        if (nodo != null) {
            imprimirOrden(nodo.getIzquierda());
            System.out.print(nodo.getElement() + "\t");
            imprimirOrden(nodo.getDerecha());
        }
    }

    /*public void printLikeTree(PrintStream os) {
        os.print(traversePreOrder(raiz));
        System.out.println();
    }*/

    public String traversePreOrder(NodoAVL<AnyType> raiz) {

        if (raiz == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(raiz.getElement());

        String pointerRight = "└──";
        String pointerLeft = (raiz.getDerecha() != null) ? "├──" : "└──";

        traverseNodes(sb, "", pointerLeft, raiz.getIzquierda(), raiz.getDerecha() != null);
        traverseNodes(sb, "", pointerRight, raiz.getDerecha(), false);

        return sb.toString();
    }

    public void traverseNodes(StringBuilder sb, String padding, String punto, NodoAVL<AnyType> nodo,
                              boolean hasRightSibling) {
        if (nodo != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(punto);
            sb.append(nodo.getElement());

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──";
            String pointerLeft = (nodo.getDerecha() != null) ? "├──" : "└──";

            traverseNodes(sb, paddingForBoth, pointerLeft, nodo.getIzquierda(), nodo.getDerecha() != null);
            traverseNodes(sb, paddingForBoth, pointerRight, nodo.getDerecha(), false);
        }
    }

    /* Sin usar

      public void makeEmpty() {
      raiz = null;
    }

    public AnyType getMax() {
        if (isEmpty()) {
            return null;
        }
        return getMax(raiz);
    }

    public AnyType getMin() {
        if (isEmpty()) {
            return null;
        }
        return getMin(raiz);
    }
    */
}
