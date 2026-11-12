# Cómo correr el Parcial 2 en IntelliJ

## Abrir el proyecto (una sola vez)
1. Descomprime `Parcial2-main.zip` en una carpeta normal, por ejemplo `Documentos\Parcial2-main`. Evita dejarlo dentro de OneDrive o de otro proyecto.
2. En IntelliJ: **File → Open…**, selecciona la carpeta `Parcial2-main` (la que tiene el `pom.xml`) y dale **OK**. Si pregunta, elige **Open as Project** y **Trust Project**.
3. Espera a que termine de cargar Maven (la barra de abajo a la derecha).
4. Si sale un aviso amarillo de "Project JDK is not defined", haz clic en **Setup SDK** y escoge cualquier JDK 17 o superior que tengas.

## Correr cada punto
Abre el archivo indicado en `src/main/java` y haz clic en el triángulo verde ▶ que aparece al lado de `public static void main`.

| Punto | Archivo a correr | Qué debe mostrar |
|---|---|---|
| 1 | `Punto1/Main.java` | n = 2 → O5 arriba y O3 debajo; el historial queda igual |
| 2 | `Punto2/MainSegmentado.java` | Segmento 2 a 4 → A5, A4, A3; la original queda igual |
| 3 | `Punto3/MainRequests.java` | Con 25 min: seleccionadas S3 → S1, pendientes S2 → S4 |
| 4 | `Punto4A/MainTree.java` | Rango [35, 62] = 4; inorden final tras eliminar 50: 20 30 40 55 60 65 70 80 |

## Si algo sale en rojo
- **Build → Rebuild Project.**
- Clic derecho en `pom.xml` → **Maven → Reload Project.**
- Si sigue: **File → Invalidate Caches… → Invalidate and Restart.**

## Qué se mejoró respecto a la versión original
- **Punto 1:** no compilaba porque usaba clases de `Punto2`; ahora usa las suyas. Además el ciclo se detiene apenas encuentra las n confirmadas.
- **Puntos 1 y 2:** todas las clases son `public`.
- **Punto 3:** el método se llama `seleccionarSolicitudes`, como en el enunciado, y se agregó `MainRequests` con el ejemplo.
- **Punto 4:** el método se llama `contarEquiposEnRango`; se agregó el inciso b (eliminar con el mayor de la izquierda, recorrido inorden) y `MainTree`.
- `pom.xml`: se cambió la versión de Java de 27 a 17 para que funcione con cualquier JDK desde el 17.
