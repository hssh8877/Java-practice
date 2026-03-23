import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private String owner;
    private String accountNumber;
    private BigDecimal balance = BigDecimal.ZERO;
    private List<String> history = new ArrayList<>();

    private String currency = "$";

    public Account(String owner, String accountNumber) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.history.add("Account created at: " + LocalDateTime.now());
    }

    private String formatAmount(BigDecimal amount) {
        return currency + " " + amount.setScale(2, RoundingMode.HALF_UP);
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
        history.add("Deposited: " + formatAmount(amount) + " at " + LocalDateTime.now());
    }

    public void withdraw(BigDecimal amount) {
        if (balance.compareTo(amount) >= 0) {
            balance = balance.subtract(amount);
            history.add("Withdrew: " + formatAmount(amount) + " at " + LocalDateTime.now());
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void showBalance() {
        System.out.println("Your balance: " + formatAmount(balance));
    }

    public void showHistory() {
        System.out.println("Transaction history:");
        for (String entry : history) {
            System.out.println(entry);
        }
    }

    public void saveToFile(String filename) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(this, writer);
            System.out.println("Account saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving account: " + e.getMessage());
        }
    }

    public static Account loadFromFile(String filename) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filename)) {
            return gson.fromJson(reader, Account.class);
        } catch (IOException e) {
            System.out.println("Error loading account: " + e.getMessage());
            return null;
        }
    }
    public String getOwner() {
        return owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

}
