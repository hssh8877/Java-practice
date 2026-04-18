import java.util.Scanner;

public class Menu {

    private final ConfigManager config = new ConfigManager("config.properties");
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n=== Config Manager ===");
            System.out.println("1 - Show All");
            System.out.println("2 - Read value");
            System.out.println("3 - Set value");
            System.out.println("4 - Save");
            System.out.println("5 - Exit");
            System.out.print("Selection: ");

            String input = scanner.nextLine();

            switch (input) {
                case "1" -> config.list();
                case "2" -> readValue();
                case "3" -> setValue();
                case "4" -> config.save();
                case "5" -> {
                    System.out.println("Exiting program...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void readValue() {
        System.out.print("Key: ");
        String key = scanner.nextLine();
        System.out.println("Value: " + config.get(key));
    }

    private void setValue() {
        System.out.print("Key: ");
        String key = scanner.nextLine();

        System.out.print("New Value: ");
        String value = scanner.nextLine();

        config.set(key, value);
        System.out.println("Value set.");
    }
}

