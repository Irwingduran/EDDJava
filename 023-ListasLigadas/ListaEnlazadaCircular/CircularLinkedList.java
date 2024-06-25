public class CircularLinkedList {

    private Node last;
    private int size;

    // Constructor
    public CircularLinkedList() {
        last = null;
        size = 0;
    }

    // Nodo interno
    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Método para agregar un nuevo nodo
    public void add(int data) {
        Node newNode = new Node(data);
        if (last == null) {
            last = newNode;
            last.next = last; // El nuevo nodo se apunta a sí mismo
        } else {
            newNode.next = last.next; // El nuevo nodo apunta al primer nodo
            last.next = newNode; // El último nodo apunta al nuevo nodo
            last = newNode; // El nuevo nodo se convierte en el último nodo
        }
        size++;
    }

    // Método para obtener el tamaño de la lista
    public int size() {
        return size;
    }
}


  

    // Eliminar nodo por valor
    public boolean remove(int data) {
        if (last == null) return false;

        Node current = last.next;
        Node previous = last;
        do {
            if (current.data == data) {
                if (current == last.next && current == last) {
                    last = null; // Solo un nodo en la lista
                } else if (current == last.next) {
                    last.next = current.next; // Remover primer nodo
                } else if (current == last) {
                    previous.next = last.next;
                    last = previous; // Remover último nodo
                } else {
                    previous.next = current.next; // Remover nodo intermedio
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        } while (current != last.next);

        return false;
    }

    // Mostrar la lista circular
    public void display() {
        if (last == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        Node current = last.next;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != last.next);
        System.out.println();
    }

    // Obtener tamaño de la lista
    public int getSize() {
        return size;
    }
/**********************************************************************************************************/
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        System.out.println("Contenido de la lista circular:");
        list.display(); // Output: 10 20 30 40 

        System.out.println("Eliminando el nodo con valor 20:");
        list.remove(20);
        list.display(); // Output: 10 30 40 

        System.out.println("Tamaño de la lista: " + list.getSize()); // Output: 3
    }
}