package configuration;

public class Configuration {

    private Configuration() {
    }

    public static String getProperties(String key) {
        return Environment.getCurrentData().getValue("/" + key).toString();
    }
}