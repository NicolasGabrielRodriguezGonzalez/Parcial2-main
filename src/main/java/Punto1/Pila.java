package Punto1;

public class Pila<T> {                                         // Pila generica hecha con nodos enlazados
    private NodoPila<T> tope;                           // Nodo de arriba (null si esta vacia)

    public boolean isEmpty() {                          // Dice si la pila esta vacia
        return tope == null;                            // Vacia si no hay tope
    }                                                   // Fin de isEmpty

    public void push(T dato) {                          // Apila un dato
        NodoPila<T> nuevo = new NodoPila<>(dato);       // Crea el nodo nuevo
        nuevo.sig = tope;                               // El nuevo apunta al antiguo tope
        tope = nuevo;                                   // El nuevo pasa a ser el tope
    }                                                   // Fin de push

    public T pop() {                                    // Saca y devuelve el tope
        if (isEmpty()) return null;                     // Si esta vacia, devuelve null
        T dato = tope.dato;                             // Guarda el dato del tope
        tope = tope.sig;                                // El tope baja un nodo
        return dato;                                    // Devuelve el dato
    }                                                   // Fin de pop

    public T peek() {                                   // Mira el tope sin sacarlo
        return isEmpty() ? null : tope.dato;            // Dato del tope, o null si esta vacia
    }                                                   // Fin de peek
}                                                       // Fin de Pila