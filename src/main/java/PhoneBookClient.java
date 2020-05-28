import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.rmi.UnknownHostException;

public class PhoneBookClient {
    public static void main(String[] args) {
        new PhoneBookClient();
    }

    public PhoneBookClient() {
        try {
            String serverHost = "10.0.2.15";
            int serverPort = 8715;

            Socket socket = new Socket(serverHost, serverPort);

            OutputStream sockOut = socket.getOutputStream();
            InputStream sockIn = socket.getInputStream();

            //wysłanie zlecenia do serwera
            //sockOut.write();

            //odczyta odpowiedzi serwera
            sockIn.read();

            sockOut.close();
            sockIn.close();
            socket.close();

        } catch (UnknownHostException e) {

        } catch (SocketException e) {

        } catch (IOException e) {

        }
    }
}
