package Punto3;

public class MainRequests {

    private static Queue<Request> sampleQueue() {
        Queue<Request> pending = new Queue<>();
        pending.enqueue(new Request("S1", Request.Priority.NORMAL, 10));
        pending.enqueue(new Request("S2", Request.Priority.HIGH, 30));
        pending.enqueue(new Request("S3", Request.Priority.HIGH, 15));
        pending.enqueue(new Request("S4", Request.Priority.NORMAL, 5));
        return pending;
    }

    // Prints the queue without destroying it (one full rotation)
    private static void print(String title, Queue<Request> queue) {
        System.out.print(title + " (frente -> final): ");
        int n = queue.size();
        for (int i = 0; i < n; i++) {
            Request r = queue.dequeue();
            System.out.print(r + (i < n - 1 ? " -> " : ""));
            queue.enqueue(r);
        }
        System.out.println(n == 0 ? "(vacia)" : "");
    }

    public static void main(String[] args) {
        int[] tests = {25, 60, 4, 0};
        for (int minutes : tests) {
            Queue<Request> pending = sampleQueue();
            System.out.println("== Minutos disponibles: " + minutes);
            Queue<Request> selected = RequestScheduler.seleccionarSolicitudes(pending, minutes);
            print("  Seleccionadas", selected);   // con 25: S3 -> S1
            print("  Pendientes   ", pending);    // con 25: S2 -> S4
        }
    }
}
