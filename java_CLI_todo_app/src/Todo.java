import java.time.LocalDate;

public class Todo {

    private String task;
    private boolean done;
    private int priority;
    private LocalDate dueDate;

    public Todo(String task, int priority, LocalDate dueDate) {
        this.task = task;
        this.priority = priority;
        this.dueDate = dueDate;
        this.done = false;
    }

    public String getTask() { return task; }
    public boolean isDone() { return done; }
    public int getPriority() { return priority; }
    public LocalDate getDueDate() { return dueDate; }
    public void setDone(boolean done) { this.done = done; }

    @Override
    public String toString() {
        // Check if overdue
        boolean overdue = !done && dueDate.isBefore(LocalDate.now());

        return (overdue ? "[!] " : (done ? "[x] " : "[ ] "))
                + "(prio " + priority + ") "
                + task
                + " - due " + dueDate;
    }
}