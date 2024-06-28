public class BTree {
    private static final int T = 3; // Grado mínimo

    // Clase interna Node
    class Node {
        int n; // Número de claves en el nodo
        int[] key; // Claves en el nodo
        Node[] child; // Punteros a hijos
        boolean leaf; // Verdadero si el nodo es hoja

        // Constructor del nodo
        public Node() {
            this.key = new int[2 * T - 1];
            this.child = new Node[2 * T];
            this.leaf = true;
            this.n = 0;
        }

        // Encuentra la clave en el nodo
        public int findKey(int k) {
            int idx = 0;
            while (idx < n && key[idx] < k)
                ++idx;
            return idx;
        }
    }

    private Node root = new Node();

    // Buscar una clave en el árbol B
    public Node search(Node x, int key) {
        int i = 0;
        while (i < x.n && key > x.key[i])
            i++;
        if (i < x.n && key == x.key[i])
            return x;
        if (x.leaf)
            return null;
        else
            return search(x.child[i], key);
    }

    // Dividir un hijo y crear un nuevo nodo
    private void split(Node x, int pos, Node y) {
        Node z = new Node();
        z.leaf = y.leaf;
        z.n = T - 1;
        for (int j = 0; j < T - 1; j++) {
            z.key[j] = y.key[j + T];
        }
        if (!y.leaf) {
            for (int j = 0; j < T; j++) {
                z.child[j] = y.child[j + T];
            }
        }
        y.n = T - 1;
        for (int j = x.n; j >= pos + 1; j--) {
            x.child[j + 1] = x.child[j];
        }
        x.child[pos + 1] = z;
        for (int j = x.n - 1; j >= pos; j--) {
            x.key[j + 1] = x.key[j];
        }
        x.key[pos] = y.key[T - 1];
        x.n++;
    }

    // Insertar una clave en el árbol B
    public void insert(final int key) {
        Node r = root;
        if (r.n == 2 * T - 1) {
            Node s = new Node();
            root = s;
            s.leaf = false;
            s.n = 0;
            s.child[0] = r;
            split(s, 0, r);
            insertNonFull(s, key);
        } else {
            insertNonFull(r, key);
        }
    }

    // Insertar una clave en un nodo que no está lleno
    private void insertNonFull(Node x, int key) {
        int i = x.n - 1;
        if (x.leaf) {
            while (i >= 0 && key < x.key[i]) {
                x.key[i + 1] = x.key[i];
                i--;
            }
            x.key[i + 1] = key;
            x.n++;
        } else {
            while (i >= 0 && key < x.key[i]) {
                i--;
            }
            i++;
            if (x.child[i].n == 2 * T - 1) {
                split(x, i, x.child[i]);
                if (key > x.key[i]) {
                    i++;
                }
            }
            insertNonFull(x.child[i], key);
        }
    }

    // Imprimir el árbol B
    public void print() {
        print(root, "");
    }

    private void print(Node x, String indent) {
        if (x != null) {
            System.out.print(indent);
            for (int i = 0; i < x.n; i++) {
                System.out.print(x.key[i] + " ");
            }
            System.out.println();
            if (!x.leaf) {
                for (int i = 0; i <= x.n; i++) {
                    print(x.child[i], indent + "    ");
                }
            }
        }
    }

    public static void main(String[] args) {
        BTree b = new BTree();
        int[] keys = {10, 20, 5, 6, 12, 30, 7, 17};
        for (int key : keys) {
            b.insert(key);
        }
        b.print();
    }
}