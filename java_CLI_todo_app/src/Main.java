import java.util.Scanner;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TodoList todoList = new TodoList();

        todoList.loadFromFile();

        while (true) {

            System.out.println("\nCommands: add, list, list open, list done, search, done, remove, exit");
            System.out.print("> ");

            String command = scanner.nextLine();

            switch (command) {

                case "add":

                    System.out.print("Task: ");
                    String task = scanner.nextLine();

                    System.out.print("Priority (1-5): ");
                    int priority = Integer.parseInt(scanner.nextLine());

                    System.out.print("Due date (YYYY-MM-DD): ");
                    LocalDate dueDate = LocalDate.parse(scanner.nextLine());

                    todoList.addTodo(task, priority, dueDate);
                    break;

                case "list":
                    todoList.listTodos();
                    break;

                case "list open":
                    todoList.listOpenTodos();
                    break;

                case "list done":
                    todoList.listDoneTodos();
                    break;

                case "search":

                    System.out.print("Keyword: ");
                    String keyword = scanner.nextLine();

                    todoList.searchTodos(keyword);
                    break;

                case "done":

                    System.out.print("Index: ");
                    int doneIndex = Integer.parseInt(scanner.nextLine());

                    todoList.markDone(doneIndex);
                    break;

                case "remove":

                    System.out.print("Index: ");
                    int removeIndex = Integer.parseInt(scanner.nextLine());

                    todoList.removeTodo(removeIndex);
                    break;

                case "exit":

                    todoList.saveToFile();
                    System.out.println("Todos saved.");
                    System.out.println("Bye!");
                    return;

                default:
                    System.out.println("Unknown command.");
            }
        }
    }
}