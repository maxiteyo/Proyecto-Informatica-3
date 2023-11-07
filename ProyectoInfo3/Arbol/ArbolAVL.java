package ProyectoInfo3.Arbol;
import ProyectoInfo3.ModeloDeDatos.Producto;

public class ArbolAVL<AnyType> {
    private NodoAVL<AnyType> raiz;

    /*
     *
     * Operaciones
     *
     */

    public void add(Producto producto) {
        raiz = add(producto, raiz);
    }

    private NodoAVL<AnyType> add(Producto producto, NodoAVL<AnyType> node) {
        if (node == null) {
            return new NodoAVL<>(producto);
        }
        if (((String) producto.getNombre()).compareTo((String) node.getElement().getNombre()) < 0) {
            node.setLeft(add(producto, node.getLeft()));
        } else if (((String) producto.getNombre()).compareTo((String) node.getElement().getNombre()) > 0) {
            node.setRight(add(producto, node.getRight()));
        } else {
            //node.getProducto().setStock(producto.getStock()+node.getProducto().getStock());
            return node;
        }
        updateHeight(node);
        return applyRotation(node);
    }

    public void delete(Producto producto) throws Exception {
        raiz = delete(producto, raiz);
    }

    private NodoAVL<AnyType> delete(Producto producto, NodoAVL<AnyType> node) throws Exception {
        if (node == null) {
            throw new Exception("El elemento no esta en el inventario");
        }
        if (((String) producto.getNombre()).compareTo((String) node.getElement().getNombre()) < 0) {
            node.setLeft(delete(producto, node.getLeft()));
        } else if (((String) producto.getNombre()).compareTo((String) node.getElement().getNombre()) > 0) {
            node.setRight(delete(producto, node.getRight()));
        } else {
            // One Child or Leaf Node (no children)
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }
            // Two Children
            node.setElement((Producto) getMax(node.getLeft()));// OJO, PUEDE PRESENTAR FALLAS, NO ESTABA CASTEADO
            node.setLeft(delete(node.getElement(), node.getLeft()));
        }
        updateHeight(node);
        return applyRotation(node);
    }

    private Producto getMax(NodoAVL<AnyType> node) {
        if (node.getRight() != null) {
            return getMax(node.getRight());
        }
        return node.getElement();
    }

    private Producto getMin(NodoAVL<AnyType> node) {
        if (node.getLeft() != null) {
            return getMin(node.getLeft());
        }
        return node.getElement();
    }

    public Producto buscar(AnyType x) throws Exception {
        if (x.equals(raiz.getElement().getNombre())) return raiz.getElement();
        else if (((String) x).compareTo((String) raiz.getElement().getNombre()) < 0 && raiz.getLeft() != null) return buscar(x, raiz.getLeft());
        else if (((String) x).compareTo((String) raiz.getElement().getNombre()) > 0 && raiz.getRight() != null) return buscar(x, raiz.getRight());
        else throw new Exception("El elemento no esta en el inventario");
    }

    private Producto buscar(AnyType x, NodoAVL<AnyType> node) throws Exception {
        if (x.equals(node.getElement().getNombre())) return node.getElement();
        else if (((String) x).compareTo((String) node.getElement().getNombre()) < 0 && node.getLeft() != null) return buscar(x, node.getLeft());
        else if (((String) x).compareTo((String) node.getElement().getNombre()) > 0 && node.getRight() != null) return buscar(x, node.getRight());
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

    private NodoAVL<AnyType> applyRotation(NodoAVL<AnyType> node) {
        int balance = balance(node);
        if (balance > 1) {
            if (balance(node.getLeft()) < 0) {
                node.setLeft(rotateLeft(node.getLeft()));
            }
            return rotateRight(node);
        }
        if (balance < -1) {
            if (balance(node.getRight()) > 0) {
                node.setRight(rotateRight(node.getRight()));
            }
            return rotateLeft(node);
        }
        return node;
    }

    private NodoAVL<AnyType> rotateRight(NodoAVL<AnyType> node) {
        NodoAVL<AnyType> leftNode = node.getLeft();
        NodoAVL<AnyType> centerNode = leftNode.getRight();
        leftNode.setRight(node);
        node.setLeft(centerNode);
        updateHeight(node);
        updateHeight(leftNode);
        return leftNode;
    }

    private NodoAVL<AnyType> rotateLeft(NodoAVL<AnyType> node) {
        NodoAVL<AnyType> rightNode = node.getRight();
        NodoAVL<AnyType> centerNode = rightNode.getLeft();
        rightNode.setLeft(node);
        node.setRight(centerNode);
        updateHeight(node);
        updateHeight(rightNode);
        return rightNode;
    }

    /*
     *
     * Altura y balance
     *
     */

    private void updateHeight(NodoAVL<AnyType> node) {
        int maxHeight = Math.max(
                height(node.getLeft()),
                height(node.getRight())
        );
        node.setHeight(maxHeight + 1);
    }

    private int balance(NodoAVL<AnyType> node) {
        return node != null ? height(node.getLeft()) - height(node.getRight()) : 0;
    }

    private int height(NodoAVL<AnyType> node) {
        return node != null ? node.getHeight() : 0;
    }

    /*
     *
     * Para imprimir (prints)
     *
     */

    public void printInOrder() throws Exception {
        if(isEmpty()){
            throw new Exception("El arbol esta vacio");
        }

        if (raiz.getLeft() != null) {
            printInOrder(raiz.getLeft());
        }

        System.out.print(raiz.getElement() + "\t");

        if (raiz.getRight() != null) {
            printInOrder(raiz.getRight());
        }

        System.out.println();
    }

    private void printInOrder(NodoAVL<AnyType> node) {
        if (node != null) {
            printInOrder(node.getLeft());
            System.out.print(node.getElement() + "\t");
            printInOrder(node.getRight());
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
        String pointerLeft = (raiz.getRight() != null) ? "├──" : "└──";

        traverseNodes(sb, "", pointerLeft, raiz.getLeft(), raiz.getRight() != null);
        traverseNodes(sb, "", pointerRight, raiz.getRight(), false);

        return sb.toString();
    }

    public void traverseNodes(StringBuilder sb, String padding, String pointer, NodoAVL<AnyType> node,
                              boolean hasRightSibling) {
        if (node != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getElement());

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──";
            String pointerLeft = (node.getRight() != null) ? "├──" : "└──";

            traverseNodes(sb, paddingForBoth, pointerLeft, node.getLeft(), node.getRight() != null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.getRight(), false);
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
