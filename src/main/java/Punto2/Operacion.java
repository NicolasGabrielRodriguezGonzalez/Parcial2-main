package Punto2;

public class Operacion {                                       // Representa una operacion del historial
    String codigo;                                      // Codigo de la operacion (ej: "O5")
    Estado estado;                                      // Estado: CONFIRMADA o ANULADA

    public Operacion(String codigo, Estado estado) {           // Constructor con codigo y estado
        this.codigo = codigo;                           // Guarda el codigo
        this.estado = estado;                           // Guarda el estado
    }                                                   // Fin del constructor

    @Override                                          // Redefinimos un metodo de Object
    public String toString() {                          // Como se imprime la operacion
        return codigo + " (" + estado + ")";            // Formato: O5 (CONFIRMADA)
    }                                                   // Fin de toString
}                                                       // Fin de Operacion