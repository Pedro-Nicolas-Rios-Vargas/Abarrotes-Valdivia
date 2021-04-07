/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;


public class Nodo<T> {
    private T valor;
    private Nodo<T> siguiente;
    
    public Nodo(T valor){
        this.valor = valor;
        siguiente = null;
    }
    
    public void setValor(T valor){
        this.valor = valor;
    }
    
    public T getValor(){
        return valor;
    }
    
    public void setSiguiente(Nodo<T> valor){
        this.siguiente = valor;
    }
    
    public Nodo<T> getSiguiente(){
        return siguiente;
    }
}
