
package mhg46;


public class ArbolAVL {
    private NodoArbol raiz;
    
   //constructor para inicializar la raiz en nulo
    public ArbolAVL(){
        raiz = null;
    }
    
    public NodoArbol ObtenerRaiz(){
        return raiz;
    }
    
    //Buscar
    public NodoArbol buscar(int d, NodoArbol r){
    if(raiz == null){
        return null; 
    }
    else if(r.dato == d){
        return r;
    }
    else if(r.dato<d){
        return buscar(d, r.HijoDerecho);
    } else{
        return buscar(d, r.HijoIzquierdo);
    }
    }
    
    //obtener factor de equilibrio
    public int ObtenerFE(NodoArbol x){
        if(x==null){
            return -1;
        }else{
            return x.FE; 
        }
    }
    
    //ROTACION SIMPLE IZQUIERDA
    public NodoArbol RotacionIzquierda(NodoArbol c){
        NodoArbol auxiliar = c.HijoIzquierdo;
        c.HijoIzquierdo = auxiliar.HijoDerecho;
        auxiliar.HijoDerecho = c;
        c.FE = Math.max(ObtenerFE(c.HijoIzquierdo), ObtenerFE(c.HijoDerecho))+1;
        auxiliar.FE = Math.max(ObtenerFE(auxiliar.HijoIzquierdo), ObtenerFE(auxiliar.HijoDerecho))+1;
    return auxiliar;
    }
    
    //ROTACION SIMPLE DERECHA
     public NodoArbol RotacionDerecha(NodoArbol c){
        NodoArbol auxiliar = c.HijoDerecho;
        c.HijoDerecho = auxiliar.HijoIzquierdo;
        auxiliar.HijoIzquierdo = c;
        c.FE = Math.max(ObtenerFE(c.HijoIzquierdo), ObtenerFE(c.HijoDerecho))+1;
        auxiliar.FE = Math.max(ObtenerFE(auxiliar.HijoIzquierdo), ObtenerFE(auxiliar.HijoDerecho))+1;
    return auxiliar;
    }
    
     //ROTACION DOBLE A LA IZQUIERDA
     public NodoArbol RotacionDobleIzquierda(NodoArbol c){
         NodoArbol temporal;
         c.HijoIzquierdo = RotacionDerecha(c.HijoIzquierdo);
         temporal = RotacionIzquierda(c);
         return temporal;
     }
 
    //ROTACION DOBLE A LA DERECHA
     public NodoArbol RotacionDobleDerecha(NodoArbol c){
         NodoArbol temporal;
        c.HijoDerecho = RotacionIzquierda(c.HijoDerecho);
        temporal = RotacionDerecha(c);
         return temporal;
     }
     
  //INSERTAR AVL
     public NodoArbol InsertarAVL(NodoArbol nuevo, NodoArbol subarbol){
         NodoArbol nuevoPadre = subarbol;
         if(nuevo.dato < subarbol.dato){
             if(subarbol.HijoIzquierdo == null){
                 subarbol.HijoIzquierdo = nuevo;
             }else{
                 subarbol.HijoIzquierdo = InsertarAVL(nuevo, subarbol.HijoIzquierdo);
                  
                 if((ObtenerFE(subarbol.HijoIzquierdo))- ObtenerFE(subarbol.HijoDerecho) == 2){
             if(nuevo.dato < subarbol.HijoIzquierdo.dato){
                 nuevoPadre = RotacionIzquierda(subarbol);
             }else {
                 nuevoPadre = RotacionDobleIzquierda(subarbol);
             }
           }
         }
       }else if(nuevo.dato > subarbol.dato){
           if(subarbol.HijoDerecho == null){
               subarbol.HijoDerecho = nuevo;
           }else {
               subarbol.HijoDerecho = InsertarAVL(nuevo, subarbol.HijoDerecho);
               if((ObtenerFE(subarbol.HijoDerecho)-ObtenerFE(subarbol.HijoIzquierdo)==2)){
                   if(nuevo.dato > subarbol.HijoDerecho.dato){
                       nuevoPadre = RotacionDerecha(subarbol);
                   }else{
                       nuevoPadre = RotacionDobleDerecha(subarbol);
                   }
               }
           }
       }else{
             System.out.println("Nodo Duplicado");
       }     
     // ACTUALIZANDO FACTOR DE EQUILIBRIO
     if ((subarbol.HijoIzquierdo == null) && (subarbol.HijoDerecho != null)){
          subarbol.FE = subarbol.HijoDerecho.FE+1;
     }else if((subarbol.HijoDerecho == null) && (subarbol.HijoIzquierdo != null)){
         subarbol.FE = subarbol.HijoIzquierdo.FE+1;
     }else{
         subarbol.FE = Math.max(ObtenerFE(subarbol.HijoIzquierdo), ObtenerFE(subarbol.HijoDerecho))+1;
     }
     return nuevoPadre;
     }
 
     //METODO PARA INSERTAR
     public void Insertar(int d){
         NodoArbol nuevo = new NodoArbol(d);
         if ( raiz == null){
             raiz = nuevo;
         }else{
             raiz = InsertarAVL(nuevo, raiz);
         }
         
     }
     
//RECORRIDOS
     //Recorrer Inorden
     public void InOrden(NodoArbol r){
         if(r != null){
             InOrden(r.HijoIzquierdo);
             System.out.print(r.dato+", ");
             InOrden(r.HijoIzquierdo);
         }
     }
     //Recorrido PreOrden
     public void PreOrden(NodoArbol r){
          if(r != null){
             System.out.print(r.dato+", ");
              PreOrden(r.HijoIzquierdo);
              PreOrden(r.HijoDerecho);
         }
     }
     //Recorrido PostOrden
     public void PostOrden(NodoArbol r){
         if (r != null){
            PostOrden(r.HijoIzquierdo);
            PostOrden(r.HijoDerecho);
             System.out.print(r.dato+", ");
         }
     }
     
}
