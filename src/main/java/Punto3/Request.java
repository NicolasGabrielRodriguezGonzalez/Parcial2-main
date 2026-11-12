package Punto3;

public class Request {

    // ALTA = HIGH, NORMAL = NORMAL
    public enum Priority { HIGH, NORMAL }

    private final String code;
    private final Priority priority;
    private final int durationMinutes;

    public Request(String code, Priority priority, int durationMinutes) {
        // Duration must be a positive integer (statement requirement)
        if (durationMinutes <= 0) {
            throw new IllegalArgumentException("Duration must be a positive integer");
        }
        this.code = code;
        this.priority = priority;
        this.durationMinutes = durationMinutes;
    }

    public String getCode() { return code; }
    public Priority getPriority() { return priority; }
    public int getDurationMinutes() { return durationMinutes; }

    @Override
    public String toString() {
        return code + " (" + priority + ", " + durationMinutes + " min)";
    }
}