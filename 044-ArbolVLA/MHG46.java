
package mhg46;


public class MHG46 {

    public static void main(String[] args) {
       
       ArbolAVL arbolitoAVL = new ArbolAVL() ;
       
       //Insertardo Nodos aqui
   
       arbolitoAVL.Insertar(10);
       arbolitoAVL.Insertar(5);
       arbolitoAVL.Insertar(15);
       
      //RECORRIDO PRE ORDEN PARA REVISION
       
       arbolitoAVL.PreOrden(arbolitoAVL.ObtenerRaiz());
       
       
       
       
    }
}
