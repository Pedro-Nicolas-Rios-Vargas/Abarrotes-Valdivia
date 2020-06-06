/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;


public class ListaCola<T> {
    private Nodo<T> raiz;
    private Nodo<T> puntero;
    
    public void push(T valor){
        Nodo<T> nuevo = new Nodo<>(valor);
        
        if(raiz == null){
            raiz = nuevo;
            puntero = raiz;
        }else{
            puntero.setSiguiente(nuevo);
            puntero = puntero.getSiguiente();
        }
    }
    
    public T pop(){
        T value = null;
        Nodo<T> aux = null;
        if(raiz == null)
            return null;
        
        aux = raiz.getSiguiente();
        value = raiz.getValor();
        raiz.setSiguiente(null);
        raiz = aux;
        
        return value;
    }
    
    public boolean hasNext(){
        return raiz != null;
    }
}
