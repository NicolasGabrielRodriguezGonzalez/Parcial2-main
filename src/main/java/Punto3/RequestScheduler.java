package Punto3;

public class RequestScheduler {

    public static Queue<Request> seleccionarSolicitudes(Queue<Request> pendingRequests, int availableMinutes) {
        Queue<Request> selectedRequests = new Queue<>();

        // No time available: return empty queue and leave pending requests untouched
        if (availableMinutes <= 0 || pendingRequests == null) {
            return selectedRequests;
        }

        int remainingMinutes = availableMinutes;
        Request.Priority[] priorityOrder = { Request.Priority.HIGH, Request.Priority.NORMAL };

        for (Request.Priority targetPriority : priorityOrder) {
            // Freeze the number of cycles: the queue size changes during the pass
            int cycles = pendingRequests.size();

            for (int i = 0; i < cycles; i++) {
                Request request = pendingRequests.dequeue();

                if (request.getPriority() == targetPriority
                        && request.getDurationMinutes() <= remainingMinutes) {
                    // Selected: it leaves the pending queue and joins the result
                    selectedRequests.enqueue(request);
                    remainingMinutes -= request.getDurationMinutes();
                } else {
                    // Not selected: rotate it to the back to keep relative order
                    pendingRequests.enqueue(request);
                }
            }
        }

        return selectedRequests;
    }
}