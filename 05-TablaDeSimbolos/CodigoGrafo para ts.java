import java.util.*;

public class testGrafoConsola {
    static class Grafo {
        private int numVertices;
        private ArrayList<String> vertices;
        private int[][] matrizAdyacencia;
        private boolean[] visitado;
        private ArrayList<String> recorridoDFS;
        private ArrayList<String> recorridoBFS;

        public Grafo(int numVertices) {
            this.numVertices = numVertices;
            this.vertices = new ArrayList<>();
            this.matrizAdyacencia = new int[numVertices][numVertices];
            this.visitado = new boolean[numVertices];
            this.recorridoDFS = new ArrayList<>();
            this.recorridoBFS = new ArrayList<>();
        }

        public void agregaVertice(String vertice) {
            vertices.add(vertice);
        }

        public void agregaArista(String origen, String destino) {
            int i = vertices.indexOf(origen);
            int j = vertices.indexOf(destino);
            if (i != -1 && j != -1) {
                matrizAdyacencia[i][j] = 1;
            }
        }

        public void mostrarVertices() {
            System.out.println("Vertices:");
            for (String vertice : vertices) {
                System.out.print(vertice + " ");
            }
            System.out.println();
        }

        public void mostrarMatriz() {
            System.out.println("\nMatriz de adyacencia:");
            System.out.print("  ");
            for (String vertice : vertices) {
                System.out.print(vertice + " ");
            }
            System.out.println();
            for (int i = 0; i < numVertices; i++) {
                System.out.print(vertices.get(i) + " ");
                for (int j = 0; j < numVertices; j++) {
                    System.out.print(matrizAdyacencia[i][j] + " ");
                }
                System.out.println();
            }
        }

        public void DFS(String inicio) {
            int idxInicio = vertices.indexOf(inicio);
            if (idxInicio != -1) {
                Arrays.fill(visitado, false);
                recorridoDFS.clear();
                DFSUtil(idxInicio);
            }
        }

        private void DFSUtil(int vertice) {
            visitado[vertice] = true;
            recorridoDFS.add(vertices.get(vertice));
            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia[vertice][i] == 1 && !visitado[i]) {
                    DFSUtil(i);
                }
            }
        }

        public void MostrarDFS() {
            System.out.println("\nRecorrido DFS:");
            for (String vertice : recorridoDFS) {
                System.out.print(vertice + " ");
            }
            System.out.println();
        }

        public void reinicio() {
            Arrays.fill(visitado, false);
            recorridoDFS.clear();
            recorridoBFS.clear();
        }

        public void BFS(String inicio) {
            int idxInicio = vertices.indexOf(inicio);
            if (idxInicio != -1) {
                Arrays.fill(visitado, false);
                recorridoBFS.clear();
                Queue<Integer> queue = new LinkedList<>();
                queue.add(idxInicio);
                visitado[idxInicio] = true;
                while (!queue.isEmpty()) {
                    int vertice = queue.poll();
                    recorridoBFS.add(vertices.get(vertice));
                    for (int i = 0; i < numVertices; i++) {
                        if (matrizAdyacencia[vertice][i] == 1 && !visitado[i]) {
                            queue.add(i);
                            visitado[i] = true;
                        }
                    }
                }
            }
        }

        public void MostrarBFS() {
            System.out.println("\nRecorrido BFS:");
            for (String vertice : recorridoBFS) {
                System.out.print(vertice + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Grafo v = new Grafo(10);
        v.agregaVertice("a");
        v.agregaVertice("b");
        v.agregaVertice("c");
        v.agregaVertice("d");
        v.agregaVertice("e");
        v.agregaVertice("f");
        v.agregaVertice("g");
        v.agregaVertice("h");
        v.agregaVertice("i");
        v.agregaVertice("j");
        v.mostrarVertices();

        v.agregaArista("a", "c");
        v.agregaArista("a", "g");
        v.agregaArista("a", "h");

        v.agregaArista("b", "a");
        v.agregaArista("b", "d");

        v.agregaArista("c", "b");
        v.agregaArista("c", "e");

        v.agregaArista("d", "e");

        v.agregaArista("f", "d");
        v.agregaArista("f", "g");

        v.agregaArista("g", "d");

        v.agregaArista("h", "f");
        v.agregaArista("h", "i");

        v.agregaArista("i", "f");
        v.agregaArista("i", "j");

        v.agregaArista("j", "f");
        v.agregaArista("j", "g");

        v.mostrarMatriz();

        v.DFS("a");
        v.MostrarDFS();
        v.reinicio();
        v.BFS("a");
        v.MostrarBFS();
    }
}