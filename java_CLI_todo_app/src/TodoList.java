import java.util.ArrayList;
import java.util.Comparator;
import java.io.*;
import java.time.LocalDate;

public class TodoList {

    private ArrayList<Todo> todos;
    private final String FILE_NAME = "todos.txt";

    public TodoList() {

        todos = new ArrayList<>();
    }

    public void addTodo(String task, int priority, LocalDate dueDate) {

        todos.add(new Todo(task, priority, dueDate));

        todos.sort(Comparator.comparing(Todo::getPriority));

        System.out.println("Todo added.");
    }

    public void listTodos() {

        if (todos.isEmpty()) {

            System.out.println("No todos available.");
            return;
        }

        for (int i = 0; i < todos.size(); i++) {

            System.out.println(i + ": " + todos.get(i));
        }
    }

    public void listOpenTodos() {

        for (int i = 0; i < todos.size(); i++) {

            Todo todo = todos.get(i);

            if (!todo.isDone()) {

                System.out.println(i + ": " + todo);
            }
        }
    }

    public void listDoneTodos() {

        for (int i = 0; i < todos.size(); i++) {

            Todo todo = todos.get(i);

            if (todo.isDone()) {

                System.out.println(i + ": " + todo);
            }
        }
    }

    public void searchTodos(String keyword) {

        keyword = keyword.toLowerCase();

        for (int i = 0; i < todos.size(); i++) {

            Todo todo = todos.get(i);

            if (todo.getTask().toLowerCase().contains(keyword)) {

                System.out.println(i + ": " + todo);
            }
        }
    }

    public void markDone(int index) {

        if (index >= 0 && index < todos.size()) {

            todos.get(index).setDone(true);
            System.out.println("Todo marked as done.");

        } else {

            System.out.println("Invalid index.");
        }
    }

    public void removeTodo(int index) {

        if (index >= 0 && index < todos.size()) {

            todos.remove(index);
            System.out.println("Todo removed.");

        } else {

            System.out.println("Invalid index.");
        }
    }

    public void saveToFile() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Todo todo : todos) {

                writer.write(
                        todo.getTask() + ";" +
                                todo.getPriority() + ";" +
                                todo.isDone() + ";" +
                                todo.getDueDate()
                );

                writer.newLine();
            }

        } catch (IOException e) {

            System.out.println("Error saving todos.");
        }
    }

    public void loadFromFile() {

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(";");

                String task = parts[0];
                int priority = Integer.parseInt(parts[1]);
                boolean done = Boolean.parseBoolean(parts[2]);
                LocalDate dueDate = LocalDate.parse(parts[3]);

                Todo todo = new Todo(task, priority, dueDate);
                todo.setDone(done);

                todos.add(todo);
            }

        } catch (IOException e) {

            System.out.println("No save file found.");
        }
    }
}