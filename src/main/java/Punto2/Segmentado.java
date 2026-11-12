package Punto2;                                         // Paquete donde estan todas las clases

public class Segmentado {                                 // Clase que contiene la funcion del parcial

    public static <T> Pila<T> obtenerSegmento(Pila<T> pila, int inicio, int fin) {  // Recibe la pila y las posiciones
        Pila<T> resultado = new Pila<>();               // Pila donde se arma la respuesta
        if (pila == null || inicio < 1 || inicio > fin) return resultado;  // Posiciones invalidas: devuelve vacia

        Pila<T> aux = new Pila<>();                     // Auxiliar para restaurar la original
        Pila<T> temp = new Pila<>();                    // Guarda el segmento (queda al reves)
        int pos = 0;                                    // Posicion actual desde el tope

        while (!pila.isEmpty() && pos < fin) {          // Mientras queden elementos y no pase de fin
            T dato = pila.pop();                        // Saca el elemento del tope
            aux.push(dato);                             // Lo guarda en aux para no perderlo
            pos++;                                      // Avanza a la siguiente posicion
            if (pos >= inicio) {                        // Si ya esta dentro del segmento
                temp.push(dato);                        // Lo guarda en temp
            }
        }

        while (!aux.isEmpty()) {                        // Mientras aux tenga elementos
            pila.push(aux.pop());                       // Los devuelve a la original (queda igual)
        }

        if (pos < fin) return resultado;                // Si la pila se acabo antes de fin, devuelve vacia

        while (!temp.isEmpty()) {                       // Mientras temp tenga elementos
            resultado.push(temp.pop());                 // Los pasa a resultado (inicio queda en el tope)
        }

        return resultado;                               // Devuelve el segmento
    }
}