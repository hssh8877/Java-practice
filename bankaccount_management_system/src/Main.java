import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    private static List<Account> accounts = new ArrayList<>();
    private static Account currentAccount = null;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Create new account");
            System.out.println("2. Select account");
            System.out.println("3. Show all accounts");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Show Balance");
            System.out.println("7. Show History");
            System.out.println("8. Save all accounts");
            System.out.println("9. Load all accounts");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    createAccount(scanner);
                    break;

                case 2:
                    selectAccount(scanner);
                    break;

                case 3:
                    showAllAccounts();
                    break;

                case 4:
                    if (checkAccountSelected()) {
                        System.out.print("Enter deposit amount: ");
                        BigDecimal depAmount = scanner.nextBigDecimal();
                        currentAccount.deposit(depAmount);
                    }
                    break;

                case 5:
                    if (checkAccountSelected()) {
                        System.out.print("Enter withdrawal amount: ");
                        BigDecimal wAmount = scanner.nextBigDecimal();
                        currentAccount.withdraw(wAmount);
                    }
                    break;

                case 6:
                    if (checkAccountSelected()) {
                        currentAccount.showBalance();
                    }
                    break;

                case 7:
                    if (checkAccountSelected()) {
                        currentAccount.showHistory();
                    }
                    break;

                case 8:
                    saveAllAccounts(scanner);
                    break;

                case 9:
                    loadAllAccounts(scanner);
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void createAccount(Scanner scanner) {
        System.out.print("Enter owner name: ");
        String owner = scanner.nextLine();

        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        Account acc = new Account(owner, accountNumber);
        accounts.add(acc);
        currentAccount = acc;

        System.out.println("New account created and selected.");
    }

    private static void selectAccount(Scanner scanner) {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        System.out.println("Available accounts:");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(i + ": " + accounts.get(i).getOwner() +
                    " (" + accounts.get(i).getAccountNumber() + ")");
        }

        System.out.print("Select account index: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 0 && index < accounts.size()) {
            currentAccount = accounts.get(index);
            System.out.println("Account selected.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    private static void showAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        System.out.println("All accounts:");
        for (Account acc : accounts) {
            System.out.println(acc.getOwner() + " - " + acc.getAccountNumber());
        }
    }

    private static boolean checkAccountSelected() {
        if (currentAccount == null) {
            System.out.println("No account selected.");
            return false;
        }
        return true;
    }

    private static void saveAllAccounts(Scanner scanner) {
        System.out.print("Enter filename to save (e.g. accounts.json): ");
        String filename = scanner.nextLine();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(accounts, writer);
            System.out.println("All accounts saved.");
        } catch (IOException e) {
            System.out.println("Error saving accounts: " + e.getMessage());
        }
    }

    private static void loadAllAccounts(Scanner scanner) {
        System.out.print("Enter filename to load: ");
        String filename = scanner.nextLine();

        Gson gson = new Gson();

        try (FileReader reader = new FileReader(filename)) {
            Account[] loaded = gson.fromJson(reader, Account[].class);

            accounts.clear();
            for (Account acc : loaded) {
                accounts.add(acc);
            }

            currentAccount = accounts.isEmpty() ? null : accounts.get(0);

            System.out.println("Accounts loaded successfully.");

        } catch (IOException e) {
            System.out.println("Error loading accounts: " + e.getMessage());
        }
    }
}
