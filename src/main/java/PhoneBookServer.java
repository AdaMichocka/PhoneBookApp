import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class PhoneBookServer {

    static final int PORT_NUMBER = 8715;
    private PhoneBook phoneBook = new PhoneBook();
    private ServerSocket serverSocket = null;

    public static void main(String[] args) {
        new PhoneBookServer();
    }

    public PhoneBookServer() {
        try {
            serverSocket = new ServerSocket((PORT_NUMBER));
            System.out.println("Serwer uruchomiony na porcie " + PORT_NUMBER);

            while (true) {
                if (serverSocket.isClosed()) break;
                Socket socket = serverSocket.accept();
                if (socket != null) {
                    System.out.println("Połączenie nawiązane");
                    serviceClient(socket);
                } else break;

            }
            if (serverSocket.isClosed() == false) {
                serverSocket.close();
                serverSocket = null;
                System.out.println("Serwer został zamknięty");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serviceClient(Socket socket) {
        Scanner scanner;
        PrintWriter out;
        String line, response = "";
        String[] command;

        try {
            scanner = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream());

            while ((line = scanner.nextLine()) != null) {
                System.out.println("Server: <<== " + line);
                command = line.split(" +");
                if (command[0].equals("LOAD")) {
                    // response = phoneBook.LOAD(command[1]);
                } else if (command[0].equals("XXX")) {
                    //response next orders
                } else {
                    response = "ERROR Nieznana komenda";
                }
                System.out.println("Server: ==>> " + response);
                out.println((response));
                out.flush();
                if (command[0].equals("BYE")) break;
            }
            scanner.close();
            out.close();
            socket.close();
            System.out.println("Połączenie z klientem zostało zamknięte");

        } catch (
                IOException e) {
        }
    }
}
