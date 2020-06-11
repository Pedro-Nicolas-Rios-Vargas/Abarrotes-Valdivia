package lista;

/**
 * Almacenamiento de objetos en una lista con acceso a los datos
 * en forma de una estructura de cola.
 * 
 * @param <T> Tipo de elemento almacenado en la lista.
 */
public class ListaCola<T> {
    private Nodo<T> raiz;
    private Nodo<T> puntero;
    
    /**
     * Ingresa un elemento en la lista.
     * 
     * @param valor El valor a almacenar.
     * @param <T>   Tipo de elemento almacenado en la lista.
     */
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
    
    /**
     * Saca un elemento de la lista.
     * 
     * @param <T> Tipo de elemento almacenado en la lista.
     * 
     * @return El primer elemento en la lista. 
     */
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
    /**
     * El metodo hasNext avisa si existe otro elemento en la lista.
     * 
     * @return  <b>true</b> si existe otro elemento en la lista, <b>false</b>
     *          si no.
     */
    public boolean hasNext(){
        return raiz != null;
    }
    
}
