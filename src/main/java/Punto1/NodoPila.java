package Punto1;

public class NodoPila<T> {                                     // Nodo generico exclusivo de la pila
    T dato;                                             // Dato que guarda el nodo
    NodoPila<T> sig;                                    // Enlace al nodo de abajo

    public NodoPila(T dato) {                                  // Constructor: recibe el dato
        this.dato = dato;                               // Guarda el dato
    }                                                   // Fin del constructor
}                                                       // Fin de NodoPila