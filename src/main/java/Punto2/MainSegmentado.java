package Punto2;                                         // Paquete donde estan todas las clases

public class MainSegmentado {                             // Clase con el main de prueba

    public static void imprimir(String titulo, Pila<Operacion> pila) {  // Muestra una pila sin danarla
        Pila<Operacion> aux = new Pila<>();             // Auxiliar para restaurar la pila
        System.out.println(titulo + " (tope -> fondo):");  // Imprime el titulo
        while (!pila.isEmpty()) {                       // Mientras queden elementos
            Operacion op = pila.pop();                  // Saca el del tope
            System.out.println("  " + op);              // Lo imprime
            aux.push(op);                               // Lo guarda en aux
        }
        while (!aux.isEmpty()) {                        // Mientras aux tenga elementos
            pila.push(aux.pop());                       // Los devuelve a la pila original
        }
    }

    public static void main(String[] args) {            // Punto de entrada del programa
        Pila<Operacion> acciones = new Pila<>();        // Crea la pila de acciones
        acciones.push(new Operacion("A1", Estado.CONFIRMADA));  // A1 queda en el fondo
        acciones.push(new Operacion("A2", Estado.CONFIRMADA));  // Apila A2
        acciones.push(new Operacion("A3", Estado.CONFIRMADA));  // Apila A3
        acciones.push(new Operacion("A4", Estado.CONFIRMADA));  // Apila A4
        acciones.push(new Operacion("A5", Estado.CONFIRMADA));  // Apila A5
        acciones.push(new Operacion("A6", Estado.CONFIRMADA));  // A6 queda en el tope

        imprimir("Original", acciones);                 // Muestra la pila original

        imprimir("Segmento 2 a 4", Segmentado.obtenerSegmento(acciones, 2, 4));  // Debe dar A5, A4, A3
        imprimir("Segmento 3 a 3", Segmentado.obtenerSegmento(acciones, 3, 3));  // Debe dar solo A4
        imprimir("Segmento 1 a 6", Segmentado.obtenerSegmento(acciones, 1, 6));  // Debe dar todas

        System.out.println("Segmento 0 a 2 vacia? " + Segmentado.obtenerSegmento(acciones, 0, 2).isEmpty());   // inicio < 1: true
        System.out.println("Segmento 3 a 2 vacia? " + Segmentado.obtenerSegmento(acciones, 3, 2).isEmpty());   // inicio > fin: true
        System.out.println("Segmento 4 a 10 vacia? " + Segmentado.obtenerSegmento(acciones, 4, 10).isEmpty()); // fin muy grande: true

        imprimir("Original despues", acciones);         // Comprueba que la original no cambio
    }
}