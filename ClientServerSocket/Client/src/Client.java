import com.geobro.project.Phone;
import java.io.*;

/**
 * 11/02/2020 GGB
 */

public class Client {

    public static void main(String[] args) {

        try (Phone phone = new Phone("127.0.0.1", 8000)) {
            System.out.println("Connected to server");

            // Send request to the server
            String request = "Hello for everyone";
            System.out.println(" Request: " + request);
            phone.writeLine(request);

            // Get the answer from the server and read
            String response = phone.readLine();
            System.out.println("Response" + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
