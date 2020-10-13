import com.geobro.project.Phone;
import java.io.*;
import java.net.ServerSocket;

/**
 * 11/02/2020 GGB
 *
 */

public class Server {

    public static void main(String[] args){

        // Open socket port
        try (ServerSocket server = new ServerSocket(8000))
        {
            System.out.println("Server started!");

            while (true)
                try(Phone phone = new Phone(server)){

                    String request = phone.readLine();
                    System.out.println("Request" + request);

                         // Example temperature
                        String response = (int)(Math.random()*30-10) + " ";

                    phone.writeLine(response);
                    System.out.println("Response" + response);
                }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}