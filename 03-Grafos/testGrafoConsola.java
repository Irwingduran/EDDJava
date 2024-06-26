package grafos;

public class testGrafoConsola {
        public static void main(String []args){

        Grafo g = new Grafo(13);
        g.agregaVertice("1");
        g.agregaVertice("2");
        g.agregaVertice("3");
        g.agregaVertice("4");
        g.agregaVertice("5");
        g.agregaVertice("6");
        g.agregaVertice("7");
        g.agregaVertice("8");
        g.agregaVertice("9");
        g.agregaVertice("10");
        g.agregaVertice("11");
        g.agregaVertice("12");
        g.agregaVertice("13");
        g.mostrarVertices();
        
        g.agregaArista("1", "2");
        g.agregaArista("1", "3");
        g.agregaArista("1", "4");
        
        g.agregaArista("2", "1");
        g.agregaArista("2", "4");
        g.agregaArista("2", "5");
        
        g.agregaArista("3", "1");
        g.agregaArista("3", "4");
        g.agregaArista("3", "6");
        g.agregaArista("3", "7");
        
        g.agregaArista("4", "1");
        g.agregaArista("4", "2");
        g.agregaArista("4", "3");
        g.agregaArista("4", "6");
        g.agregaArista("4", "8");
        
        g.agregaArista("5", "2");
        g.agregaArista("5", "8");
        g.agregaArista("5", "9");
        
        g.agregaArista("6", "3");
        g.agregaArista("6", "4");
        g.agregaArista("6", "10");
        
        g.agregaArista("7", "3");
        g.agregaArista("7", "4");
        g.agregaArista("7", "10");
        
        g.agregaArista("8", "4");
        g.agregaArista("8", "5");
        g.agregaArista("8", "11");
        
        g.agregaArista("9", "5");
        g.agregaArista("9", "11");
        g.agregaArista("9", "12");
        
        g.agregaArista("10", "6");
        g.agregaArista("10", "7");
        g.agregaArista("10", "11");
        g.agregaArista("10", "13");
        
        g.agregaArista("11", "8");
        g.agregaArista("11", "9");
        g.agregaArista("11", "10");
        g.agregaArista("11", "13");
        
        g.agregaArista("12", "9");
        g.agregaArista("12", "13");
        
        g.agregaArista("13", "10");
        g.agregaArista("13", "11");
        g.agregaArista("13", "12");        
        
        g.mostrarMatriz();
        g.DFS("1");
        g.MostrarDFS();
        g.reinicio();
        g.BFS("1");
        g.MostrarBFS();     
    }
              
}