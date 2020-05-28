
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class PhoneBook {

    private ConcurrentMap<String, String> contacts = new ConcurrentHashMap<String, String>();

    String serverIP = "10.0.2.15";
    int port = 8715;

}
