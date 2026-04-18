import java.io.*;
import java.util.Properties;

public class ConfigManager {

    private Properties props = new Properties();
    private final String filePath;

    public ConfigManager(String filePath) {
        this.filePath = filePath;
        load();
    }

    public void load() {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            props.load(fis);
        } catch (IOException e) {
            System.out.println("Config file not found. Generating new config file.");
        }
    }

    public void save() {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            props.store(fos, "Config Manager");
        } catch (IOException e) {
            System.out.println("Error while saving file.");
        }
    }

    public String get(String key) {
        return props.getProperty(key);
    }

    public void set(String key, String value) {
        props.setProperty(key, value);
    }

    public void list() {
        props.forEach((k, v) -> System.out.println(k + " = " + v));
    }
}
